import sbt.Keys.javacOptions

lazy val commonSettings = Seq(
  organization := "com.stephenduncanjr",
  scalaVersion := "2.12.4",
  licenses += "Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"),
  bintrayPackage := "testsbtmultiprojectbintray"
)

lazy val testsbtmultiprojectbintray = (project in file("."))
  .settings(commonSettings)
  .settings(
    publishArtifact := false,
    // Replace tasks to work around https://github.com/sbt/sbt-bintray/issues/93
    bintrayRelease := (),
    bintrayEnsureBintrayPackageExists := (),
    bintrayEnsureLicenses := ()
  )
  .aggregate(`testsbtmultiprojectbintray-core`, `testsbtmultiprojectbintray-extra`)

lazy val `testsbtmultiprojectbintray-core` = (project in file("core"))
  .settings(commonSettings)

lazy val `testsbtmultiprojectbintray-extra` = (project in file("extra"))
  .settings(commonSettings)
