package fhuz.unfiltered.demo.server

import fhuz.unfiltered.demo.plan.CocktailsPlan
	
object Server {
  def main(args: Array[String]) {
	unfiltered.jetty.Http.local(8080)
		.filter(new SayHelloFilter)
		.filter(new CocktailsPlan)
		.run
  }
}
