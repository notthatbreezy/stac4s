package com.azavea.stac4s.core

import cats.implicits._
import io.circe._

final case class StacLink(
    href: String,
    rel: StacLinkType,
    _type: Option[StacMediaType],
    title: Option[String],
    labelExtAssets: List[String]
)

object StacLink {

  implicit val encStacLink: Encoder[StacLink] = Encoder.forProduct5(
    "href",
    "rel",
    "type",
    "title",
    "label:assets"
  )(link => (link.href, link.rel, link._type, link.title, link.labelExtAssets))

  implicit val decStacLink: Decoder[StacLink] = new Decoder[StacLink] {

    def apply(c: HCursor) =
      (
        c.downField("href").as[String],
        c.downField("rel").as[StacLinkType],
        c.get[Option[StacMediaType]]("type"),
        c.get[Option[String]]("title"),
        c.get[Option[List[String]]]("label:assets")
      ).mapN(
        (
            href: String,
            rel: StacLinkType,
            _type: Option[StacMediaType],
            title: Option[String],
            assets: Option[List[String]]
        ) => StacLink(href, rel, _type, title, assets getOrElse List.empty)
      )
  }
}
