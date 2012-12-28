package fhuz.unfiltered.demo.intent

import unfiltered.request._
import unfiltered.response._

object SayHello {
  
  object NonEmptyName extends Params.Extract("name",Params.first ~> Params.nonempty)

  val intent = unfiltered.Cycle.Intent[Any, Any] {
    
    case req@Path(Seg("hello" :: name :: Nil)) => req match {
    	case GET(_) => Ok ~> ResponseString("Hello " + name)
    	
        case _ => MethodNotAllowed ~> ResponseString("Method must be GET")   
    }
    case req@Path("/hello")   => req match {
        case POST(_) & Params(params) =>  Ok ~> ResponseString("Hello " + params("name")(0).toString)
        //case POST(_) & Params(NonEmptyName(name)) =>  Ok ~> ResponseString("Hello " + name.toString)
        //case POST(_) => BadRequest ~> ResponseString("""The parameter "name" is missing""")
        case _ => MethodNotAllowed ~> ResponseString("Method must be POST")
      }
  }
}