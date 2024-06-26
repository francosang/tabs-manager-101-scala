import scala.language.postfixOps
import sbtwelcome.*

import scala.sys.process.*

Global / onChangedBuildSource := ReloadOnSourceChanges


lazy val npmBuild = taskKey[Unit]("NPM build")
npmBuild := {
  "npm install" #&& "npm build" !
}

lazy val npmStart = taskKey[Unit]("NPM start")
npmStart := {
  "npm install" #&& "npm start" !
}

lazy val start = taskKey[Unit]("Start live compile and frontend dev server")
start := {
  npmStart.value
  (Compile / fastLinkJS).value
}

lazy val `app-tyrian-template` =
  (project in file("."))
    .enablePlugins(ScalaJSPlugin)
    .settings( // Normal settings
      name := "tyrian-template-poc",
      libraryDependencies ++= Seq(
        "io.indigoengine" %%% "tyrian-io" % "0.10.0",
        "org.scalameta"   %%% "munit"     % "0.7.29" % Test
      ) ++ Seq(
        "io.circe" %%% "circe-core",
        "io.circe" %%% "circe-parser",
        "io.circe" %%% "circe-generic"
      ).map(_ % "0.14.5") ++ Seq(
        "org.http4s" %%% "http4s-dom"   % "0.2.7",
        "org.http4s" %%% "http4s-circe" % "0.23.18"
      ),
      testFrameworks += new TestFramework("munit.Framework"),
      scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
      autoAPIMappings := true
    )
    .settings( // Welcome message
      logo := List(
        """
        |   _____           _         _     
        |  / ____|         | |       (_)    
        | | (___   ___ __ _| | __ _   _ ___ 
        |  \___ \ / __/ _` | |/ _` | | / __|
        |  ____) | (_| (_| | | (_| |_| \__ \
        | |_____/ \___\__,_|_|\__,_(_) |___/
        |                           _/ |    
        |                          |__/     
        """.stripMargin
      ).mkString("\n"),
      usefulTasks := Seq(
        UsefulTask(
          "~fastLinkJS",
          "Live rebuild the JS (use during development)"
        ).noAlias,
        UsefulTask(
          "fastLinkJS ",
          "Rebuild the JS (use during development)"
        ).noAlias,
        UsefulTask(
          "fullLinkJS ",
          "Rebuild the JS and optimise (use in production)"
        ).noAlias
      ),
      logoColor        := scala.Console.MAGENTA,
      aliasColor       := scala.Console.BLUE,
      commandColor     := scala.Console.CYAN,
      descriptionColor := scala.Console.WHITE
    )
