package com.example.service

import zio.logging.backend.SLF4J
import zio._

object Main extends ZIOAppDefault {

  override val bootstrap: ZLayer[ZIOAppArgs, Any, Any] =
    Runtime.removeDefaultLoggers >>> SLF4J.slf4j

  override def run: URIO[Any, ExitCode] =
    new ExampleService2Impl()
      .service2Operation1()
      .exitCode
}
