package com.azavea.stac4s.example.tileserver

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits._
import com.softwaremill.sttp.asynchttpclient.cats.AsyncHttpClientCatsBackend
import org.http4s.server.blaze._

object Server extends IOApp {

  implicit val backend = AsyncHttpClientCatsBackend[IO]()
  val stacService      = new StacService()

  def run(args: List[String]): IO[ExitCode] =
    BlazeServerBuilder[IO]
      .bindHttp(8080, "0.0.0.0")
      .withHttpApp(stacService.app)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
}
