package homogenous.string

import java.util
import scala.collection.immutable.HashMap

class Solution {

  def countHomogenous(s: String): Int = {
    val sequenceCount = new HashMap();
    val list = new util.ArrayList();
    var currentSequence = "";
    for (char <- s) {
      val isOldSequnce = currentSequence.size >= 1 && (currentSequence.charAt(0) != char)
      if (isOldSequnce) {
        currentSequence += char
      } else {
        currentSequence = char + ""
      }
    }
    return 0
  }
}
