package com.hong.algor.sort

object s_04_MergeSort {
    def main(args: Array[String]): Unit = {
        var arr = Array(-9, 78, 0, 23, -567, 70)
        val  temp = new Array[Int](arr.length)
        mergeSort(arr, 0, arr.length-1, temp)
        println("归并排序后：")
        println(arr.mkString(" "))
    
    }
    
    // 是后一个归并排序
    /**
     * @param arr
     * @param left : 最初左边的下标 0
     * @param right ： 最初右边的下标 length-1
     * @param temp ： 临时数组，事先开辟好，大小和arr一样
     */
    def mergeSort(arr: Array[Int], left:Int, right: Int, temp:Array[Int]):Unit = {
        if(left < right){   // 如果left < right 就可以继续分
            val mid = (left +right) / 2
            mergeSort(arr,left, mid, temp)      // 递归将左边的数据做成有序列表
            mergeSort(arr,mid+1,right,temp)     // ...
            // merge是合并的操作
            merge(arr, left, mid, right, temp)
        }
    }
    
    /**
     * @param arr
     * @param left  :
     * @param mid ：
     * @param right ：
     * @param temp
     */
    def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]): Unit ={
        var i = left    // 左半的指针
        var j = mid+1   // 右半的指针
        var t = 0       // t是temp数组的索引
        while(i <= mid && j <= right){      // 从左边和右边的有序列表
            if(arr(i) <= arr(j)){
                temp(t) = arr(i)
                t += 1
                i += 1
            }else{
                temp(t) = arr(j)
                t += 1
                j += 1
            }
        }
        while(i <= mid){    // 如果左边还有剩余的数据，则依次copy到temp数组中
            temp(t) = arr(i)
            t += 1
            i += 1
        }
        while(j <= right){
            temp(t) = arr(j)
            t += 1
            i += 1
        }
        
        // 将本次temp的数据copy回到arr中 (是递归执行的，累计)
        t = 0
        var tempLeft = left
        while(tempLeft <= right){
            arr(tempLeft) = temp(t)
            t += 1
            tempLeft += 1
        }
    }
    
}
