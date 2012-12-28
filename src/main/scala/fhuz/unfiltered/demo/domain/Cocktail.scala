package fhuz.unfiltered.demo.domain

object Cocktail {
	  type Ingrediant = String
	  type Quantity = String
}
case class Cocktail(
    val name: String, 
    val recipe: String,
    val ingrediants: List[(Cocktail.Ingrediant, Cocktail.Quantity)]
)

