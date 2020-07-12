package com.hong.algor

import scala.util.control.Breaks

object a_007_Calculator {
    def main(args: Array[String]): Unit = {

        val  expression = "353+2*6-2"

        val numStack = new ArrayStack2(10)
        val operStack = new ArrayStack2(10)

        var index = 0
        var num1 = 0
        var num2 = 0
        var oper = 0
        var res = 0
        var ch = ' '
        var keepNum = ""  // 在进行扫描的时候，对多位数处理

        Breaks.breakable{
            while (true) {
                // 扫描expression
                ch = expression.substring(index, index + 1)(0)

                if (operStack.isOper(ch)) { // 如果是操作符
                    if (!operStack.isEmpty()) {
                        // 如果当前符号的优先级 小于等于符号栈栈顶的符号优先级，则取出栈顶符号
                        // 同时从数栈依次pop出两个数据，进行运算，将结果重新push到数栈，同时将当前符号push到符号栈
                        if (operStack.priority(ch) <= operStack.priority(operStack.stack(operStack.top))) {
                            // 开始计算
                            num1 = numStack.pop().toString.toInt
                            num2 = numStack.pop().toString.toInt
                            oper = operStack.pop().toString.toInt
                            res = numStack.cal(num1, num2, oper)

                            // 入数字栈
                            numStack.push(res)
                            // 把当前ch入符号栈
                            operStack.push(ch)
                        } else {
                            // 如果当前的符号的优先级，大于符号栈栈顶的符号，则直接将该符号压栈
                            operStack.push(ch)
                        }

                    } else {
                        // 符号栈为空，就直接入栈
                        operStack.push(ch) // '+' => 43
                    }
                } else { // 是数

                    // 处理多位数的逻辑
                    keepNum += ch

                    // 如果ch 已经是 expression 的最后一个字符
                    if(index == expression.length -1){
                        numStack.push(keepNum.toInt)
                    }else{
                        // 判断ch的下一个字符是不是数字，如果是数字，则进行一次扫描，如果是操作符，就直接入栈
                        // 看到expression 的下一个字符时，不要真正的移动index，只是探测一下
                        if(operStack.isOper(expression.substring(index+1,index+2)(0))){
                            //如果是操作符，直接入栈
                            numStack.push(keepNum.toInt)
                            keepNum = ""
                        }
                    }

                    //
//                    numStack.push((ch + "").toInt) // char ‘1’ 在 ASCII 码十进制中是 49，压进去的话变成49
                }

                // index 后移
                index += 1
                if (index >= expression.length) {
                    Breaks.break()
                }
            }
        }

        // 当整个表达式扫描完毕后，依次从数栈和符号栈取出数据，进行运算，最后数栈中的数据就是结果
        Breaks.breakable{
            while(true){
                if(operStack.isEmpty()){
                    Breaks.break()
                }
                // 开始运算
                num1 = numStack.pop().toString.toInt
                num2 = numStack.pop().toString.toInt
                oper = operStack.pop().toString.toInt
                res = numStack.cal(num1, num2, oper)
                numStack.push(res)
            }
        }

        printf("表达式 %s = %d",expression,res)
    }

}

class ArrayStack2(size: Int) extends ArrayStack(size) {

    // 继承了上个类的ArrayStack

    // 返回运算符的优先级，由程序定，数字越大，优先级越高
    // + 1 => 1
    def priority(oper: Int): Int = {
        if (oper == '*' || oper == '/') {
            return 1
        } else if (oper == '-' || oper == '+') {
            return 0
        } else {
            -1
        }
    }

    def isOper(value:Int) : Boolean = {
        value == '+' || value =='-' || value=='/' || value=='*'
    }

    // 计算方法
    def cal(num1: Int, num2: Int, oper: Int): Int = {
        var res = 0
        oper match {
            case '+' => {
                res = num1 + num2
            }
            case '-' => {
				res = num2 - num1
            }
            case '*' => {
                res = num1 * num2
            }
            case '/' => {
                res = num2 / num1
            }
        }

        res
    }

}
