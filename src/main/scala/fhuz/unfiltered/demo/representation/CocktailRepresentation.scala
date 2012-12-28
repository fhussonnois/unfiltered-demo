package fhuz.unfiltered.demo.representation

import fhuz.unfiltered.demo.domain.Cocktail

import net.liftweb.json.JsonDSL._
import net.liftweb.json.JsonAST.JValue

object CocktailRepresentation {

  implicit def toJValue(cocktails: Seq[Cocktail]): JValue =
    ("cocktails" -> cocktails.map(c => toJValue(c)))

  implicit def toJValue(cocktail: Cocktail): JValue =
    	("name" -> cocktail.name) ~
    	("recipe" -> cocktail.recipe) ~
    	("ingrediants" ->
    		cocktail.ingrediants.map(i =>
    		("name" -> i._1) ~
            ("quantity" -> i._2)))
}