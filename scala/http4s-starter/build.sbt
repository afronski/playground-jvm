name := "http4s-starter"

version := "1.0"

scalaVersion := "2.11.4"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core" % "0.5.+",
  "org.http4s" %% "http4s-json4s" % "0.5.+",
  "org.http4s" %% "http4s-dsl" % "0.5.+",
  "org.http4s" %% "http4s-blazeserver" % "0.5.+",
  "org.scalaz" %% "scalaz-core" % "7.1.+"
)