import com.typesafe.sbt.packager.docker.ExecCmd

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .aggregate(calculators, api)
lazy val calculators = project
  .dependsOn(api)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .settings(
    libraryDependencies ++= Dependencies.calculatorDependencies,
    dockerCommands := dockerCommands.value.filterNot {
      case ExecCmd("ENTRYPOINT", _) => true
      case _ => false
    },
    dockerCommands ++= Seq(ExecCmd("ENTRYPOINT", "/opt/docker/bin/net-worth"))
  )
lazy val api = project
  .enablePlugins(JavaAppPackaging)
  .settings(
//    libraryDependencies ++= Seq(
//      "com.lihaoyi" %% "requests" % "0.7.0",
//      "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
//      "org.scalatest" %% "scalatest" % "3.2.12" % "test" // this line is known as module ID (1st part: organisation, 2nd
      // part: name of the library, 3rd part: revision of library, 4th part: test configuration (this means that this
      // library will only be available when running tests - in test scope therefore during packaging when creating
      // final artifact, this library won't be available in final JAR file))
//    )
    libraryDependencies ++= Dependencies.apiDependencies
  )

