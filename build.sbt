organization := "com.iservport"

scalaVersion := "2.13.8" 

javacOptions ++= Seq("-source", "11", "-target", "11")

libraryDependencies ++= Seq(
  "com.zaxxer"                         % "HikariCP"          % "5.0.1",              // connection pool
  "com.h2database"                     % "h2"                % "2.1.214",            // database
  "io.getquill"                       %% "quill-jdbc"        % "4.4.1",              // persistence layer
  "io.getquill"                       %% "quill-sql"         % "4.4.1",
  "org.apache.httpcomponents.client5"  % "httpclient5"       % "5.1.3",              // Apache commons http client
  "io.d11"                            %% "zhttp"             % "2.0.0-RC11",         // Zio http client
  "dev.zio"                           %% "zio-json"          % "0.3.0",              // Zio Json
  "ch.qos.logback"                     % "logback-classic"   % "1.4.1",              // logging
  "org.scalactic"                     %% "scalactic"         % "3.2.12"     % Test,  // test dependencies
  "org.scalatest"                     %% "scalatest"         % "3.2.13"     % Test,
  "org.scalatestplus"                 %% "mockito-4-5"       % "3.2.12.0"   % Test
)

Global / onChangedBuildSource := ReloadOnSourceChanges
