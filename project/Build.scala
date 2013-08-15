import sbt._
import Keys._

object SnapDimBuild extends Build {
  lazy val snapDimSettings = Project.defaultSettings ++ Seq(
    name := "SnapDim",
    version := "0.1",
    scalaVersion := "2.10.2",

    libraryDependencies ++= Seq(
      "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test",
      "com.github.sarxos" % "webcam-capture" % "0.3.9",
      "org.slf4j" % "slf4j-nop" % "1.7.2"
      // native dependencies:
      //    v4l2.so, xbacklight
      //    on archlinux this is v4l-utils and xorg-xbacklight
    )

  )

  lazy val project = Project(
    id = "SnapDim",
    base = file("."),
    settings = snapDimSettings
  )
}
