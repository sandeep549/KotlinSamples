package com.example.kotlinsamples.leetcode.kotlin

import android.util.Range
import com.example.kotlinsamples.leetcode.kotlin.tree.TreeNode
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.stream.IntStream
import kotlin.Comparator


// using comparator
private fun sortArray(twoDArray: Array<IntArray>) {

    // 1
    twoDArray.sortWith(kotlin.Comparator { t1, t2 -> t1[1] - t2[1] })

    // 2
    twoDArray.sortWith(object : Comparator<IntArray> {
        override fun compare(p0: IntArray?, p1: IntArray?): Int {
            return p0!![1] - p1!![1]
        }

    })

}

fun main() {
    arrayOverFlow()

//    var r = Range(1, Int.MAX_VALUE)
//    r
//    IntStream.range(0,20).parallel().forEach(i->{
//        ... do something here
//    });

}

private fun arrayOverFlow() {
    var list = mutableListOf<Int>()
    var start = System.currentTimeMillis()
    var k = 0
    for (i in 1..Int.MAX_VALUE) {
        k++
        list.add(k)
    }
    println(k)
    var milliseconds = System.currentTimeMillis() - start
    val minutes: Long = TimeUnit.MILLISECONDS.toMinutes(milliseconds)
    val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)

    println("time taken milliseconds=" + milliseconds)
    println("time taken minutes=" + minutes)
    println("time taken seconds=" + seconds)
    println("its okay till here")
}

private fun stackInKotlin() {
    val stack1: ArrayDeque<Int> = ArrayDeque()
    stack1.push(1)
    stack1.push(2)
    stack1.pop()
    stack1.peek()
    stack1.peekFirst()
    stack1.isEmpty()
    stack1.size
}

private fun queueInKotlin() {
    val queue1: ArrayDeque<Int> = ArrayDeque()
    queue1.add(1)
    queue1.add(2)
    queue1.remove()
    queue1.peekFirst()
    queue1.isEmpty()
    queue1.size
}

private fun listInKotlin() {
    //1
    var l1 = listOf<Int>() // read-only, random access like ArrayList
    //2
    var l2 = mutableListOf<Int>() // mutable, random access like ArrayList
    //work with above 2 whenever possible


    //3
    var l3 = arrayListOf<Int>() // same as 2, mutable ArrayList
    var l4 = emptyList<Int>()// read-only, random access
    var l5 = listOfNotNull<Int>() //read-only, random access

    //No sequential access list in kotlin ???
}

private fun mapsInKotlin() {
    // inbuilt maps (non java maps, though needs clarification)
    /*1*/
    var immutableMap = mapOf<Int, Int>() // maintains insertion order, immutable
    /*2*/
    var mutableMap = mutableMapOf<Int, Int>() // maintains order, mutable

    //work with below 3 whenever possible
    //factory method for java maps
    /*3*/
    var sortedmap = sortedMapOf<Int, Int>() //java TreeMap, mutable
    /*4*/
    var hasmap = hashMapOf<Int, Int>() // java HashMap, mutable
    /*5*/
    var likedhashmap = linkedMapOf<Int, Int>() // java LinkedHashMap, mutable, same as 2 internally
}

private fun findMode() {
    val count = hashMapOf<Int, Int>()
    /**
     * sort map with max value frequency and return IntArray of keys.
     */
    //1.
    val maxVal = count.map { it.value }.max() ?: 0
    var arr: IntArray = count.filter { it.value >= maxVal }.map { it.key }.toIntArray()

    //2.
    arr = count.filter {
        it.value >= count.maxBy { it.value }!!.value
    }.map {
        it.key
    }.toIntArray()
}

//using pair and tripple
private fun PairExample() {
    var p = Pair("sandeep", 1)
    println(p.first)
    println(p.second)
}

//using pair and tripple
private fun TrippleExample() {
    var p = Triple("sandeep", 1, 4.9)
    println(p.first)
    println(p.second)
    println(p.third)
}

//find min index of smallest abs value in array
private fun minIndex() {
    var arr = intArrayOf(3, 2, -1, 6, 9, 0)
    println(arr.indexOf(arr.minBy { i -> (i) }!!))

    val index = arr.minBy { (it) }?.let { arr.indexOf(it) }
    println(index)

    val i = arr.withIndex().minBy { (_, f) -> f }?.index
    println(i)

    println(arr.indexOf(arr.min()!!))

    println(arr.indices.minBy { arr[it] })
}

private fun sortingExamples() {
    var sortedValues = mutableListOf(1 to "a", 2 to "b", 7 to "c", 6 to "d", 5 to "c", 6 to "e")
    sortedValues.sortBy { it.second }
    println(sortedValues)

    var a = mutableListOf(3, 2, 1, 4)
    a.sortBy { it % 2 }
    println(a)

    val students = mutableListOf(21 to "Helen", 21 to "Tom", 20 to "Jim")

    val ageComparator = compareBy<Pair<Int, String?>> { it.first }
    val ageAndNameComparator = ageComparator.thenByDescending { it.second }
    println(students.sortedWith(ageAndNameComparator))

    var arr = intArrayOf(3, 2, 1, 4)
    var arr1 = arr.sortedBy { it % 2 }
    println(arr1.toList())
}
