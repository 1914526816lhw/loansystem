package com.stu.test;

/**
 * ClassName：ListTest
 * Description：
 *
 * @author lihw
 * CreateTime: 2020/1/8 17:07
 * @version 1.0.0
 */
public class ListTest {



    public static void main(String[] args) {

        System.out.println(print(10));
    }

    private static boolean print(int num) {

        try{
            System.out.println(num/1);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
