package com.atguigu.scala.p7

import java.text.SimpleDateFormat
import java.util.Date

import scala.collection.immutable
import scala.collection.mutable.ListBuffer

object Scala24_WaterLevel_Exer {
    def main(args: Array[String]): Unit = {

        // 需求：取得传感器上报数据，并统计出每一个传感器点位每天的平均水位
        val time1 = List(
            ("anheqiao", 1549044122L, 10.0),
            ("shengbeilu", 1549044122L, 32.0),
            ("pinganjie", 1549044122L, 25.0)
        )
        val time2 = List(
            ("anheqiao", 1549044123L, 13.0),
            ("shengbeilu", 1549044123L, 34.0),
            ("pinganjie", 1549044123L, 27.0)
        )
        val time3 = List(
            ("anheqiao", 1549130522L, 14.0),
            ("shengbeilu", 1549130522L, 33.0),
            ("pinganjie", 1549130522L, 26.0)
        )
        val time4 = List(
            ("anheqiao", 1549130523L, 11.0),
            ("shengbeilu", 1549130523L, 32.0),
            ("pinganjie", 1549130523L, 23.0)
        )




        /*
                // TODO 获取原始数据
                val dataList = List(time1,time2,time3,time4)

                // TODO 将原始数据进行扁平化操作，所有的数据都是独立的个体
                //  自己对扁平的理解并不到位，在自己写的方法中，写的扁平特别复杂乱！
                val watermarkList: List[(String, Long, Double)] = dataList.flatMap(list => list)

                // TODO 将扁平化后的数据进行结构的转换,将时间戳转成日期的String类型
                //  （String, Long, Double） => (String-String, Double)。map使用模式匹配
                val sdf = new SimpleDateFormat("yyyy-MM-dd")
                val mapWatermarkList: List[(String, Double)] = watermarkList.map {
                    case (address, ts, wm) => {
                        (address + "_" + sdf.format(new Date(ts * 1000)), wm)
                        //使用下划线连接的原因是，日期之间是使用 - 破折号连接，区分符号，这样后面再拆时，不回拆成没意义数据
                    }
                }


                // TODO 将转换结构后的数据根据 地点-时间 进行分组
                val addressAndTimeToList: Map[String, List[(String, Double)]] = mapWatermarkList.groupBy(t => t._1)

                // TODO 将分组后的数据进行结构的转换 （addressTime, list） => (address ,(time, avg))
        //        val addressToTimeAndAvg: Map[String, (String, Double)] = addressAndTimeToList.map {
        // 结果只有3个，因为map中key为地点，而key相同时，数据会被覆盖，所以需要装成List

                val addressToTimeAndAvg: List[(String, (String, Double))] = addressAndTimeToList.toList.map {
                    case (addressTime, list) => {
                        val keys: Array[String] = addressTime.split("_")
                        val values: List[Double] = list.map(_._2)
                        (keys(0), (keys(1), values.sum / values.size))
                    }
                }

        //        println(addressToTimeAndAvg)
        //        addressToTimeAndAvg.foreach(println)


                // TODO 将转换结构后的数据根据传感器的地点进行分组
                val resultMap: Map[String, List[(String, (String, Double))]] = addressToTimeAndAvg.groupBy(_._1)
                println(resultMap)
                resultMap.foreach(println)

                */

        // 将所有的数据收集
        val collectList = ListBuffer(time1, time2, time3, time4)

        // 所有数据汇总，并将时间转成日期
        val sdf = new SimpleDateFormat("yyyy-MM-dd")
        val portAndDateToLevel: ListBuffer[(String, Double)] = collectList.flatMap { // flatMap 传入 的应该是每个List，并不是小List里面的tuple
            case list => {
                list.map {
                    case (port, ts, level) => {
                        val date: String = sdf.format(new Date(ts * 1000))
                        ((port + "_" + date), level)
                    }
                }
            }
        }

/*      // 复习时使用了 有意思的复杂方法去实现。
        //        println(portAndDateToLevel)

        val portAndDateToLevelGrouped: Map[String, ListBuffer[(String, Double)]] =
            portAndDateToLevel.groupBy {
                case (port_date, level) => port_date
            }

        println(portAndDateToLevelGrouped)

        val portAndDateToLevelAvg: Map[String, Double] =
            portAndDateToLevelGrouped.map {
                case (p_d, record) => {

                    val level_sum: Double = record.foldLeft(0.0) {
                        case (count, (p_d, level)) => count + level
                    }

                    val record_count: Int = record.size

                    val level_avg: Double = level_sum / record_count

                    (p_d, level_avg)
                }
            }

        println(portAndDateToLevelAvg)*/
    }

}
