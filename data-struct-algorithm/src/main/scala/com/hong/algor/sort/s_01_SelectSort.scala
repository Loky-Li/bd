package com.hong.algor.sort

object s_01_SelectSort {
    def main(args: Array[String]): Unit = {
        var arr = Array(101, 34, 119, 1)
        
        selectSort(arr)
    
        println(arr.mkString(" "))

    }
    
    def selectSort(arr:Array[Int]):Array[Int] = {
        for(i <- 0 until arr.length-1){
            // 演变过程
            var min = arr(i)
            var minIndex = i
            //遍历
            for(j <- i+1 until( arr.length)){
                if(min > arr(j)){
                    // 重置
                    min = arr(j)
                    minIndex = j
                }
            }
            // 判断是否需要重置
            if(minIndex != i){
                arr(minIndex) = arr(i)
                arr(i) = min
            }
        
            
        }
        return arr
    }
    
}
