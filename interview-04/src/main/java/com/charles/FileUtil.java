package com.charles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chales.tang
 * @title FileUtil
 * @discription
 * @date 2021/7/12 9:25 下午
 */
public class FileUtil {

    /**
     * @Discription 读取英语单词库
     * @param url 单词库.txt的路径
     * @Return java.util.Set<java.lang.String>
     */
    public static Set<String> readWordList(String url) {
        Set<String> list = new HashSet<String>();

        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(url), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                list.add(ss[1]);
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            return null;
        }
        return list;
    }
}
