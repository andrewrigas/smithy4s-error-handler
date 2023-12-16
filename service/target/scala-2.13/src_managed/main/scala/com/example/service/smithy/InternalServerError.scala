package com.example.service.smithy

import smithy4s.Hints
import smithy4s.Schema
import smithy4s.ShapeId
import smithy4s.ShapeTag
import smithy4s.schema.Schema.int
import smithy4s.schema.Schema.string
import smithy4s.schema.Schema.struct

case class InternalServerError(code: Int = 500, message: String = "Internal server error.") extends Throwable {
  override def getMessage(): String = message
}
object InternalServerError extends ShapeTag.Companion[InternalServerError] {
  val id: ShapeId = ShapeId("com.example.service.smithy", "InternalServerError")

  val hints: Hints = Hints(
    smithy.api.Error.SERVER.widen,
    smithy.api.HttpError(500),
  )

  implicit val schema: Schema[InternalServerError] = struct(
    int.required[InternalServerError]("code", _.code).addHints(smithy.api.Default(smithy4s.Document.fromDouble(500.0d)), smithy.api.Required()),
    string.required[InternalServerError]("message", _.message).addHints(smithy.api.Default(smithy4s.Document.fromString("Internal server error.")), smithy.api.Required()),
  ){
    InternalServerError.apply
  }.withId(id).addHints(hints)
}