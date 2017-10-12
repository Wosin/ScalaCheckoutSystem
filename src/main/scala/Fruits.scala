

trait Fruit
case object Orange extends Fruit
case object Apple extends Fruit

object Fruits {

  val fruitPrices = Map[Fruit, Double](Orange -> 0.25, Apple -> 0.60)

  private def fruitFromString(fruitString: String): Fruit = {
    fruitString.toLowerCase match {
      case "orange" | "o" => Orange
      case "apple" | "a" => Apple
    }
  }

  def mapStringToFruits(fruitsString: String): List[Fruit] = {
    fruitsString.split(" ").map(fruitFromString).toList
  }

  def fruitsToPrices(entry: (Fruit, Int)): Double = {
    fruitPrices.getOrElse(entry._1, 0.0) * entry._2
  }

}
