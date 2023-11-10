ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "scala",
    organization := "com.example" // Add organization name
  )

libraryDependencies += "net.aichler" % "jupiter-interface" % "0.9.0" % Test

addSbtPlugin("net.aichler" % "sbt-jupiter-interface" % "0.9.0")
