package com.hong.algor.search

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks

object s_01_BinarySearch {
    def main(args: Array[String]): Unit = {
        val arr = Array(1, 3, 10, 89, 1000, 1343)
        val index: Int = binarySearch(arr, 0, arr.length - 1, 89)
        if(index != -1){
            printf("找到，下标为：%d\n",index)
        }else{
            println("没有找到")
        }
    }
    
    /**
     * 二分查找思路：
     * 1、 先找到中间值
     * 2、 将中间值和查找值比较
     * 2.1、 相等，找出
     * 2.2、 中间值 > 查找值， 向左进行递归查找
     * 2.3、 中间值 < 查找值，向右进行递归查找
     * 如果存在值，则返回下标，否则返回-1
     * ？当时，表示找不到
     */
    def binarySearch(array: Array[Int], left:Int, right: Int, findVal:Int) :Int={
        
        if(left > right){
            return  -1
        }
        
        var mid = (left + right) / 2
        var midVal = array(mid)
        if(midVal>findVal){
            binarySearch(array, 1, mid-1, findVal)
        }else if(midVal < findVal){
            binarySearch(array, mid + 1, right, findVal)
        }else{
            return mid
        }
    
    }
    
    
    /*
    假设数组中有多个相同的值刚好是需要找的值，需要把所有的值都找出
     */
    def binarySearch2(array: Array[Int], left:Int, right: Int, findVal:Int){
        
        if(left > right){
            return  -1
        }
        
        var mid = (left + right) / 2
        var midVal = array(mid)
        if(midVal>findVal){
            binarySearch(array, 1, mid-1, findVal)
        }else if(midVal < findVal){
            binarySearch(array, mid + 1, right, findVal)
        }else{
//            return mid
            // 定义一个可变的数组
            val resArr: ArrayBuffer[Int] = ArrayBuffer[Int]()
            // 向左边扫描
            var temp = mid - 1
            Breaks.breakable{
                while (true) {
                    if (temp < 0 || array(temp) != findVal) {
                        Breaks.break()
                    }
                    if(array(temp) == findVal){
                        resArr.append(temp)
                    }
                    temp -= 1
                }
            }
            // 将中间的索引加入
            resArr.append(mid)
            //向右扫描
            temp = mid + 1
            Breaks.breakable{
                while (true) {
                    if (temp > array.length-1 || array(temp) != findVal) {
                        Breaks.break()
                    }
                    if(array(temp) == findVal){
                        resArr.append(temp)
                    }
                    temp += 1
                }
            }
            return resArr
        }
    }
    
}
