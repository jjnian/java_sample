package collection.list.time;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *  只是添加元素，ArrayList好
 *  频繁的删除中间元素，LinkedList好
 */
public class LIstTime {
    public static void main(String[] args) {
        long num = 300000000;
        test2(num);
    }

    // 只添加
    public static void test(Long num){
        ArrayList<String> strings = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < num; i++) {
            strings.add("jiruixin");
            if (i>1000){
                strings.remove(2);
            }
        }
        System.out.println(System.currentTimeMillis()-start);

        long start1 = System.currentTimeMillis();
        LinkedList<String> strings1 = new LinkedList<>();
        for (long k = 0; k < num; k++) {
            strings1.add("jiruixin");
            if (k > 1000){
                strings1.remove(2);
            }
        }
        System.out.println(System.currentTimeMillis()-start1);
    }

    // 添加元素，删除头部元素
    public static void test1(Long num){
        ArrayList<String> strings = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < num; i++) {
            strings.add("jiruixin");
            if (i>10000){
                strings.remove(10000);
            }
        }
        System.out.println(System.currentTimeMillis()-start);

        long start1 = System.currentTimeMillis();
        LinkedList<String> strings1 = new LinkedList<>();
        for (long k = 0; k < num; k++) {
            strings1.add("jiruixin");
            if (k > 10000){
                strings1.remove(10000);
            }
        }
        System.out.println(System.currentTimeMillis()-start1);
    }

    // 添加元素，删除头部元素
    public static void test2(Long num){
        ArrayList<String> strings = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < num; i++) {
            strings.add("jiruixin");
            if (i>1000){
                strings.remove(0);
            }
        }
        System.out.println(System.currentTimeMillis()-start);

        long start1 = System.currentTimeMillis();
        LinkedList<String> strings1 = new LinkedList<>();
        for (long k = 0; k < num; k++) {
            strings1.add("jiruixin");
            if (k > 1000){
                strings1.remove(0);
            }
        }
        System.out.println(System.currentTimeMillis()-start1);
    }

    // 添加就删除
    public static void test3(Long num){
        ArrayList<String> strings = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < num; i++) {
            strings.add("jiruixin");
            strings.remove(0);
        }
        System.out.println(System.currentTimeMillis()-start);

        long start1 = System.currentTimeMillis();
        LinkedList<String> strings1 = new LinkedList<>();
        for (long k = 0; k < num; k++) {
            strings1.add("jiruixin");
            strings1.remove(0);
        }
        System.out.println(System.currentTimeMillis()-start1);
    }
}
