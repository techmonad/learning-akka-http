name := "learning-akka-http"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "org.json4s" %% "json4s-native" % "3.5.0",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10" % Test
)
        