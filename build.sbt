name := "learning-akka-http"

version := "0.1"

scalaVersion := "2.12.13"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.15",
  "org.json4s" %% "json4s-native" % "3.5.5",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.15" % Test
)
        