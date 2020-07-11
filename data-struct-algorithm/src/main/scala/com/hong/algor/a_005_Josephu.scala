package com.hong.algor

import scala.util.control.Breaks

object a_005_Josephu {
    def main(args: Array[String]): Unit = {
        val boyGame = new BoyGame
        boyGame.addBoy(7)
        boyGame.showBoy()

        // 测试countBoy
        boyGame.countBoy(4,6,7)
    }
}

class Boy(bNo:Int){
    val no:Int = bNo
    var next:Boy = null
}

//编写核心类BoyGame
class BoyGame{
    // 定义一个初始的头结点
    var first:Boy = new Boy(-1)

    // 添加小孩，形成一个单向环形链表
    // nums: 表示共有几个小孩
    def addBoy(nums:Int) : Unit = {
        if(nums < 1){
            println("nums值有误")
            return
        }

        var curBoy:Boy = null

        for(no <- 1 to nums){
            val boy = new Boy(no)
            //如果是第一个小孩
            if(no == 1 ){
                first = boy             // 初始化first的位置，就是 no=1 的小孩
                first.next = first      // 指向本身
                curBoy = first
            }else{
                curBoy.next = boy       // 新加入的boy被指向
                boy.next = first        // 实现闭环
                curBoy = boy            // 【curBoy】下移
            }
        }
    }

    /**
     *
     * @param startNo       从第几个人开始数
     * @param countNum      数几下
     * @param nums          一共多少人
     */
    def countBoy(startNo:Int, countNum:Int, nums:Int):Unit = {
        if(first.next == null || startNo < 1 || startNo > nums){
            println("参数有误")
            return
        }

        // 1）在first前面 设计一个 辅助指针 helper  定位到first前面（first这个人编号的前一个编号，即小1编号的人）
        //  helper的作用，就是为了在first删除之后，记录一个节点可以实现指向删了节点的下一个节点。
        var helper = first      // 开始helper和first位置一样。然后helper开始移动，找到自己的位置
        Breaks.breakable{
            while(true){
                if(helper.next == first){       //定位到。
                    Breaks.break()
                }
                helper = helper.next        // 定位不到，就一直下移
            }
        }

        // 2) 将first指针移动到startNo 这个小孩上。help也对应移动。由于移动的次数一样，所以helper也一直保持在first前
        for(i <- 0 until startNo - 1){
            first = first.next
            helper = helper.next
        }


        // 开始数数，按照给定的值，每数到一个小孩就出圈，直到环形链表中有一个节点
        Breaks.breakable{
            while (true) {
                if (helper == first) {      //只剩下一个人
                    Breaks.break()
                }

                // 3) 开始数 countNum 个数 [first 和 helper 会对应的移动]
                for( i <- 0 until countNum - 1){
                    first = first.next
                    helper = helper.next
                }

                // 输出出圈的人的信息
                printf("小孩%d 出圈\n", first.no)
                // 4) 将first 指向的节点删除 （画图一目了然）
                first = first.next
                helper.next = first
            }
        }

        printf("最后留在圈的小孩编号是 %d\n", first.no)

    }

    def showBoy():Unit = {
        if(first.next == null){
            println("没有任何小孩")
            return
        }

        var curBoy = first

        Breaks.breakable{
            while (true){
                printf("小孩编号 %d\n", curBoy.no)
                if(curBoy.next == first){
                    Breaks.break()
                }
                curBoy = curBoy.next        // curBoy后移
            }
        }

    }
}
