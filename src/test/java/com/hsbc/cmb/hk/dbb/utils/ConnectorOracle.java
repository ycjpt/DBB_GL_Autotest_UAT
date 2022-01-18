package com.hsbc.cmb.hk.dbb.utils;

import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * ----------------------------------------------------------------
 * -*- coding: UTF-8 -*-
 * # @FileName:TestConnection.py
 * # @Date....:八月-21,2019 11:06
 * # #Author..:43864264
 * ----------------------------------------------------------------
 */

public class ConnectorOracle {
    InsightObject insightObject = new InsightObject();
    private EnvironmentVariables environmentVariables;

    private static final Logger LOGGER = LoggerFactory.getLogger(BDDUtil.class);
    public void DataProcessing(String env,ArrayList arrayList,Map map) throws IOException {
        //读取配置文件中的profile_ID
//        String PROFILE_ID = insightObject.PROFILE_ID.split("-")[1];
        if (!arrayList.isEmpty())
        {
            for (int i=0; i<arrayList.size(); i++)
            {
                //读取队列sql文件
                String sqlContent = FileUtils.readFileToString(new File((String) arrayList.get(i)), "UTF-8");
                //读取正则规则,自定义匹配替换
                Iterator iter = map.keySet().iterator();
                while (iter.hasNext()) {
                    Object key = iter.next();
                    Pattern pattern = Pattern.compile(key.toString());
                    //Pattern pattern = Pattern.compile(map.get(key).toString());
//                    Pattern pattern = Pattern.compile(key.toString());
                    Matcher matcher = pattern.matcher(sqlContent);
                    while (matcher.find())
                    {
                        sqlContent = sqlContent.replace(matcher.group(1),map.get(key).toString());
                    }
                }
                //调用数据库连接并插入data
                Connect(env,sqlContent);
            }
        }
    }

    //connection DB
    public Connection conectionDB(String DBUrl,String Userid,String userPassword){
        try{

            Connection con = null;

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(DBUrl, Userid, userPassword);
            System.out.println("----> Connection Success！");
            return con;
        }catch (Exception e){
            LOGGER.info("------------ connection oracle failed --------------------------------------");
            System.out.println("----------- connection oracle failed -----------");
            e.printStackTrace();
            return null;
        }

    }


    //run sql command,query table
    public ResultSet executeSQLQuery(Connection con,String sqlcommand){
        PreparedStatement pre;
        ResultSet rs;

        try{
            pre = con.prepareStatement(sqlcommand);
            rs = pre.executeQuery();
            LOGGER.info("------------ Query sql command successful !!! --------------------------------------");
            return rs;
        }catch (SQLException e) {
            LOGGER.info("------------ Query sql command failed !!! --------------------------------------");
            System.out.println("----------- Query sql command failed !!! -----------");
            e.printStackTrace();
            return null;
        }

    }

    //run sql command,update table
    public int executeSQLUpdate(Connection con,String sqlcommand){
        PreparedStatement pre;
        int result ;

        try{
            pre = con.prepareStatement(sqlcommand);
            result = pre.executeUpdate();
            LOGGER.info("------------ Updated sql command successsful !!! --------------------------------------");

            return result;
        }catch (SQLException e) {
            LOGGER.info("------------ Updated sql command failed !!! --------------------------------------");
            System.out.println("----------- Update sql command failed !!! -----------");
            e.printStackTrace();
            return 0;
        }

    }


    public void Connect(String env,String sql)
    {
        SQLExec sqlExec = new SQLExec();
        //设置数据库参数
        sqlExec.setDriver("oracle.jdbc.driver.OracleDriver");
        sqlExec.setUrl(CommonUtil.getEnvironmentSpecificConfiguration("DBConnectInfo."+env+".ConnectString"));
        sqlExec.setUserid(CommonUtil.getEnvironmentSpecificConfiguration("DBConnectInfo."+env+".Userid"));
        sqlExec.setPassword(CommonUtil.getEnvironmentSpecificConfiguration("DBConnectInfo."+env+".Password"));
        sqlExec.addText(sql);
        //有出错的语句该如何处理
        sqlExec.setOnerror((SQLExec.OnError) (EnumeratedAttribute.getInstance(SQLExec.OnError.class, "abort")));
        sqlExec.setPrint(true); //设置是否输出
        //输出到文件 sql.out 中；不设置该属性，默认输出到控制台
//            sqlExec.setOutput(new File("src/sql.out"));
        sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错
        sqlExec.execute();
    }

    public void connectToDatabase(String database, String userId, String password, String sql) {

        SQLExec sqlExec = new SQLExec();

        //设置数据库参数
        sqlExec.setDriver("oracle.jdbc.driver.OracleDriver");
        sqlExec.setUrl(CommonUtil.getEnvironmentSpecificConfiguration("DBConnectInfo."+database+".ConnectString"));
        sqlExec.setUserid(userId);
        sqlExec.setPassword(password);
        sqlExec.addText(sql);
        //有出错的语句该如何处理
        sqlExec.setOnerror((SQLExec.OnError) (EnumeratedAttribute.getInstance(SQLExec.OnError.class, "abort")));
        sqlExec.setPrint(true); //设置是否输出
        //输出到文件 sql.out 中；不设置该属性，默认输出到控制台
//            sqlExec.setOutput(new File("src/sql.out"));
        sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错
        sqlExec.execute();
    }

    public void dataProcess(String env, String userId, String password, ArrayList arrayList, Map map) throws IOException {
        //读取配置文件中的profile_ID
//        String PROFILE_ID = insightObject.PROFILE_ID.split("-")[1];
        if (!arrayList.isEmpty())
        {
            for (int i=0; i<arrayList.size(); i++)
            {
                //读取队列sql文件
                String sqlContent = FileUtils.readFileToString(new File((String) arrayList.get(i)), "UTF-8");
                //读取正则规则,自定义匹配替换
                Iterator iter = map.keySet().iterator();
                while (iter.hasNext()) {
                    Object key = iter.next();
                    Pattern pattern = Pattern.compile(key.toString());
                    //Pattern pattern = Pattern.compile(map.get(key).toString());
                    Matcher matcher = pattern.matcher(sqlContent);
                    while (matcher.find())
                    {
                        sqlContent = sqlContent.replace(matcher.group(1),map.get(key).toString());
                    }
                }
                //调用数据库连接并插入data
                connectToDatabase(env, userId, password, sqlContent);
            }
        }
    }
}
