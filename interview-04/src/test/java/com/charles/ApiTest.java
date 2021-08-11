package com.charles;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author chales.tang
 * @title ApiTest
 * @discription
 * @date 2021/7/12 9:24 下午
 */
public class ApiTest {

    private Set<String> words;

    @Before
    public void before() {

        int hashCode = "abc".hashCode();
        words = FileUtil.readWordList("/Users/super/IdeaProjects/interview_learning/docs/103976个英语单词库.txt");
    }

    @Test
    public void test_8hash() {

        List<String> list = new ArrayList<>();
        list.add("efcw");
        list.add("ervz");
        list.add("charles");
        list.add("ihbk");
        list.add("tnbf");
        list.add("pjfg");
        list.add("rvds");

        String[] tab = new String[8];

        for (String key : list) {
            int idx = key.hashCode() & (tab.length - 1);
            System.out.println(String.format("key值 = %s Idx = %d", key, idx));
            if (tab[idx] == null) {
                tab[idx] = key;
                continue;
            }
            tab[idx] = tab[idx] + "->" + key;
        }

        System.out.println(JSON.toJSONString(tab));
    }

    @Test
    public void test_disturb() {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (String word : words) {
            // 使用扰动函数
//            int idx = Disturb.disturbHashIdx(word, 128);

            // 不使用扰动函数
            int idx = Disturb.hashIdx(word, 128);
            if (hashMap.containsKey(idx)) {
                Integer integer = hashMap.get(idx);
                hashMap.put(idx, ++integer);
            } else {
                hashMap.put(idx, 1);
            }
        }
        System.out.println(hashMap.values());

    }

    @Test
    public void test_hashMap() {
        List<String> list = new ArrayList<>();

        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");
        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);

            System.out.println("字符串:" + key + " \tIdx(16): " + ((16 - 1) & hash) + " \tBit 值: " + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16) + " \t \tIdx(32):" +
                    ((32 - 1) & hash) + " \t" + Integer.toBinaryString(key.hashCode()) + " " + Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }
    }

    public static void main(String[] args) {
        int n = 16 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
    }

}
