name := "request-network"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project!")
}

scalacOptions := Seq(
  "-deprecation",
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-Ywarn-dead-code",
  "-Ywarn-unused-import"
)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

resolvers ++= Seq(
  "jitpack.io" at "https://jitpack.io",
  "ethereum" at "https://dl.bintray.com/ethereum/maven/",
  "micronautics/scala on bintray" at "http://dl.bintray.com/micronautics/scala"
)

//api
libraryDependencies ++= Seq(
  "org.web3j" % "core" % "3.2.0",
  "com.micronautics" %% "web3j-scala" % "0.2.0" withSources (),
  "com.github.ipfs" % "java-ipfs-api" % "v1.2.0"
)

//util
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.1",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0"
)

// Json
libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.6.7"
)

// Logging
val logBackVersion = "1.2.3"
libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-core" % logBackVersion,
  "ch.qos.logback" % "logback-classic" % logBackVersion,
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
)

// Testing
val spec2Version = "3.9.4"
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % spec2Version % "test",
  "org.specs2" %% "specs2-mock" % spec2Version % "test"
)
