class Range(var Start: Int, var End: Int) {
  def contains(array: Array[Int]): Boolean = {
    for (item <- array) {
      if (item < Start || item > End) {
        return false;
      }
    }
    return true;
  }

  def notContains(array: Array[Int]): Boolean = {
    return !contains(array);
  }

  def allPoints(): Array[Int] = {
    var difference = End - Start;
    var array: Array[Int] = new Array[Int](difference + 1);
    for (i <- 0 to difference) {
      array(i) = Start + i;
    }
    return array;
  }

  def containsRange(range: Range): Boolean = {
    if (range.Start >= Start && range.End <= End) {
      return true;
    }
    return false;
  }

  def notContainsRange(range: Range): Boolean = {
    return !containsRange(range);
  }

  def endPoints(): Array[Int] = {
    return Array[Int](Start, End);
  }

  def overLaps(range: Range): Boolean = {
    if ((range.End >= Start && range.End <= End) || (range.Start >= Start && range.Start <= End)) {
      return true;
    }
    return false;
  }

  def equals(range: Range): Boolean = {
    if (range.Start == Start && range.End == End) {
      return true;
    }
    return false;
  }

  def notEquals(range: Range): Boolean = {
    return !equals(range);
  }

}

object Practice_5 extends App {
  def Validate(strRange: String): Range = {
    var cStart = strRange(0);
    var cEnd = strRange(strRange.length() - 1);
    if ((cStart == '(' || cStart == '[') && (cEnd == ')' || cEnd == ']')) {
      var clear = strRange
        .replaceAll("\\(", "")
        .replaceAll("\\[", "")
        .replaceAll("\\)", "")
        .replaceAll("\\]", "")
        .split(',');
      var start = clear(0).toInt;
      var end = clear(1).toInt;
      if (cStart == '(') {
        start += 1;
      }
      if (cEnd == ')') {
        end -= 1;
      }
      return new Range(start, end);
    }
    return null;
  }
}
