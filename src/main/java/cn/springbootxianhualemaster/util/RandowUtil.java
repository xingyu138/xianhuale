package cn.springbootxianhualemaster.util;

public class RandowUtil {

    //生成随机数的方法
    public static String createRandowUtil() {

        return String.valueOf((int) (Math.random() * 1000000 + 100000));

    }

}
