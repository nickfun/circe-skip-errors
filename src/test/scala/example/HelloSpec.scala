package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HelloSpec extends AnyFlatSpec with Matchers {

  def json(s: String): io.circe.Json = io.circe.parser.parse(s).right.get

  "The Hello object" should "say hello" in {
    Hello.greeting shouldEqual "hello"
  }

  "test setup" should "be valid" in {
    val x = Obj1("Nick", 999, None)
    x.name shouldEqual "Nick"
  }


  "json things" should "become a string" in {
    val e = Obj1("nick", 999, None)
    val s = Obj1.encoder(e).noSpaces
    s shouldEqual """{"name":"nick","age":999,"gtags":null}"""
  }

  "decoder" should "json string -> object" in {
    val start = """{"name":"dude","age":-100,"gtags":null}"""
    val end = Obj1.decoder(io.circe.parser.parse(start).right.get.hcursor)
    end.isRight shouldEqual true
    end.right.get shouldEqual Obj1("dude", -100, None)
  }

  "gtag" should "exist" in {
    val g: Obj1.Gtag = Map("xyz" -> None, "abc" -> Some("bacon"))
    g.size shouldEqual 2
  }

  "gtag good decode" should "become gtag" in {
    val input =
      """
        |{"abc": null,
        |"xyz":"bacon"
        |}
        |""".stripMargin
    val g = Obj1.gtag_decoder(json(input).hcursor)
    g.isRight shouldEqual true
    g.map { optionGtag =>
      optionGtag.isDefined shouldEqual true
      optionGtag.get.size shouldEqual 2
      optionGtag.get.keySet.contains("abc") shouldEqual true
      optionGtag.get.keySet.contains("xyz") shouldEqual true
    }
  }

  "invalid gtag json" should "become a None" in {
    val input = """ [1,2,3] """
    val g = Obj1.gtag_decoder(json(input).hcursor)
    g.isRight shouldEqual true
    g.right.get.isEmpty shouldEqual true
  }
}
