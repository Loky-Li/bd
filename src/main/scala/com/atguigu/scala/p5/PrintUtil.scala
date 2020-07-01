package com.atguigu.scala.p5

//需求：读取一个字符串，并将首字母以大写的格式打印
object PrintUtil {

    def main(args: Array[String]): Unit = {

        //验证函数inputTip的功能
        println(inputTip("zhangsan"))


    }

    //定义一个读取String并打印它首字母大写的函数
    def getFirstChar(s: String) = s.charAt(0).toUpper

    //定义一个验证输入字符串是否合法，并给出提示的方法
    def  inputTip(s:String)={
        if(s == null || s.length == 0){
            println("输入的字符串为空，请重新输入")
        }else
            getFirstChar(s)

    }




}
