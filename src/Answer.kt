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
    var str = "$s+"
    while (str.contains(" ")) {
        str = str.replace(" ", "")
    }

    println(str.length)
    var index = 0
    var j = 0
    var i: Int
    var last = mutableListOf(0)
    val array = mutableListOf(0)
    while (index < str.length) {
        i = calculates.indexOf(str[index].toString())
        if (i != -1) {
            val a = str.substring(j, index).toInt()
            j = index + 1
            last.add(i)
            array.add(a)
            val cal = last[last.size - 2]

            if (i > 1 && cal < 2) {
                println(last.toString())
                index++
                continue
            }


            when (array.size) {
                3 -> {
                    array[1] = operation(last[last.size - 2], mutableListOf(array[1], array[2]))
                    array.removeAt(2)
                    last.removeAt(last.size - 2)
                }
                2 -> {
                    array[0] = operation(last[last.size - 2], array)
                    array.removeAt(1)
                    last.removeAt(last.size - 2)
                }
            }
            if (i < 2) {
                while (array.size > 1) {
                    array[0] = operation(last[last.size - 2], array)
                    array.removeAt(1)
                    last.removeAt(last.size - 2)
                }
            }
        }
        index++
    }
    println(array.toString())

    return array[0]
}

fun operation(cal: Int, array: MutableList<Int>): Int {
    print("${array[0]}${calculates[cal]}${array[1]}=")
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
    println(calculate("1+2*5/3+6/4*2"))

}
