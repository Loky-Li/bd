package com.atguigu.scala.p5

object Scala06_Function_Recursion {

    def main(args: Array[String]): Unit = {

        //todo 递归
        //1、函数调用自身
        //2、函数应该有跳出递归的逻辑
        //3、递归调用时的参数应该有规律
        // 如:求20以内的奇数求和，如果是随机数求和1,5,6,13，就使用不了递归）

        //Scala的特殊点：
        //4、递归函数不能省略返回值类型！（因为结果可能推断不出来，如下面的例子中
        // else后面不断调用的函数，每次都需要推断，而且很可能有类型从Int 到 Long的可能）

        //阶乘5！
        def test(num : Int) : Int = {
            if(num == 1){
                1
            }else{
                num * test(num -1)
            }
        }
        println(test(5))


    }

}
