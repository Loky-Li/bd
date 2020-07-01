package com.atguigu.scala.p2

object Scala09_DataType1 {
    def main(args: Array[String]): Unit = {
        var name : String = "Yuxuan"
        var age : Int = 25

        println(s"name=$name" + s" age = $age")

        var str : String =
            """
              |select name，age
              | from table
              |where
            """.stripMargin

        println(str)
    }

}
