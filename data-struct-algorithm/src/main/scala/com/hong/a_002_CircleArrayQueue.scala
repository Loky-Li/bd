package com.hong

import scala.io.StdIn

object a_002_CircleArrayQueue {
    def main(args: Array[String]): Unit = {
        // 初始化一个数组模拟的队列
        val queue = new CircleArrayQueue(4)
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

class CircleArrayQueue(arrayMaxSize:Int){
    val maxSize = arrayMaxSize
    private val arr = new Array[Int](maxSize)
    var front = 0  // 指向队列的头部,
    var rear = 0  // 指向队列的尾部,指向队列最后的数据的位置

    def isFull():Boolean = {
        (rear + 1) % maxSize == front
    }

    def isEmpty():Boolean = {
        front == rear
    }

    def addQueue(n:Int):Unit={
        if(isFull()){
            println("队列已满，无法添加")
            return
        }

        arr(rear) = n  // 由于rear起始值是 0
        // 添加后，rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize
    }

    def getQueue():Any = {
        if(isEmpty()){
            return new Exception("队列空...")
        }

        // 由于 front 初始值是0，已经指向了队列的头元素
        // 1. 先把front 对应的数据保存到变量中
        // 2. 将front 后移
        // 3. 返回前面保存的变量
        val value = arr(front)
        front = (front + 1) % maxSize
        return value

    }

    // todo 显示队列的所有数据
    def showQueue():Unit = {
        if(isEmpty()){
            println("队列空的，没有数据..")
            return
        }

//      思路：从front取，取出队列中存在的n个元素
        for(i <- front until front + size()){
            printf("arr[%d]=%d", i % maxSize, arr(i % maxSize))
        }
    }

    def size():Int = {
        (rear + maxSize - front) % maxSize
    }

    // todo 优化队列空间没有复用的问题
    def headQueue():Any = {
        if(isEmpty()){
            return new Exception("队列空..")
        }

        //这里注意，不改变front的值，只是查看
        return arr(front)

    }
}