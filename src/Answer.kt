/**
 * 一个思维锻炼的项目
 * 请坚持下去 两日至少一题
 * 记录员：Francis
 * 日期：2019年4月18日
 **/
// 227 基本计算器II 2019-4-18
val calculates = arrayOf("+", "-", "*", "/")

fun calculate(s: String): Int {
    //用+号将所有的有加法计算的先隔离出来
    val str = "$s+"
    var index = 0
    var j = 0
    var i: Int
    var last = mutableListOf(0)
    val array = mutableListOf<Int>()
    val array2 = mutableListOf<Int>()
    while (index < str.length) {
        i = calculates.indexOf(str[index].toString())
        if (i != -1) {
            val a = str.substring(j, index).toInt()
            j = index + 1
            last.add(i)
            if (array2.size > 0) {
                array2.add(a)
            } else {
                when (i) {
                    //加减
                    0, 1 -> {
                        array.add(a)
                    }
                    2, 3 -> {
                        array2.add(a)
                    }
                }
            }
        }
        if (array2.size > 1) {
            println(last.toString())
            array2[0] = operation(last[last.size - 2], array2)
            last.removeAt(last[last.size - 2])
            array.add(array2[0])
            array2.clear()
        }
        if (array.size > 1) {
            println(last.toString())
            array[0] = operation(last[last.size - 2], array)
            array.removeAt(1)
            last.removeAt(last[last.size - 2])
        }
        index++
    }
    println()
    return array[0]
}

fun operation(cal: Int, array: MutableList<Int>): Int {
    print("${array[0]}-->$cal---->${array[1]}=")
    when (cal) {
        0 -> array[0] += array[1]
        1 -> array[0] -= array[1]
        2 -> array[0] *= array[1]
        3 -> array[0] /= array[1]
    }
    println(array[0])
    return array[0]
}


fun main(args: Array<String>) {
    println(calculate("30+20*20-30+50/20"))

}
