import sbt.{Defaults, Watched}
import sbt.Keys._

object BuildSettings {

  import Dependencies.Resolvers._

  val ParentProject = "jars_parent"
  val Stream = "fey_stream"
  val ZMQ = "fey_zmq"


  val Version = "1.0"
  val ScalaVersion = "2.11.8"

  lazy val rootbuildSettings = Defaults.coreDefaultSettings ++ Seq(
    name := ParentProject,
    version := Version,
    scalaVersion := ScalaVersion,
    organization := "org.apache.iota",
    description := "Fey External Jars Project",
    scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8", "-Xlint")
  )

  lazy val BasicSettings = Seq(
    organization := "org.apache.iota",
    maxErrors := 5,
    ivyScala := ivyScala.value map {
      _.copy(overrideScalaVersion = true)
    },
    triggeredMessage := Watched.clearWhenTriggered,
    resolvers := allResolvers,
    fork := true,
    connectInput in run := true
  )

  lazy val StreambuildSettings = Defaults.coreDefaultSettings ++ Seq(
    name := Stream,
    version := Version,
    scalaVersion := ScalaVersion,
    description := "Simple Stream Application",
    scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8", "-Xlint"),
    mainClass := Some("org.apache.iota.fey.performer.Application")
  )

  lazy val ZMQbuildSettings = Defaults.coreDefaultSettings ++ Seq(
    name := ZMQ,
    version := Version,
    scalaVersion := ScalaVersion,
    description := "ZMQ Application",
    scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8", "-Xlint"),
    mainClass := Some("org.apache.iota.fey.performer.Application")
  )

}
