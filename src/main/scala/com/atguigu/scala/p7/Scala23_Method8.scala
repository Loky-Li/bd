package com.atguigu.scala.p7

object Scala23_Method8 {
    def main(args: Array[String]): Unit = {

        //Scala中一般的算法都采用递归算法
        //但是递归容易出现StackOverFlowError


        def test(i : Int): Int = {
            if (i <= 1){
                1
            }else{
                i * test(i - 1)
            }
        }

        //Scala中使用尾递归的方式：结果也参与递归
        //将初始值确定后，从尾部开始倒推结果。编译后，其实是死循环




    }

}
