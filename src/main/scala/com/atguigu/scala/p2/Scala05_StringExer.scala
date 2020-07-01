package com.atguigu.scala.p2

object Scala05_StringExer {
    def main(args: Array[String]): Unit = {
        var name : String = "雨宣"
        var age : Int = 25

        println(s"name=$name" + s" age = $age")

        var str : String =
            """
              |select name，age
              | from table
              |where
            """.stripMargin

        println(str)

        var str2 =
            """
              |hello
              |I want to test other sentence
            """.stripMargin

        println(str2)

        val s2 = s"name = $name"
        println(s2)
    }

}
