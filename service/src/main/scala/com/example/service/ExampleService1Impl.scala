package com.example.service

import com.example.service.smithy.ExampleService1
import zio._

class ExampleService1Impl extends ExampleService1[Task] with ErrorHandler{

  override def service1Operation1(): Task[Unit] =
    convertInternalErrorToSmithyError(ZIO.succeed())

  override def service1Operation2(): Task[Unit] =
    convertInternalErrorToSmithyError(ZIO.succeed())
}
