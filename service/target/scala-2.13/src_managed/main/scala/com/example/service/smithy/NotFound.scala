package com.example.service.smithy

import smithy4s.Hints
import smithy4s.Schema
import smithy4s.ShapeId
import smithy4s.ShapeTag
import smithy4s.schema.Schema.int
import smithy4s.schema.Schema.string
import smithy4s.schema.Schema.struct

case class NotFound(code: Int = 404, message: String = "Resource not found.") extends Throwable {
  override def getMessage(): String = message
}
object NotFound extends ShapeTag.Companion[NotFound] {
  val id: ShapeId = ShapeId("com.example.service.smithy", "NotFound")

  val hints: Hints = Hints(
    smithy.api.Error.CLIENT.widen,
    smithy.api.HttpError(404),
  )

  implicit val schema: Schema[NotFound] = struct(
    int.required[NotFound]("code", _.code).addHints(smithy.api.Default(smithy4s.Document.fromDouble(404.0d)), smithy.api.Required()),
    string.required[NotFound]("message", _.message).addHints(smithy.api.Default(smithy4s.Document.fromString("Resource not found.")), smithy.api.Required()),
  ){
    NotFound.apply
  }.withId(id).addHints(hints)
}