package com.hong

import scala.collection.mutable.ArrayBuffer

object a_001_SparseArr {
    def main(args: Array[String]): Unit = {

        // (1) 初始化一个二维数组
        val rowSize = 11
        val colSize = 11
        val chessMap: Array[Array[Int]] = Array.ofDim[Int](rowSize, colSize)

        chessMap(1)(2) = 1 // 1 为黑子
        chessMap(2)(3) = 2 // 2 为白子

        // 输出初始化的棋盘地图
        println("-------------原始棋盘数组--------------------")
        for(item <- chessMap){
            for(item2 <- item){
                printf("%d\t", item2)       // 格式化输出， %d 代表的是数字
            }
            println()
        }

        // (2) 将chessMap转成稀疏数组，从而达到将数据进行压缩
        // 使用节点：class Node(row, col, value)
        // 将Node节点添加到 ArrayBuffer

        // 2.1 初始化头部信息
        val sparseArr: ArrayBuffer[Node] = ArrayBuffer[Node]()
        val node = new Node(rowSize, colSize, 0)
        sparseArr.append(node)

        // 2.2 将有效信息封装为Node，并添加到ArrayBuffer中
        for(i <- 0 until chessMap.length){
            for(j <- 0 until chessMap(i).length){
                if(chessMap(i)(j) !=0){
                    //构建一个Node
                    val node = new Node(i,j,chessMap(i)(j))
                    sparseArr.append(node)
                }
            }
        }

        println("-------------压缩后的数组--------------------")
        for(node <- sparseArr){
            printf("%d\t%d\t%d\n",node.row,node.col,node.value)
        }

        // 存盘

        // 读盘 -> 稀疏数组

        // 稀疏数组 -> 原始数组

        // 读取稀疏数组的第一个节点
        val node_first: Node = sparseArr(0)
        val rowSize2 = node_first.row
        val colSize2 = node_first.col

        // 还原一个数组
        val chessMap2: Array[Array[Int]] = Array.ofDim[Int](rowSize2, colSize2)
        for(i <- 1 until sparseArr.length){
            val node: Node = sparseArr(i)
            chessMap2(node.row)(node.col) = node.value
        }

        // 输出还原后的棋盘地图
        println("-------------从原始数组中还原的棋盘数组--------------------")
        for(item <- chessMap2){
            for(item2 <- item){
                printf("%d\t", item2)       // 格式化输出， %d 代表的是数字
            }
            println()
        }
    }

}

class Node(val row:Int, val col:Int, val value: Int)
