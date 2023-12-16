package com.example.service

import com.example.service.smithy.ExampleService2
import zio._

class ExampleService2Impl extends ExampleService2[Task] with ErrorHandler {

  override def service2Operation1(): Task[Unit] =
    convertInternalErrorToSmithyError(ZIO.succeed())

  override def service2Operation2(): Task[Unit] =
    convertInternalErrorToSmithyError(ZIO.succeed())
}
