import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Wosin on 16.10.2017.
  */
class CheckoutSystemTest extends FlatSpec with Matchers {

  "A String" should "should be mapped to proper combination of fruits" in {

    val fruitsString = "o orange a apple a o o apple"
    val fruits = List(Orange, Orange, Apple, Apple, Apple, Orange, Orange, Apple)

    val mappedFruits = Fruits.mapStringToFruits(fruitsString)

    mappedFruits shouldEqual fruits
  }

  "Checkout System" should "calculate proper price for given list of fruits" in {
    val fruits = List(Orange, Apple, Apple, Apple)
    val price = CheckoutSystem.calculatePrice(fruits)

    price shouldEqual 1.45
  }

  "Checkout System" should "calculate price of two apples when 4 are bought" in {
    val fruits = List(Apple, Apple, Apple, Apple)
    val afterDicountList = List(Apple, Apple, Apple)
    val price = CheckoutSystem.calculatePrice(fruits)
    val priceDiscountedManually = CheckoutSystem.calculatePrice(afterDicountList)

    price shouldEqual 1.2
    price shouldEqual priceDiscountedManually
  }

  "Checkout System" should "calculate price of four oranges when 6 are bought" in {
    val fruits = List(Orange, Orange, Orange, Orange, Orange, Orange)
    val afterDiscountList = List(Orange, Orange, Orange, Orange, Orange)

    val price = CheckoutSystem.calculatePrice(fruits)
    val priceDiscountedManually = CheckoutSystem.calculatePrice(afterDiscountList)

    price shouldEqual 1.0
    price shouldEqual priceDiscountedManually
  }
}
