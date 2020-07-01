package com.atguigu.scala.p5

import java.text.SimpleDateFormat
import java.util.Date

object Scala10_Function_Exam3_WaterLeave {

    //课堂测试：取得传感器上报数据，并统计出每一个传感器点位每天的平均水位
    def main(args: Array[String]): Unit = {

        val time1 = List(
            ( "anheqiao", 1549044122, 10.0 ),
            ( "shengbeilu", 1549044122, 32.0 ),
            ( "pinganjie", 1549044122,25.0 )
        )
        val time2 = List(
            ( "anheqiao", 1549044123, 13.0 ),
            ( "shengbeilu", 1549044123, 34.0 ),
            ( "pinganjie", 1549044123,27.0 )
        )
        val time3 = List(
            ( "anheqiao", 1549130522, 14.0 ),
            ( "shengbeilu", 1549130522, 33.0 ),
            ( "pinganjie", 1549130522,26.0 )
        )
        val time4 = List(
            ( "anheqiao", 1549130523, 11.0 ),
            ( "shengbeilu", 1549130523, 32.0 ),
            ( "pinganjie", 1549130523,23.0 )
        )

        val dayList = List(time1,time2,time3,time4)

        //将数据进行扁平化
        val waterMarkList: List[(String, Int, Double)] = dayList.flatMap(list => list)

        //todo 将扁平化后的数据进行操作，时间戳 => 日期格式
        val sdf = new SimpleDateFormat("yyyy-MM-dd")

        //使用匹配模式转换，同时地点和时间结合在一起
        val mapWatermarkList: List[(String, Double)] = waterMarkList.map {
            case (address, ts, wm) => {
                (address + "_" + sdf.format(new Date(ts * 1000L)),
                  //todo 注意时间戳转成了13位后，超出了Int的范围，所以1000后面加L转成Long类型（时间戳操作时易错！）
                  wm)
            }
        }
        println(mapWatermarkList)


    }


}
