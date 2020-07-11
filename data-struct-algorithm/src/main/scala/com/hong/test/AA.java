package com.hong.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AA {
    public static void main(String[] args) {

        // test case
        String str = "vivo123官网V3.2.0.3-abc其他";
        String str2 = "vivo123官网V3.2.0.3-abc456其他";
        String str3 = "vivo官网V3.2.0.3-abc456其他";
        String str4 = "vivo官网V3.284-abc456其他";
        String str5 = "vivo123官网V2345.848.0.3.3.8-abc456其他";

        // common regex
        // 目的：匹配出所有case中的版本字段
        // 如 "vivo123官网V345.2848.0.3.3.8-abc456其他" => "345.2848.0.3.3.8"
        String pattern = "(.*(\\d+)?\\D*)((\\d+\\.)+(\\d+))(\\D*)";     //todo 全匹配，容易出问题
        String pattern2 = "(\\d+\\.)+\\d+";                             //todo 目标匹配，直接取所需要的部分

        Pattern r = Pattern.compile(pattern2);

        Matcher m = r.matcher(str5);



        if (m.find()){
            System.out.println("0===" + m.group(0));
            System.out.println("1===" + m.group(1));
//            System.out.println("2:" + m.group(2));
//            System.out.println("3:" + m.group(3));
        }
    }
}
