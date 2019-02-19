package cn.liuyiyou.kotlin.chapter01

/**
 *
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/10/24
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
 */

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun  sum2(a:Int,b:Int):Int = a+b

fun main(args: Array<String>) {
    println(sum(3, 5))
    println(sum2(3,5))
}