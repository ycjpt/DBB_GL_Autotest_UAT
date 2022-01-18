package com.hsbc.cmb.hk.dbb.utils;

import java.util.Random;

public class ContactUtil {

    private static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static String[] namesEn = {"Aaron","Alexander", "Albert","Alan",
            "Billy", "Blake", "Bob", "Bobby", "Brad", "Brant", "Brent",
            "Cary", "Caspar", "Cecil", "Charles", "Cheney", "Chris", "Christian",
            "Daniel", "Denny", "Darwin", "David", "Dennis", "Derek", "Dick",
            "Eddie", "Edgar", "Edison", "Edmund", "Edward", "Edwin", "Elijah",
            "Ford", "Francis", "Frank", "Franklin", "Fred", "Gabriel", "Gaby",
            "Hank", "Hardy", "Harrison", "Harry", "Hayden", "Henry", "Hugo",
            "Ian", "Ignativs", "Ivan", "Isaac", "Isaiah", "Jack", "Jackson",
            "Jacob", "James", "Jason", "Jay", "Jeffery", "Jerome", "Jerry",
            "Jesse", "Jim", "Jimmy", "Joe", "John", "Johnny", "Jonathan",
            "Keith", "Ken", "Kennedy", "Kenneth", "Kenny", "Kevin", "Kyle",
            "Lance", "Larry", "Laurent", "Lawrence", "Leander", "Lee", "Leo",
            "Marcus", "Marcy", "Mark", "Marks", "Mars", "Marshal", "Martin",
            "Michael", "Mickey", "Mike", "Nathan", "Nick", "Noah", "Norman",
            "Oliver", "Oscar", "Owen", "Patrick", "Paul", "Peter", "Philip",
            "Randall", "Randolph", "Randy", "Ray", "Raymond", "Rex", "Richard",
            "Sam", "Sammy", "Samuel", "Scott", "Sean", "Simon", "Steven",
            "Terence", "Terry", "Thomas", "Tim", "Timothy", "Tom", "Tony",
            "Victor", "Wesley", "William", "Zack", "Zachary", "Lisa", "Lucy",
            "Venus", "Vera", "Vicky", "Victoria", "Violet", "Vita", "Vivian"
    };
    private static final String[] email_suffix=("@gmail.com,@yahoo.com,@msn.com," +
            "@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com," +
            "@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com," +
            "@sina.com,@sohu.com,@yahoo.com.cn").split(",");

    private static String[] telFirst=("134,135,136,137,138,139,150,151,152,157,158," +
            "159,130,131,132,155,156,133,153").split(",");


    private static int getNum(int start, int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    /**
     * @return Random English Name
     */
    public static String getEnName(){
        int random = (int)(Math.random() * namesEn.length);
        return namesEn[random];
    }

    public static String getEnNameByLength(int length){
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<17;k++){
                    if(k%2==0){
                        int temp = random.nextInt(2)%2 == 0 ? 65 : 97;
                        val.append((char) (random.nextInt(26) + temp));
                    }else{
                        val.append(random.nextInt(10));
                    }
                }
                val.append(" ");
            }
        }
        return val.substring(0,length);
    }

    /**
     * Function: Get random email address
     * @param lMin:the min length of email
     * @param lMax:the max length of email
     * @return (random Email adddress)
     */
    public static String getEmail(int lMin,int lMax) {
        int length=getNum(lMin,lMax);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = (int)(Math.random()*base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);
        return sb.toString();
    }
    /**
     * Function: Random Phone Number
     * @return (random phone number)
     */
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }
}
