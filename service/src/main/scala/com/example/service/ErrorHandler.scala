package com.example.service

import zio._

trait ErrorHandler {

  // Global generic error handler that takes an implicit trace to log the actual package path and file name the error was logged
  protected def convertInternalErrorToSmithyError[A](effect: IO[InternalErrors, A])(implicit trace: Trace): Task[A] = {
    effect.flatMapError {
      case InternalErrors.DatabaseError =>
        ZIO
          .logError("Database error")
          .map(_ => smithy.InternalServerError())
      case InternalErrors.ValidationError =>
        ZIO
          .logError("Validation error")
          .map(_ => smithy.InternalServerError())
      case InternalErrors.UserNotFoundError =>
        ZIO
          .logError("User not found error")
          .map(_ => smithy.NotFound())
    }
  }
}
