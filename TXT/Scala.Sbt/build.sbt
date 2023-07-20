import BuildHelper._

val boosterVersion = "2.0.6"

lazy val zioDynamodb = module("zio-dynamodb", "dynamodb")
  .settings(
    libraryDependencies ++= Seq(
      "com.intoverflow.booster" %% "booster-core" % boosterVersion,
      "com.intoverflow.booster" %% "booster-system" % boosterVersion % "it,test",
      "software.amazon.awssdk" % "dynamodb" % "2.16.20",
    ))
  .dependsOn(zioDynamodb)