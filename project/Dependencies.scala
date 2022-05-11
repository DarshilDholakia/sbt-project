import sbt._

object Dependencies {
  val scalaRequests = "com.lihaoyi" %% "requests" % "0.7.0"
  val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "2.1.0"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.12"
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % "10.2.9"
  val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.6.19"
  val json4s = "org.json4s" %% "json4s-native" % "4.0.5"

  val commonDependencies: Seq[ModuleID] = Seq(scalaTest % Test)

  val apiDependencies: Seq[ModuleID] = Seq(scalaRequests,
    scalaXml, akkaHttp, akkaStream, json4s) ++ commonDependencies

  val calculatorDependencies: Seq[ModuleID] = commonDependencies
}
