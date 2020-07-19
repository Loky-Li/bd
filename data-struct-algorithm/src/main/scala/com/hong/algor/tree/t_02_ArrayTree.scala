package com.hong.algor.tree

object t_02_ArrayTree {
    def main(args: Array[String]): Unit = {
        
        val arr = Array(1,2,3,4,5,6,7)
        
        val arrayTree = new ArrayTree(arr)
        
        // 前序遍历二叉树（元素存在数组中）
        arrayTree.preOrder()
    }
    
}

class ArrayTree(val arr:Array[Int]){
    
    // 对preOrder 进行重载
    def preOrder():Unit = {
        this.preOrder(0)
    }
    
    def preOrder(index:Int):Unit={
        if(arr == null ||arr.length ==0){
            println("数组为空，不能按照二叉数前序遍历")
        }
        println(arr(index))
        // 向左递归遍历
        if((index*2+1 < arr.length)){
            preOrder(index*2 + 1)
        }
    
        // 向右递归遍历
        if((index*2+2 < arr.length)){
            preOrder(index*2 + 2)
        }
    }
}
