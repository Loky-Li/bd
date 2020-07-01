package com.atguigu.scala.test

object GetWaterAvg {
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

/*        val dateFormat = new SimpleDateFormat("yyyy-MM-dd")
        println(dateFormat(new Date(1549130523)))*/


        //先将一天汇总的所有数据放在一个List中
        val dayTime = List(time1,time2,time3,time4)
//        println(dayTime)

        //将List按照扁平
        val tuples: List[(String, Int, Double)] = dayTime.flatMap(_.map(tp =>{
            (tp._1,
              tp._2,
              tp._3)
        }))
//        println(tuples)


        //按照地点进行分组
        val tpToGroup: Map[String, List[(String, Int, Double)]] = tuples.groupBy(tp => tp._1)
//        println(tpToGroup)

        //对分组后的map转成list
        val tpToList: List[(String, List[(String, Int, Double)])] = tpToGroup.toList
//        println(tpToList)

        //将每个地点的所有信息元素map后只保留水位
        val listLeave: List[(String, List[Double])] = tpToList.map(tp => {
            (tp._1, tp._2.map(tpp => tpp._3))
        })
//        println(listLeave)

        //求出每个地点的平均水位
        val listAvg: List[(String, Double)] = listLeave.map(tp => {
            (tp._1, tp._2.sum / tp._2.size)
        })
        println(listAvg)

    }

}
