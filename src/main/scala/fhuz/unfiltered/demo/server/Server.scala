package fhuz.unfiltered.demo.server

import fhuz.unfiltered.demo.plan.CocktailsPlan
import fhuz.unfiltered.demo.intent.SayHello

object SayHelloFilter extends 
	unfiltered.filter.Planify(SayHello.intent)
	
object Server {
  def main(args: Array[String]) {
	unfiltered.jetty.Http.local(8080)
	.filter(SayHelloFilter)
	.filter(CocktailsPlan).run
  }
}
