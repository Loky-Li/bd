package com.hong.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    public static void main(String[] args) {
        String str = "drainage=ZNZB,s_ua=browser,agentNo=0," +
                "source=LIFE-PAB,promotionLinkId=null," +
                "typeNo=3981543,senceRemark=我和xxx有个约会";

        String pattern1 = "drainage=ZNZB";                             //目标匹配
        String pattern2 = "typeNo=" + "([0-9]{7})";

        Pattern r1 = Pattern.compile(pattern1);
        Pattern r2 = Pattern.compile(pattern2);

        Matcher m1 = r1.matcher(str);
        Matcher m2 = r2.matcher(str);

        String res = "";
        if(m1.find() && m2.find()){

            System.out.println(m2.group(0));

            System.out.println(m2.group(1));

            res = m2.group(1);
        }
    }
}
