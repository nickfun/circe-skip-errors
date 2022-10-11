package example

import io.circe.Encoder.AsObject
import io.circe.generic.semiauto._
import io.circe.{Decoder, Json}

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}


case class Obj1(name: String, age: Int, gtags: Option[Map[String,Option[String]]])


object Obj1 {
  type Gtag = Map[String,Option[String]]

  implicit val gtag_decoder: Decoder[Option[Gtag]] = decodeMyOption[Gtag]

  implicit val encoder: AsObject[Obj1] = deriveEncoder[Obj1]
  implicit val decoder: Decoder[Obj1] = deriveDecoder[Obj1]

  def decodeListTolerantly[A: Decoder]: Decoder[List[A]] =
    Decoder.decodeList(Decoder[A].either(Decoder[Json])).map(
      _.flatMap(_.left.toOption)
    )

  def decodeMyOption[A: Decoder]: Decoder[Option[A]] = {
    Decoder.decodeOption(Decoder[A].either(Decoder[Json])).map(
      _.flatMap(_.left.toOption)
    )
  }
}
