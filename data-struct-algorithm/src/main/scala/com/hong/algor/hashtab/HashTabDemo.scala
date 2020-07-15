package com.hong.algor.hashtab

import scala.io.StdIn
import scala.util.control.Breaks
import util.control.Breaks._
// 拓展：1）一个id只能有一个   2）链表的展示有序
object HashTabDemo {
    def main(args: Array[String]): Unit = {
        val hashTab = new HashTab(7)
        var key = " "
        while(true){
            println("add: 添加雇员")
            println("show: 显示雇员")
            println("exit：退出系统")
            println("find：查找雇员")
            
            key = StdIn.readLine()
            key match {
                case "add" => {
                    println("输入id")
                    val id = StdIn.readInt()
                    println("输入名字")
                    val name = StdIn.readLine()
                    val emp = new Emp(id,name)
                    hashTab.add(emp)
                }
                case "show" => {
                    hashTab.show()
                }
                case "exit" => {
                    return new Exception("退出")
                }
                case "find" => {
                    println("输入要查找的雇员id：")
                    val id = StdIn.readInt()
                    hashTab.findEmpById(id)
                }
                case _=> {
                    println("输入的参数有误")
                    // todo 通过breakable 的方式实现continue功能
                    breakable{
                        if(true){
                            break()
                        }
                    }
                    
                }
            }
        }
    
    }
    
}

class Emp(eId:Int, eName:String){
    val id = eId
    var name = eName
    var next:Emp = null
}

class EmpLinkedList{
    var head:Emp = null
    
    // 添加雇员
    // 假定添加的雇员id是自增，即雇员分配的id总是从小到大
    // 找到链表的最后加入即可
    def add(emp:Emp):Unit={
        if(head == null){
            head = emp
            return
        }
        var cur = head
        Breaks.breakable{
            while (true) {
                if (cur.next == null) {
                    Breaks.break()
                }
            }
        }
        cur.next = emp
    }
    
    def show(i:Int):Unit = {
        if(head == null){
            println(s"第 ${i} 条链表为空")
            return
        }
        println(s"第 ${i} 条链表信息为：")
        var cur = head
        Breaks.breakable{
            while (true) {
                if (cur == null) {
                    Breaks.break()
                }
                printf("=> id=%d name=%s \t", cur.id, cur.name)
                cur = cur.next
            }
        }
        println()
    }
    
    def findEmpById(id:Int):Emp = {
        if(head == null){
            println("链表为空，没有数据~~")
            return null
        }
        var cur = head
        Breaks.breakable{
            while(true){
                if(cur == null){
                    Breaks.break()
                }
                if(cur.id == id){
                    Breaks.break()
                }
                cur = cur.next
            }
        }
        return cur
    }
}

class HashTab(val size:Int){
    val empLinkedListArr:Array[EmpLinkedList] = new Array[EmpLinkedList](size)
    
    // 初始化empLinkedListArr 里面各个元素的值
    for(i <- 0 until size){
        empLinkedListArr(i) = new EmpLinkedList
    }
    
    def add(emp:Emp):Unit = {
        // 返回该员工应该加入到那条链表
        val empLinkedListNo = hashFun(emp.id)
        this.empLinkedListArr(empLinkedListNo).add(emp)
    
    }
    
    // 散列函数
    def hashFun(id:Int):Int = {
        id % size
    }
    
    //
    def findEmpById(id:Int):Unit = {
        // 返回该员工，应该加入到哪条链表
        val empLinkedListNo = hashFun(id)
        val emp = this.empLinkedListArr(empLinkedListNo).findEmpById(id)
        if(emp != null){
            printf(s"在第 $empLinkedListNo 条链表，找到id=%d name=%s 的员工", id, emp.name)
        }else{
            printf("没有找到编号为 %d 的员工 \n", id)
        }
    }
    
    def show():Unit = {
        for(i <- 0 until size){
            empLinkedListArr(i).show(i)
        }
    }
}
