val CatsVersion      = "2.0.0-RC1"
val FlinkVersion     = "1.8.1"
val ScalaTestVersion = "3.0.8"
val LogbackVersion   = "1.2.3"
val ScalaLogVersion  = "3.9.2"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

organization := "CloverGroup"
name := "zio-sched"
version := "0.0.1"
scalaVersion := "2.12.8"
maxErrors := 3
libraryDependencies ++= Seq(
  "org.scalactic"              %% "scalactic"             % ScalaTestVersion,
  "org.scalatest"              %% "scalatest"             % ScalaTestVersion % "test",
  "org.typelevel"              %% "cats-core"             % CatsVersion,
  "org.apache.flink"           %% "flink-streaming-scala" % FlinkVersion,
  "ch.qos.logback"             % "logback-classic"        % LogbackVersion,
  "com.typesafe.scala-logging" %% "scala-logging"         % ScalaLogVersion
)

// Refine scalac params from tpolecat
scalacOptions --= Seq(
  "-Xfatal-warnings"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
addCommandAlias("cov", "; clean; coverage; test; coverageReport")
