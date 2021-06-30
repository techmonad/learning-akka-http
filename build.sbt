name := "learning-akka-http"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.4",
  "org.json4s" %% "json4s-native" % "4.0.1",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.4" % Test
)
        