package restore.array

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class Solution {
  def restoreArray(adjacentPairs: Array[Array[Int]]): Array[Int] = {
    val map = createMap(adjacentPairs)
    val starts = map.filter(_._2.size == 1).keys.toArray

    if (starts.isEmpty) {
      return Array.empty[Int] // Return an empty array if no starting point is found
    }

    var current = starts(0)
    val list = scala.collection.mutable.Buffer[Int](current)

    for (_ <- 0 until adjacentPairs.length) {
      if (list.size > 1) {
        val beforeLast = list(list.size - 2)
        val vals = map(list.last).filter(_ != beforeLast)
        if (vals.nonEmpty) {
          list += vals.head // Add the remaining element to 'list'
        }
      }
      if (list.size == 1) {
        val vals = map(list.last)
        if (vals.nonEmpty) {
          list += vals.head // Add the remaining element to 'list'
        }
      }
    }

    list.toArray
  }


  def createMap(adjacentPairs: Array[Array[Int]]): Map[Int, List[Int]] = {
    val mutableMap = mutable.Map[Int, ListBuffer[Int]]()
    for (arr <- adjacentPairs) {
      processOne(mutableMap, arr(0), arr(1))
      processOne(mutableMap, arr(1), arr(0))
    }
    val immutableMap = mutableMap.map { case (key, value) => key -> value.toList }.toMap
    immutableMap
  }

  def processOne(map: mutable.Map[Int, ListBuffer[Int]], elem: Int, adjacent: Int): Unit = {
    if (!map.contains(elem)) {
      map.put(elem, ListBuffer.empty[Int])
    }
    map(elem) += adjacent
  }
}
