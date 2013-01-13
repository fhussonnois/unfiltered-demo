package fhuz.unfiltered.demo.server

import fhuz.unfiltered.demo.intent.SayHello

class SayHelloFilter extends 
	unfiltered.filter.Planify(SayHello.intent)