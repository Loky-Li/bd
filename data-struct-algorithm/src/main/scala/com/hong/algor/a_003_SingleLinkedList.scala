package com.hong.algor

import scala.util.control._

object a_003_SingleLinkedList {
    def main(args: Array[String]): Unit = {
        val h1 = new HeroNode(1, "宋江", "及时雨")
        val h3 = new HeroNode(3,"宋江3", "及时雨3")
        val h4 = new HeroNode(4,"宋江4", "及时雨4")
        val h2 = new HeroNode(2,"宋江2", "及时雨2")

        val linkedList = new SingleLinkedList

        linkedList.add(h1)
        linkedList.add(h3)
        linkedList.add(h4)
        linkedList.add(h2)

//        linkedList.add2(h1)
//        linkedList.add2(h3)
//        linkedList.add2(h4)
//        linkedList.add2(h2)

        linkedList.list()

        val h5 = new HeroNode(3,"吴用", "智多星")

        linkedList.update(h5)
        println("===============")
        linkedList.list()


    }

}

class SingleLinkedList {

    // 创建一个头节点，不存实际的数据
    val head = new HeroNode(0, "", "")

    def del(no:Int):Unit={
        var temp = head
        var flag = false  //是否存在要删除的节点

        Breaks.breakable{
            while (true) {
                if (temp.next == null) {
                    Breaks.break()
                }

                if(temp.next.no == no){
                    //找到了
                    flag = true
                    Breaks.break()
                }

                temp = temp.next
            }
        }

        if(flag){
             temp.next = temp.next.next
        }else{
            printf("没有找到no=%d,要删除的节点",no)
        }
    }

    def update(newHeroNode:HeroNode) : Unit = {
        if(head.next == null){
            println("链表为空")
            return
        }

        //寻找需要更新的节点位置 （更具no）
        var temp = head.next
        var flag = false        //默认找不到节点
        Breaks.breakable{
            while(true){
                if(temp == null){       // 当temp为空的时候跳出
                    Breaks.break()
                }

                if(temp.no == newHeroNode.no){
                    //找到
                    flag = true
                    Breaks.break()
                }

                temp = temp.next
            }
        }

        if(flag){
            temp.name = newHeroNode.name
            temp.nickname = newHeroNode.nickname
        }else{
            printf("没有找到 no=%d 的英雄",newHeroNode.no)
        }
    }

    //添加节点
    // 第一种方法在添加英雄时，直接添加到链表的尾部
    def add(heroNode: HeroNode): Unit = {
        var temp = head
        Breaks.breakable{
            while(true){
                if(temp.next == null){
                    Breaks.break()
                }
                // 没有到最后，则继续往下走
                temp = temp.next
            }
        }

        //temp就是最后的一个节点，则新加的节点加在这个节点之后
        temp.next = heroNode
    }

    // 第二种方法，添加英雄时，英雄可以找到自己的位置进行插入
    def add2(heroNode :HeroNode):Unit = {


        var temp = head
        var flag = false    // flag 用于判断该英雄的编号是否存在，默认不存在false
        Breaks.breakable{
            while(true){
                if(temp.next == null){
                    Breaks.break()
                }

                //寻找位置。升序
                if(temp.next.no > heroNode.no){ // 位置找到，当前的节点应该添加在temp后
                    Breaks.break()
                }else if(temp.next.no == heroNode.no){  //已经存在这个节点
                    flag = true
                    Breaks.break()
                }

                // 一次循环找不到后，temp下移一位
                temp = temp.next
            }
        }

        if(flag){
           println("待插入的英雄编号 %d 已经存在，不能加入", heroNode.no)
        }else{      //添加node
            heroNode.next = temp.next
            temp.next = heroNode

        }
    }

    def list():Unit = {
        if(head.next == null){
            println("链表为空")
            return
        }

        var temp = head.next
        Breaks.breakable{
            while (true) {
                // 判断是否是最后
                if (temp == null) {
                    Breaks.break()
                }
                printf("节点信息 no=%d name=%s nickname=%s\n",
                    temp.no, temp.name, temp.nickname)

                temp = temp.next
            }
        }
    }
}

class HeroNode(hNo: Int, hName: String, hNickname: String) {
    var no: Int = hNo
    var name: String = hName
    var nickname: String = hNickname
    var next: HeroNode = null // next 默认为null
}
