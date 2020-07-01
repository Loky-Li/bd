package com.atguigu.scala.p8

object Scala04_Match_example2 {

    //todo 模式匹配 - match - map 、 filter 结合模式匹配使用
    def main(args: Array[String]): Unit = {
        val map: Map[String, Int] = Map(("a",1),("b",2),("c",3))

        //todo 需求一：将map中的value乘2
        //方式一：map
        // 注意理解参数：((String, Int)) => NotInferedB，
        //参数是(String, Int),即为一个元组时，也就是参数只有一个，所以写的时候直接一个标识符表示这个元组
        //容易错写成：map.map((k,v) => {(k,v*2)})，这样map中就有了2个参数了。
        val mapTransform1: Map[String, Int] = map.map(tp => {
            (tp._1, tp._2 * 2)
        })
        println("方式一：" + mapTransform1)

        //方式二：mapValue：传入方法的值只有一个，就是map中每个键值对的value
        val mapTransform2: Map[String, Int] = map.mapValues(_*2)
        println("方式二：" + mapTransform2)


        //todo 同样的上面的方式代码不直观，所以使用匹配。
        // 但是 map在使用模式匹配时需要注意：格式有两点不同！
        //map的参数只有一个 :f: ((String, Int)) => NotInferedB
        //map方法可以使用模式匹配。但是，前面已经说过了map方法只有一个参数。
        // 如果使用 map.map( (word,count)=> {xxxxx} )的话，编译器就会解读成两个参数
        //一般情况下，参数只有一个的场合可以使用模式匹配
        //使用模式匹配时需要将方法的小括号变成大括号
        //case不能省略      最终写法如下
        val mapTransform3: Map[String, Int] = map.map {
            case (word, count) => {
                (word, count * 2)
            }
        }
        println("使用map模式匹配" + mapTransform3)


        //todo 需求二：将map中value大于等于2的键值对留下
        //方式一：filter
        val mapFilter1: Map[String, Int] = map.filter(tp => {
            tp._2 >= 2
        })
        println("filter过滤：" + mapFilter1)

        //方式二：同样的上面方式不直观，所以使用模式匹配
        //同样的filter的参数只有一个，所以需要小括号变大括号，同时不能省略case
        val mapFilter2: Map[String, Int] = map.filter {
            case (word, count) => {
                count >= 2
            }
        }
        println("filter结合模式匹配使用" + mapFilter2)


    }

}
