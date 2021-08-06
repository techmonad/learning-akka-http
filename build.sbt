name := "learning-akka-http"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.6",
  "org.json4s" %% "json4s-native" % "3.6.11",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.2.6" % Test
)
        