package com.hong.algor.sort

import scala.util.control.Breaks

object s_03_QuickSort {
    def main(args: Array[String]): Unit = {
        var arr = Array(101, 34, 119, 1, 24)
    }
    
    /**
     *
     * @param left
     * @param right
     * @param arr
     * @return
     */
    def quickSort(left:Int, right: Int, arr: Array[Int]):Array[Int] = {
        var le = left
        var rt = right
        var pivot = arr((le+rt)/2)    // 中间位置的值
        var temp = 0
        
        Breaks.breakable{
            while(le < rt){
                while(arr(le) < pivot){ // 从左边找一个比pivot 大的值的对应下标
                    le += 1
                }
                while(arr(rt) > pivot){
                    rt -=  1
                }
                if(le >= rt){   // 本次交换结束
                    Breaks.break()
                }
                
                // 交换数据
                temp = arr(le)
                arr(le) = arr(rt)
                arr(rt) = temp
                
                // 交换数据后，如果有和中值等的，则另一边
                if(arr(le) == pivot){
                    rt -=1
                }
                if(arr(rt) == pivot){
                    le += 1
                }
            }
        }
        
        if(le == rt){   // 提高效率
            le += 1
            rt -= 1
        }
        
        if(left < rt){
            quickSort(left, rt, arr)  // 向左进行递归
        }
        if(right > le){
            quickSort(le, right, arr)
        }
        
        arr
    }
    
}
