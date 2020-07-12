package com.hong.algor

import scala.io.StdIn


object a_006_ArrayStack {
    def main(args: Array[String]): Unit = {

        val arrayStack = new ArrayStack(4)

        // 测试
        var key = ""
        while(true){
            println("show: 显示栈")
            println("exit: 退出程序")
            println("push: 向栈添加一个元素")
            println("pop: 获取栈的取出元素")

            key = StdIn.readLine()
            key match {
                case "show" => arrayStack.list()
                case "push" => {
                    println("请输入一个数")
                    val value = StdIn.readInt()
                    arrayStack.push(value)
                }
                case "pop" => {
                    val res = arrayStack.pop()
                    if(res.isInstanceOf[Exception]){
                        println(res.asInstanceOf[Exception].getMessage)
                    }else{
                        printf("取出的数为 %d\n", res)
                    }
                }
                case "exit" => {
                    System.exit(0)
                }
            }
        }

    }

}

class ArrayStack(size:Int){
    val maxSize = size
    var stack = new Array[Int](maxSize)

    // 栈顶，初始化为-1
    var top = -1

    // 栈满
    def isFull():Boolean = {
        top == maxSize -1
    }

    // 栈空
    def isEmpty():Boolean = {
        top == -1
    }

    // 入栈
    def push(value:Int) : Unit = {
        if(isFull()){
            println("栈满")
            return
        }

        top += 1
        stack(top) = value
    }

    // 出栈
    def pop(): Any = {
        if(isEmpty()){
            return new Exception("栈空")
        }

        val value =  stack(top)
        top -= 1
        return value
    }

    // 遍历栈
    def list():Unit = {
        if(isEmpty()){
            println("栈空，没有数据")
            return
        }
        for(i <- 0 to top reverse){
            printf("stack[%d]=%d\n", i, stack(i))
        }
    }
}
