//package `665`

/**
 * 一个思维锻炼的项目
 * 请坚持下去  hold on
 * 记录员：Francis
 * 日期：2019年4月24日
 **/
// 665. 非递减数列 2019年4月24日
fun checkPossibility(nums: IntArray): Boolean {
    var index = 0
    var flag = false
    while (index < nums.size - 1) {
        if (nums[index] > nums[index + 1]) {
            when {
                flag -> return false
                index + 2 < nums.size && (nums[index] > nums[index + 2]) -> {
                    nums[index] = nums[index + 1]
                }
                else -> {
                    nums[index + 1] = nums[index]
                }
            }
            flag = true
            if (index > 0 && nums[index] < nums[index - 1]) {
                return false
            }
        }
        index++
    }
    return true
}

fun main(args: Array<String>) {
    println(checkPossibility(intArrayOf(2, 3, 3, 2, 4)))
    println(checkPossibility(intArrayOf(3, 4, 2, 3)))
    println(checkPossibility(intArrayOf(-1, 4, 2, 3)))
    println(checkPossibility(intArrayOf(1, 3, 2)))
}
