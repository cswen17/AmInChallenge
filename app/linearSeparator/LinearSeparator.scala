import scala.collection.mutable.{Map, HashMap}

/*
 * A Linear Separator that classifies a given point into the right class
 *
 * |+  +  /
 * |+    /  - -
 * | +  / -  -
 * |+ +/ - - -  -
 * ______________
 *
 * Limited to 2 dimensions.
 *
 * Example:
 * 
 *   var perceptron: LinearSeparator = new LinearSeparator()
 *   var point: Point = new Point(1, 0, 1, 0, 1, 0, 1)
 *   perceptron.classify(point)
 *   Logger.debug("LinearSeparator best fit line is " + perceptron.lineEq)
 */
class LinearSeparator {
  // need a mapping of some kind to store the points inputted
  // so far and their classifications
  //
  // need to store the best fit line somehow

  var lineEq : Line = new Line(0.0, 0.0)

  // mapping of point to (line, classification) tuple
  var history : Map[Point, Tuple2[Line, Classification]] = new HashMap[Point, Tuple2[Line, Classification]]()

  def update(point: Point) : LinearSeparator = {
    this
  }
}

class Line(var slope: Double, var offset: Double){

  override def toString : String = "y = " + slope + "x + " + offset

  def update(_slope : Double, _offset: Double): Line = {
    slope = _slope
    offset = _offset
    this
  }
}

case class Classification (classification : String) {
  var plus: String = "Positive"
  var minus: String = "Negative"
  
  def setPlus(_plus : String) = {
    plus = _plus
    this
  }

  def setMinus(_minus : String) = {
    minus = _minus
    this
  }
}

class Point(val x: Double, val y: Double)
