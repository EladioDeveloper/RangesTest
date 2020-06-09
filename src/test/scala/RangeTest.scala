class RangeTest extends org.scalatest.FunSuite {
  var r1 = Practice_5.Validate("[2,6)");
  var r2 = Practice_5.Validate("(4,12]");
  var r3 = Practice_5.Validate("(-2,6)");
  var r4 = Practice_5.Validate("[-10,-3]");

  var rr1 = Practice_5.Validate("(1,4]");
  var rr2 = Practice_5.Validate("(5,11)");
  var rr3 = Practice_5.Validate("[-5,6)");
  var rr4 = Practice_5.Validate("(-10,0)");

  var arr1 = Array(2, 3, 4, 5);
  var arr2 = Array(5, 6, 7, 8, 9, 10, 11, 12);
  var arr3 = Array(-1, 0, 1, 2, 3, 4, 8, 20);
  var arr4 = Array(-10, -9, -8, -7, -6, -5, 4, 3);

  test("Validate should return a range with 2,5 as End Points") {
    assert(r1.endPoints() === Array(2, 5))
  }
  test("Validate should return a range with 5,12 as End Points") {
    assert(r2.endPoints() === Array(5, 12))
  }
  test("Validate should return a null value to {-2,6}") {
    assert(Practice_5.Validate("{-2,6}") === null)
  }
  test("Validate should return a rnull value to [-10,0[") {
    assert(Practice_5.Validate("[-10,0[") === null)
  }

  test("Contains should return true with this input {2,3,4,5}") {
    assert(r1.contains(arr1) === true)
  }
  test(
    "Contains should return true with this input {5,6,7,8,9,10,11,12}"
  ) {
    assert(r2.contains(arr2) === true)
  }
  test(
    "Contains should return false with this input {-1,0,1,2,3,4,8,20}"
  ) {
    assert(r3.contains(arr3) === false)
  }
  test(
    "Contains should return false with this input {-10,-9,-8,-7,-6,-5,4,3}"
  ) {
    assert(r4.contains(arr4) === false)
  }

  test("NotContains should return false with this input {2,3,4,5}") {
    assert(r1.notContains(arr1) === false)
  }
  test(
    "Contains should return false with this input {5,6,7,8,9,10,11,12}"
  ) {
    assert(r2.notContains(arr2) === false)
  }
  test(
    "Contains should return true with this input {-1,0,1,2,3,4,8,20}"
  ) {
    assert(r3.notContains(arr3) === true)
  }
  test(
    "Contains should return true with this input {-10,-9,-8,-7,-6,-5,4,3}"
  ) {
    assert(r4.notContains(arr4) === true)
  }

  test("Allpoints should return an array as this {2,3,4,5}") {
    assert(r1.allPoints() === arr1)
  }
  test("Allpoints should return an array as this {5,6,7,8,9,10,11,12}") {
    assert(r2.allPoints() === arr2)
  }
  test("Allpoints should return an array as this {-1,0,1,2,3,4,5}") {
    assert(r3.allPoints() === Array(-1, 0, 1, 2, 3, 4, 5))
  }
  test("Allpoints should return an array as this {- 10,-9,-8,-7,-6,-5,-4,-3}") {
    assert(r4.allPoints() === Array(-10, -9, -8, -7, -6, -5, -4, -3))
  }

  test("ContainsRange should return true with this range (1,4]") {
    assert(r1.containsRange(rr1) === true)
  }
  test("ContainsRange should return true with this range (5,11)") {
    assert(r2.containsRange(rr2) === true)
  }
  test("ContainsRange should return false with this range [-5,6)") {
    assert(r3.containsRange(rr3) === false)
  }
  test("ContainsRange should return false with this range [-10,0)") {
    assert(r4.containsRange(rr4) === false)
  }

  test("NotContainsRange should return false with this range (1,4]") {
    assert(r1.notContainsRange(rr1) === false)
  }
  test("NotContainsRange should return false with this range (5,11)") {
    assert(r2.notContainsRange(rr2) === false)
  }
  test("NotContainsRange should return true with this range [-5,6)") {
    assert(r3.notContainsRange(rr3) === true)
  }
  test("NotContainsRange should return true with this range [-10,0)") {
    assert(r4.notContainsRange(rr4) === true)
  }

  test("EndPoints should return an Array as this {2,5}") {
    assert(r1.endPoints() === Array(2, 5))
  }
  test("EndPoints should return an Array as this {5,12}") {
    assert(r2.endPoints() === Array(5, 12))
  }
  test("EndPoints should return an Array as this {-1,5}") {
    assert(r3.endPoints() === Array(-1, 5))
  }
  test("EndPoints should return an Array as this {-10,-3}") {
    assert(r4.endPoints() === Array(-10, -3))
  }

  test("OverLaps should return true to this range [4,14]") {
    assert(r1.overLaps(Practice_5.Validate("[4,14]")) == true)
  }
  test("OverLaps should return true to this range (1,8)") {
    assert(r2.overLaps(Practice_5.Validate("(1,8)")) === true)
  }
  test("OverLaps should return false to this range (7,15)") {
    assert(r3.overLaps(Practice_5.Validate("(7,15)")) == false)
  }
  test("OverLaps should return false to this range (0,15)") {
    assert(r4.overLaps(Practice_5.Validate("(0,15)")) === false)
  }

  test("Equals shold return true to this range (1,6)") {
    assert(r1.equals(Practice_5.Validate("(1,6)")) === true)
  }
  test("Equals shold return true to this range [5,13)") {
    assert(r2.equals(Practice_5.Validate("[5,13)")) === true)
  }
  test("Equals shold return false to this range (-2,0)") {
    assert(r3.equals(Practice_5.Validate("(-2,0)")) === false)
  }
  test("Equals shold return false to this range [-10,3]") {
    assert(r4.equals(Practice_5.Validate("[-10,3]")) === false)
  }

  test("NotEquals shold return false to this range (1,6)") {
    assert(r1.notEquals(Practice_5.Validate("(1,6)")) === false)
  }
  test("NotEqualsshold return false to this range [5,13)") {
    assert(r2.notEquals(Practice_5.Validate("[5,13)")) === false)
  }
  test("NotEqualsshold return true to this range (-2,0)") {
    assert(r3.notEquals(Practice_5.Validate("(-2,0)")) === true)
  }
  test("NotEqualsshold return true to this range [-10,3]") {
    assert(r4.notEquals(Practice_5.Validate("[-10,3]")) === true)
  }

}
