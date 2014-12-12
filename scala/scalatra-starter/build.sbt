name := "scalatra-starter"

version := "1.0"

scalaVersion := "2.11.4"

jetty()

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % "2.3.0",
  "org.eclipse.jetty" %% "jetty-webapp" % "9.3.0.M1",
  "javax.servlet" %% "javax.servlet-api" % "3.1.0"
)