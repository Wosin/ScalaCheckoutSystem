trait Fruit
case object Orange extends Fruit
case object Apple extends Fruit
object Fruits {
  type Promotion = (Int => Int)

  val fruitPrices = Map[Fruit, Double](Orange -> 0.25, Apple -> 0.60)
  val fruitPromotions = Map[Fruit, List[Promotion]](
    Apple -> List((numberOfItems) => (numberOfItems)/2 + numberOfItems % 2),
    Orange -> List(numberOfItems =>  (numberOfItems/3) * 2 + numberOfItems % 3)
  )

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
    val numberOfItemsAfterPromotion = applyPromotions(entry._1, entry._2)
    fruitPrices.getOrElse(entry._1, 0.0) * numberOfItemsAfterPromotion
  }

  def applyPromotions(fruit: Fruit, numberOfItems: Int) = {
    val promoFunctions = fruitPromotions.getOrElse(fruit, List.empty)
    promoFunctions.foldLeft(numberOfItems){((previousResult, promoFunction) => promoFunction(previousResult))}
  }

}
