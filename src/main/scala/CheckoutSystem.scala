import Fruits._
object CheckoutSystem {
  def main(args: Array[String]): Unit = {
    println("Welcome in Checkout System!")
    println("Please Provide the list of fruits as Strings separated by spaces [apple or a for apple and orange or o for orange]")
    println("For example: 'a a a o orange ' gives 3 apples and 2 oranges")
    val fruitsString = scala.io.StdIn.readLine

    val fruits = mapStringToFruits(fruitsString)
    val totalPrice = calculatePrice(fruits)

    println("Total price for given fruits is: " + totalPrice + " pounds.")
  }

  def calculatePrice(fruits: List[Fruit]): Double = {
    fruits.groupBy(fruit => fruit).mapValues(_.size).map((fruit) => fruitsToPrices(fruit)).sum
  }
}
