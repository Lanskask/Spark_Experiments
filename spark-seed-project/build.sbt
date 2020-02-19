name := "Hello Spark"

val sparkVersion = "2.2.3"
val sparkScalaVersion = "2.11"

val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "com.typesafe" % "config" % "1.3.1",
  "joda-time" % "joda-time" % "2.9.9",
  "org.joda" % "joda-convert" % "1.9.2"
)

libraryDependencies ++= Seq(
  "com.google.cloud" % "google-cloud-bigquery" % "1.39.0",
  "com.google.cloud.bigdataoss" % "bigquery-connector" % "hadoop2-0.13.17",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
//  "org.apache.spark" % "spark-hive" % sparkVersion
)

libraryDependencies ++= sparkDependencies.map(_ % "provided")

lazy val commonSettings = Seq(
  scalaVersion := "2.11.8",
  resolvers += Resolver.mavenLocal,
  resolvers += Resolver.typesafeRepo("releases")
)

commonSettings

outputStrategy := Some(StdoutOutput)

run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))

//update your Intellij configuration to use `mainRunner` when running from Intellij (not the default)
lazy val mainRunner = project.in(file("mainRunner")).dependsOn(RootProject(file("."))).settings(
  commonSettings,
  libraryDependencies ++= sparkDependencies.map(_ % "compile"),
  assembly := new File(""),
  publish := {},
  publishLocal := {}
)