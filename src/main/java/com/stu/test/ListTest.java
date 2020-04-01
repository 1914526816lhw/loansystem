package com.stu.test;


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
