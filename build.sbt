import xerial.sbt.Sonatype._

cancelable in Global := true
onLoad in Global ~= (_ andThen ("project core" :: _))

lazy val credentialSettings = Seq(
  credentials += Credentials(
    "GnuPG Key ID",
    "gpg",
    System.getenv().get("GPG_KEY_ID"),
    "ignored"
  ),
  credentials += Credentials(
    "Sonatype Nexus Repository Manager",
    "oss.sonatype.org",
    System.getenv().get("SONATYPE_USERNAME"),
    System.getenv().get("SONATYPE_PASSWORD")
  )
)

lazy val sonatypeSettings = Seq(
  publishMavenStyle := true,
  sonatypeProfileName := "com.azavea",
  sonatypeProjectHosting := Some(GitHubHosting(user = "azavea", repository = "stac4s", email = "systems@azavea.com")),
  developers := List(
    Developer(
      id = "cbrown",
      name = "Christopher Brown",
      email = "cbrown@azavea.com",
      url = url("https://github.com/notthatbreezy")
    ),
    Developer(
      id = "jsantucci",
      name = "James Santucci",
      email = "jsantucci@azavea.com",
      url = url("https://github.com/jisantuc")
    ),
    Developer(
      id = "aaronxsu",
      name = "Aaron Su",
      email = "asu@azavea.com",
      url = url("https://github.com/aaronxsu")
    ),
    Developer(
      id = "azavea",
      name = "Azavea Inc.",
      email = "systems@azavea.com",
      url = url("https://www.azavea.com")
    )
  ),
  licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")),
  publishTo := sonatypePublishTo.value
)

lazy val publishSettings = Seq(
  organization := "com.azavea.stac4s",
  organizationName := "Azavea",
  organizationHomepage := Some(new URL("https://azavea.com/")),
  description := "stac4s is a scala library with primitives to build applications using the SpatioTemporal Asset Catalogs specification",
  publishArtifact in Test := false
) ++ sonatypeSettings ++ credentialSettings

// Versions
val CatsEffectVersion        = "1.3.0"
val CatsVersion              = "1.6.0"
val CirceFs2Version          = "0.11.0"
val CirceVersion             = "0.11.1"
val DeclineVersion           = "0.5.0"
val Fs2Version               = "1.0.4"
val GeoTrellisContribVersion = "3.16.0"
val GeoTrellisVersion        = "3.0.0-M3"
val GeotrellisServer         = "3.4.0-9-geeb1ede-SNAPSHOT"
val Http4sVersion            = "0.20.0"
val MamlVersion              = "0.4.0"
val RefinedVersion           = "0.9.3"
val SPDXCheckerVersion       = "1.0.0"
val ScalacheckCatsVersion    = "0.1.1"
val ScalacheckVersion        = "1.14.0"
val ScalatestVersion         = "3.0.4"
val ScapegoatVersion         = "1.3.8"
val ShapelessVersion         = "2.3.3"
val Slf4jVersion             = "1.8.0-beta2"
val SpireVersion             = "0.13.0"
val SprayVersion             = "1.3.4"
val SttpVersion              = "1.5.17"
val TypeSafeLoggingVersion   = "3.9.0"

// Dependencies
val Cats                  = "org.typelevel"               %% "cats-core"                      % CatsVersion
val CatsEffect            = "org.typelevel"               %% "cats-effect"                    % CatsEffectVersion
val CirceCore             = "io.circe"                    %% "circe-core"                     % CirceVersion
val CirceFs2              = "io.circe"                    %% "circe-fs2"                      % CirceFs2Version
val CirceGeneric          = "io.circe"                    %% "circe-generic"                  % CirceVersion
val CirceParser           = "io.circe"                    %% "circe-parser"                   % CirceVersion
val CirceRefined          = "io.circe"                    %% "circe-refined"                  % CirceVersion
val Decline               = "com.monovore"                %% "decline"                        % DeclineVersion
val Fs2                   = "co.fs2"                      %% "fs2-core"                       % Fs2Version
val GeoTrellisContribGDAL = "com.azavea.geotrellis"       %% "geotrellis-contrib-gdal"        % GeoTrellisContribVersion
val GeoTrellisProj4       = "org.locationtech.geotrellis" %% "geotrellis-proj4"               % GeoTrellisVersion
val GeoTrellisRaster      = "org.locationtech.geotrellis" %% "geotrellis-raster"              % GeoTrellisVersion
val GeoTrellisServerCore  = "com.azavea.geotrellis"       %% "geotrellis-server-core"         % GeotrellisServer
val GeoTrellisSpark       = "org.locationtech.geotrellis" %% "geotrellis-spark"               % GeoTrellisVersion
val GeoTrellisVector      = "org.locationtech.geotrellis" %% "geotrellis-vector"              % GeoTrellisVersion
val GeoTrellisVLM         = "com.azavea.geotrellis"       %% "geotrellis-contrib-vlm"         % GeoTrellisContribVersion
val Http4sBlazeServer     = "org.http4s"                  %% "http4s-blaze-server"            % Http4sVersion
val Http4sCirce           = "org.http4s"                  %% "http4s-circe"                   % Http4sVersion
val Http4sCore            = "org.http4s"                  %% "http4s-core"                    % Http4sVersion
val Http4sDsl             = "org.http4s"                  %% "http4s-dsl"                     % Http4sVersion
val Gttp4sServer          = "org.http4s"                  %% "http4s-server"                  % Http4sVersion
val Maml                  = "com.azavea.geotrellis"       %% "maml-jvm"                       % MamlVersion
val Refined               = "eu.timepit"                  %% "refined"                        % RefinedVersion
val Scalacheck            = "org.scalacheck"              %% "scalacheck"                     % ScalacheckVersion % Test
val ScalacheckCats        = "io.chrisdavenport"           %% "cats-scalacheck"                % ScalacheckCatsVersion % Test
val Scalatest             = "org.scalatest"               %% "scalatest"                      % ScalatestVersion % Test
val Shapeless             = "com.chuusai"                 %% "shapeless"                      % ShapelessVersion
val Slf4j                 = "org.slf4j"                   % "slf4j-api"                       % Slf4jVersion
val SPDXChecker           = "com.github.tbouron"          % "spdx-license-checker"            % SPDXCheckerVersion
val Spire                 = "org.spire-math"              %% "spire"                          % SpireVersion
val Spray                 = "io.spray"                    %% "spray-json"                     % SprayVersion
val Sttp                  = "com.softwaremill.sttp"       %% "core"                           % SttpVersion
val SttpCats              = "com.softwaremill.sttp"       %% "async-http-client-backend-cats" % SttpVersion
val SttpCirce             = "com.softwaremill.sttp"       %% "circe"                          % SttpVersion
val SttpJson              = "com.softwaremill.sttp"       %% "json-common"                    % SttpVersion
val TypesafeLogging       = "com.typesafe.scala-logging"  %% "scala-logging"                  % TypeSafeLoggingVersion

lazy val settings = Seq(
  organization := "com.azavea",
  name := "stac4s",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.12.10",
  scalafmtOnCompile := true,
  scapegoatVersion in ThisBuild := Versions.ScapegoatVersion,
  scapegoatDisabledInspections := Seq("ObjectNames", "EmptyCaseClass"),
  unusedCompileDependenciesFilter -= moduleFilter("com.sksamuel.scapegoat", "scalac-scapegoat-plugin"),
  addCompilerPlugin("org.spire-math" %% "kind-projector"     % "0.9.6"),
  addCompilerPlugin("com.olegpy"     %% "better-monadic-for" % "0.2.4"),
  addCompilerPlugin(
    "org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full
  ),
  addCompilerPlugin(scalafixSemanticdb),
  autoCompilerPlugins := true,
  externalResolvers := Seq(
    DefaultMavenRepository,
    Resolver.sonatypeRepo("snapshots"),
    Resolver.typesafeIvyRepo("releases"),
    Resolver.bintrayRepo("azavea", "maven"),
    Resolver.bintrayRepo("azavea", "geotrellis"),
    "locationtech-releases" at "https://repo.locationtech.org/content/groups/releases",
    "locationtech-snapshots" at "https://repo.locationtech.org/content/groups/snapshots",
    Resolver.bintrayRepo("guizmaii", "maven"),
    Resolver.bintrayRepo("colisweb", "maven"),
    "jitpack".at("https://jitpack.io"),
    Resolver.file("local", file(Path.userHome.absolutePath + "/.ivy2/local"))(
      Resolver.ivyStylePatterns
    )
  )
)

lazy val coreDependencies = Seq(
  Cats,
  CirceCore,
  CirceGeneric,
  CirceParser,
  GeoTrellisVector,
  Refined,
  SPDXChecker,
  Scalacheck,
  ScalacheckCats,
  Scalatest,
  Shapeless,
  Spray
)

lazy val core = (project in file("modules/core"))
  .settings(settings: _*)
  .settings({
    libraryDependencies ++= coreDependencies
  })
lazy val coreRef = LocalProject("modules/core")

lazy val exampleDependencies = Seq(
  Cats,
  CatsEffect,
  CirceCore,
  Decline,
  Fs2,
  GeoTrellisContribGDAL,
  GeoTrellisProj4,
  GeoTrellisRaster,
  GeoTrellisServerCore,
  GeoTrellisSpark,
  GeoTrellisVLM,
  GeoTrellisVector,
  Gttp4sServer,
  Http4sBlazeServer,
  Http4sCirce,
  Http4sCore,
  Http4sDsl,
  Maml,
  Slf4j,
  Spire,
  Sttp,
  SttpCats,
  SttpCirce,
  SttpJson,
  TypesafeLogging
)

lazy val example = (project in file("modules/example"))
  .settings(settings: _*)
  .settings({
    libraryDependencies ++= exampleDependencies
  })
  .dependsOn(core)

lazy val exampleRef = LocalProject("modules/example")
