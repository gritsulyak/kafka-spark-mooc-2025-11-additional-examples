
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val sparkVersion = "3.5.7" // sep 2025

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-sql_2.13" % sparkVersion % "provided",
  "org.apache.spark" % "spark-streaming_2.13" % sparkVersion % "provided",
  "org.apache.spark" % "spark-sql-kafka-0-10_2.13" % sparkVersion
)

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")       => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$")   => MergeStrategy.discard
  case "reference.conf"                                 => MergeStrategy.concat
  case x: String if x.contains("UnusedStubClass.class") => MergeStrategy.first
  case _                                                => MergeStrategy.first
}