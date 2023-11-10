package restore.array

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test

import scala.collection.mutable

class RestoreArrayTest {

  @Test
  def createMapNonEmptyTest(): Unit = {
    val solution = new Solution()
    val adjacentPairs = Array(Array(1, 2), Array(2, 3))
    val result = solution.createMap(adjacentPairs)

    assertEquals(3, result.size)
    // This assertion is a placeholder since the method currently returns an empty map
    //Assertions.assertEquals()
  }

  @Test
  def processOneAddsElementsCorrectly(): Unit = {
    val solution = new Solution()

    val map = mutable.Map[Int, mutable.ListBuffer[Int]]()
    solution.processOne(map, 1, 2)
    solution.processOne(map, 1, 3)

    assertEquals(mutable.ListBuffer(2, 3), map(1))
  }

  @Test
  def findSolution1(): Unit = {
    val solution = new Solution()
    val adjacentPairs = Array(Array(1, 2), Array(2, 3))
    val result = solution.restoreArray(adjacentPairs)

    assertEquals(3, result.size)
    // This assertion is a placeholder since the method currently returns an empty map
    //Assertions.assertEquals()
  }

  @Test
  def findSolution2(): Unit = {
    val solution = new Solution()
    val adjacentPairs = Array(Array(2, 1), Array(3, 4), Array(3, 2))
    val result = solution.restoreArray(adjacentPairs)

    assertEquals(4, result.length)
    assertTrue(
      result.sameElements(Array(4, 3, 2, 1)) || result.sameElements(Array(1, 2, 3, 4)))
  }
}
