
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = Project("smithy4s-error-handler", base = file("."))
  .aggregate(service)

lazy val service = project.in(file("service"))
  .enablePlugins(Smithy4sCodegenPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "com.disneystreaming.smithy4s" %% "smithy4s-core" % "0.17.5",
      "com.disneystreaming.smithy4s" %% "smithy4s-http4s" % "0.17.5",
      "dev.zio" %% "zio" % "2.0.13",
      "dev.zio" %% "zio-interop-cats" % "23.0.03",
      "dev.zio" %% "zio-logging" % "2.1.13",
      "dev.zio" %% "zio-logging-slf4j" % "2.1.13",
      "ch.qos.logback" % "logback-classic" % "1.4.7",
      "org.http4s" %% "http4s-dsl" % "0.23.18",
      "org.http4s" %% "http4s-ember-server" % "0.23.18",
    ))