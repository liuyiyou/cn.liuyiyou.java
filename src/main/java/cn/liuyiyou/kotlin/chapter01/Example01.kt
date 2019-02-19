package cn.liuyiyou.kotlin.chapter01

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun  sum2(a:Int,b:Int):Int = a+b

fun main(args: Array<String>) {
    println(sum(3, 5))
    println(sum2(3,5))
}