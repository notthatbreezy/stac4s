package com.azavea.stac4s.core

import com.azavea.stac4s.meta._
import io.circe._
import io.circe.generic.semiauto._

final case class SpatialExtent(bbox: List[Bbox])

object SpatialExtent {
  implicit val encSpatialExtent: Encoder[SpatialExtent] = deriveEncoder
  implicit val decSpatialExtent: Decoder[SpatialExtent] = deriveDecoder
}

final case class Interval(interval: List[TemporalExtent])

object Interval {
  implicit val encInterval: Encoder[Interval] = deriveEncoder
  implicit val decInterval: Decoder[Interval] = deriveDecoder
}

final case class StacExtent(
    spatial: SpatialExtent,
    temporal: Interval
)

object StacExtent {
  implicit val encStacExtent: Encoder[StacExtent] = deriveEncoder
  implicit val decStacExtent: Decoder[StacExtent] = deriveDecoder
}
