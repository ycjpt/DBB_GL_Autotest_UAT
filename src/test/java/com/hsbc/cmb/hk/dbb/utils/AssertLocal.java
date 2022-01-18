package com.hsbc.cmb.hk.dbb.utils;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;


public class AssertLocal extends Assert {

    protected AssertLocal() {

    }

    public static void assertTrue(String message, boolean condition) {
        Assert.assertTrue(message, condition);
    }

    public static void assertTrue(boolean condition) {
        assertTrue((String)null, condition);
    }

    public static void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition);
    }

    public static void assertFalse(boolean condition) {
        assertFalse((String)null, condition);
    }

    public static void fail(String message) {
        Assert.fail(message);
    }

    public static void fail() {
        fail((String)null);
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        Assert.assertEquals(message, expected, actual);
    }

    public static void assertEquals(Object expected, Object actual) {
        assertEquals((String)null, (Object)expected, (Object)actual);
    }

    public static void assertEquals(String message, double expected, double actual, double delta) {
        Assert.assertEquals(message, expected, actual, delta);

    }

    public static void assertEquals(String message, float expected, float actual, float delta) {
        Assert.assertEquals(message, expected, actual, delta);

    }

    public static void assertEquals(long expected, long actual) {
        assertEquals((String)null, expected, actual);
    }

    public static void assertEquals(String message, long expected, long actual) {
        Assert.assertEquals(message, expected, actual);

    }

    /** @deprecated */
    @Deprecated
    public static void assertEquals(double expected, double actual) {
        assertEquals((String)null, expected, actual);
    }

    /** @deprecated */
    @Deprecated
    public static void assertEquals(String message, double expected, double actual) {
        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertEquals(double expected, double actual, double delta) {
        assertEquals((String)null, expected, actual, delta);
    }

    public static void assertEquals(float expected, float actual, float delta) {
        assertEquals((String)null, expected, actual, delta);
    }

    public static void assertNotNull(String message, Object object) {
        Assert.assertNotNull(message, object != null);
    }

    public static void assertNotNull(Object object) {
        assertNotNull((String)null, object);
    }

    public static void assertNull(String message, Object object) {
        Assert.assertNull(message, object);
    }

    public static void assertNull(Object object) {
        assertNull((String)null, object);
    }

    public static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        assertThat("", actual, matcher);
    }

    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(reason, actual, matcher);
    }
}
