val FlinkVersion     = "1.8.1"
val ScalaTestVersion = "3.0.8"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

organization := "CloverGroup"
name := "zio-sched"
version := "0.0.1"
scalaVersion := "2.12.8"
maxErrors := 3
libraryDependencies ++= Seq(
  "org.scalactic"    %% "scalactic"             % ScalaTestVersion,
  "org.scalatest"    %% "scalatest"             % ScalaTestVersion % "test",
  "org.apache.flink" %% "flink-streaming-scala" % FlinkVersion
)

// Refine scalac params from tpolecat
scalacOptions --= Seq(
  "-Xfatal-warnings"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
addCommandAlias("cov", "; clean; coverage; test; coverageReport")
