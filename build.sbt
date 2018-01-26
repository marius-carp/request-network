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


addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

resolvers ++= Seq(
  "jitpack.io" at "https://jitpack.io"
)

//utils
libraryDependencies ++= Seq(
  "org.web3j"                  % "core"                      % "3.2.0",
  "com.github.ipfs"            % "java-ipfs-api"             % "v1.2.0"
)

//config
libraryDependencies ++= Seq(
  "com.typesafe"               % "config"                    % "1.3.1"
)

// Json
libraryDependencies ++= Seq(
  "com.typesafe.play"          %% "play-json"                % "2.6.2",
  "com.kifi"                   %% "json-annotation"          % "0.3.1"
)

// Logging
val logBackVersion = "1.2.3"
libraryDependencies ++= Seq(
  "ch.qos.logback"             %  "logback-core"             % logBackVersion,
  "ch.qos.logback"             %  "logback-classic"          % logBackVersion,
  "com.typesafe.scala-logging" %% "scala-logging"            % "3.7.2"
)

// Testing
val spec2Version = "3.9.4"
libraryDependencies ++= Seq(
  "org.specs2"                 %% "specs2-core"              % spec2Version % "test",
  "org.specs2"                 %% "specs2-mock"              % spec2Version % "test"
)