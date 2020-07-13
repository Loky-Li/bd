package com.hong.algor.sort

object s_02_InsertSort {
    def main(args: Array[String]): Unit = {
        var arr = Array(101, 34, 119, 1, 24)
        
        insertSort(arr)
    
        println(arr.mkString(" "))
    }
    
    def insertSort(arr:Array[Int]):Array[Int] = {
        
        for(i <- 1 until arr.length){
            var insertValue = arr(i)
            var insertIndex = i-1   //  表示有序表的最后一个元素的下标
    
            while(insertIndex >= 0 && insertValue < arr(insertIndex)){  // 还没有找到位置
                arr(insertIndex + 1) = arr(insertIndex)
                insertIndex -= 1
            }
    
            // 退出while，说明插入的位置就找到了
            arr(insertIndex + 1) = insertValue
        }
        
        arr

    }
    
}
