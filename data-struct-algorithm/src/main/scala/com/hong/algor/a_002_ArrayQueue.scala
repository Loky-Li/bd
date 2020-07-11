package com.hong.algor

import scala.io.StdIn

object a_002_ArrayQueue {
    def main(args: Array[String]): Unit = {
        // 初始化一个数组模拟的队列
        val queue = new ArrayQueue(3)
        var key = ""
        while(true){
            println("show: 显示队列")
            println("exit: 退出程序")
            println("add: 向队列添加一个元素")
            println("get: 获取队列的第一个元素")
            println("head: 查看队列的第一个元素")

            key = StdIn.readLine()
            key match {
                case "show" => queue.showQueue()
                case "add" => {
                    println("请输入一个元素")
                    val value:Int = StdIn.readInt()
                    queue.addQueue(value)
                }
                case "exit" => System.exit(0)
                case "get" => {
                    val res = queue.getQueue()
                    if(res.isInstanceOf[Exception]){
                        println(res.asInstanceOf[Exception].getMessage)
                    }else{
                        println(s"取出的数据是：  $res")
                    }
                }
                case "head" => {
                    val res = queue.headQueue()
                    if(res.isInstanceOf[Exception]){
                        println(res.asInstanceOf[Exception].getMessage)
                    }else{
                        println(s"队列的头元素是： $res")
                    }
                }
            }
        }
    }
}

class ArrayQueue(arrayMaxSize:Int){
    val maxSize = arrayMaxSize
    private val arr = new Array[Int](maxSize)
    var front = -1  // 指向队列的头部,指向最前数据的前一个位置。
    // （原因：没有取，不断加数据的时候，第一个加的数据的下标就是【0】，而此时front = -1）
    var rear = -1   // 指向队列的尾部,指向队列最后的数据的位置

    def isFull():Boolean = {
        rear == maxSize - 1
    }

    def isEmpty():Boolean = {
        front == rear
    }

    def addQueue(n:Int):Unit={
        if(isFull()){
            println("队列已满，无法添加")
            return
        }
        rear += 1  // 添加后，rear后移一位
        arr(rear) = n
    }

    def getQueue():Any = {
        if(isEmpty()){
            return new Exception("队列空...")
        }
        front +=1
        return arr(front)
    }

    // 显示队列的所有数据
    def showQueue():Unit = {
        if(isEmpty()){
            println("队列空的，没有数据..")
            return
        }

        for(i <- front+1 to rear){
            printf("arr[%d]=%d\n",i,arr(i))
        }
    }

    // todo 优化队列空间没有复用的问题
    def headQueue():Any = {
        if(isEmpty()){
            return new Exception("队列空..")
        }

        //这里注意，不改变front的值，只是查看
        return arr(front + 1)

    }
}