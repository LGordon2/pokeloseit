name := "PokeLoseIt"

version := "1.0"

lazy val `pokeloseit` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws )

libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"

libraryDependencies += "org.webjars" % "bootstrap" % "3.3.2"

libraryDependencies += "org.webjars" % "angularjs" % "1.3.14"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  