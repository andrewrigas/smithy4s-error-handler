package com.example.service.smithy

import smithy4s.Endpoint
import smithy4s.Errorable
import smithy4s.Hints
import smithy4s.Schema
import smithy4s.Service
import smithy4s.ShapeId
import smithy4s.ShapeTag
import smithy4s.StreamingSchema
import smithy4s.Transformation
import smithy4s.kinds.PolyFunction5
import smithy4s.kinds.toPolyFunction5.const5
import smithy4s.schema.Schema.UnionSchema
import smithy4s.schema.Schema.bijection
import smithy4s.schema.Schema.union
import smithy4s.schema.Schema.unit

trait ExampleService1Gen[F[_, _, _, _, _]] {
  self =>

  def service1Operation1(): F[Unit, ExampleService1Operation.Service1Operation1Error, Unit, Nothing, Nothing]
  def service1Operation2(): F[Unit, ExampleService1Operation.Service1Operation2Error, Unit, Nothing, Nothing]

  def transform: Transformation.PartiallyApplied[ExampleService1Gen[F]] = Transformation.of[ExampleService1Gen[F]](this)
}

object ExampleService1Gen extends Service.Mixin[ExampleService1Gen, ExampleService1Operation] {

  val id: ShapeId = ShapeId("com.example.service.smithy", "ExampleService1")
  val version: String = "1.0.0"

  val hints: Hints = Hints(
    alloy.SimpleRestJson(),
  )

  def apply[F[_]](implicit F: Impl[F]): F.type = F

  object ErrorAware {
    def apply[F[_, _]](implicit F: ErrorAware[F]): F.type = F
    type Default[F[+_, +_]] = Constant[smithy4s.kinds.stubs.Kind2[F]#toKind5]
  }

  val endpoints: List[smithy4s.Endpoint[ExampleService1Operation, _, _, _, _, _]] = List(
    ExampleService1Operation.Service1Operation1,
    ExampleService1Operation.Service1Operation2,
  )

  def endpoint[I, E, O, SI, SO](op: ExampleService1Operation[I, E, O, SI, SO]) = op.endpoint
  class Constant[P[-_, +_, +_, +_, +_]](value: P[Any, Nothing, Nothing, Nothing, Nothing]) extends ExampleService1Operation.Transformed[ExampleService1Operation, P](reified, const5(value))
  type Default[F[+_]] = Constant[smithy4s.kinds.stubs.Kind1[F]#toKind5]
  def reified: ExampleService1Gen[ExampleService1Operation] = ExampleService1Operation.reified
  def mapK5[P[_, _, _, _, _], P1[_, _, _, _, _]](alg: ExampleService1Gen[P], f: PolyFunction5[P, P1]): ExampleService1Gen[P1] = new ExampleService1Operation.Transformed(alg, f)
  def fromPolyFunction[P[_, _, _, _, _]](f: PolyFunction5[ExampleService1Operation, P]): ExampleService1Gen[P] = new ExampleService1Operation.Transformed(reified, f)
  def toPolyFunction[P[_, _, _, _, _]](impl: ExampleService1Gen[P]): PolyFunction5[ExampleService1Operation, P] = ExampleService1Operation.toPolyFunction(impl)

  type Service1Operation1Error = ExampleService1Operation.Service1Operation1Error
  val Service1Operation1Error = ExampleService1Operation.Service1Operation1Error
  type Service1Operation2Error = ExampleService1Operation.Service1Operation2Error
  val Service1Operation2Error = ExampleService1Operation.Service1Operation2Error
}

sealed trait ExampleService1Operation[Input, Err, Output, StreamedInput, StreamedOutput] {
  def run[F[_, _, _, _, _]](impl: ExampleService1Gen[F]): F[Input, Err, Output, StreamedInput, StreamedOutput]
  def endpoint: (Input, Endpoint[ExampleService1Operation, Input, Err, Output, StreamedInput, StreamedOutput])
}

object ExampleService1Operation {

  object reified extends ExampleService1Gen[ExampleService1Operation] {
    def service1Operation1() = Service1Operation1()
    def service1Operation2() = Service1Operation2()
  }
  class Transformed[P[_, _, _, _, _], P1[_ ,_ ,_ ,_ ,_]](alg: ExampleService1Gen[P], f: PolyFunction5[P, P1]) extends ExampleService1Gen[P1] {
    def service1Operation1() = f[Unit, ExampleService1Operation.Service1Operation1Error, Unit, Nothing, Nothing](alg.service1Operation1())
    def service1Operation2() = f[Unit, ExampleService1Operation.Service1Operation2Error, Unit, Nothing, Nothing](alg.service1Operation2())
  }

  def toPolyFunction[P[_, _, _, _, _]](impl: ExampleService1Gen[P]): PolyFunction5[ExampleService1Operation, P] = new PolyFunction5[ExampleService1Operation, P] {
    def apply[I, E, O, SI, SO](op: ExampleService1Operation[I, E, O, SI, SO]): P[I, E, O, SI, SO] = op.run(impl) 
  }
  case class Service1Operation1() extends ExampleService1Operation[Unit, ExampleService1Operation.Service1Operation1Error, Unit, Nothing, Nothing] {
    def run[F[_, _, _, _, _]](impl: ExampleService1Gen[F]): F[Unit, ExampleService1Operation.Service1Operation1Error, Unit, Nothing, Nothing] = impl.service1Operation1()
    def endpoint: (Unit, smithy4s.Endpoint[ExampleService1Operation,Unit, ExampleService1Operation.Service1Operation1Error, Unit, Nothing, Nothing]) = ((), Service1Operation1)
  }
  object Service1Operation1 extends smithy4s.Endpoint[ExampleService1Operation,Unit, ExampleService1Operation.Service1Operation1Error, Unit, Nothing, Nothing] with Errorable[Service1Operation1Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service1Operation1")
    val input: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Input.widen)
    val output: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Output.widen)
    val streamedInput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val streamedOutput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val hints: Hints = Hints(
      smithy.api.Http(method = smithy.api.NonEmptyString("POST"), uri = smithy.api.NonEmptyString("/service1/op1"), code = 204),
    )
    def wrap(input: Unit) = Service1Operation1()
    override val errorable: Option[Errorable[Service1Operation1Error]] = Some(this)
    val error: UnionSchema[Service1Operation1Error] = Service1Operation1Error.schema
    def liftError(throwable: Throwable): Option[Service1Operation1Error] = throwable match {
      case e: NotFound => Some(Service1Operation1Error.NotFoundCase(e))
      case _ => None
    }
    def unliftError(e: Service1Operation1Error): Throwable = e match {
      case Service1Operation1Error.NotFoundCase(e) => e
    }
  }
  sealed trait Service1Operation1Error extends scala.Product with scala.Serializable {
    @inline final def widen: Service1Operation1Error = this
  }
  object Service1Operation1Error extends ShapeTag.Companion[Service1Operation1Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service1Operation1Error")

    val hints: Hints = Hints.empty

    case class NotFoundCase(notFound: NotFound) extends Service1Operation1Error

    object NotFoundCase {
      val hints: Hints = Hints.empty
      val schema: Schema[NotFoundCase] = bijection(NotFound.schema.addHints(hints), NotFoundCase(_), _.notFound)
      val alt = schema.oneOf[Service1Operation1Error]("NotFound")
    }

    implicit val schema: UnionSchema[Service1Operation1Error] = union(
      NotFoundCase.alt,
    ){
      case c: NotFoundCase => NotFoundCase.alt(c)
    }
  }
  case class Service1Operation2() extends ExampleService1Operation[Unit, ExampleService1Operation.Service1Operation2Error, Unit, Nothing, Nothing] {
    def run[F[_, _, _, _, _]](impl: ExampleService1Gen[F]): F[Unit, ExampleService1Operation.Service1Operation2Error, Unit, Nothing, Nothing] = impl.service1Operation2()
    def endpoint: (Unit, smithy4s.Endpoint[ExampleService1Operation,Unit, ExampleService1Operation.Service1Operation2Error, Unit, Nothing, Nothing]) = ((), Service1Operation2)
  }
  object Service1Operation2 extends smithy4s.Endpoint[ExampleService1Operation,Unit, ExampleService1Operation.Service1Operation2Error, Unit, Nothing, Nothing] with Errorable[Service1Operation2Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service1Operation2")
    val input: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Input.widen)
    val output: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Output.widen)
    val streamedInput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val streamedOutput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val hints: Hints = Hints(
      smithy.api.Http(method = smithy.api.NonEmptyString("POST"), uri = smithy.api.NonEmptyString("/service1/op2"), code = 204),
    )
    def wrap(input: Unit) = Service1Operation2()
    override val errorable: Option[Errorable[Service1Operation2Error]] = Some(this)
    val error: UnionSchema[Service1Operation2Error] = Service1Operation2Error.schema
    def liftError(throwable: Throwable): Option[Service1Operation2Error] = throwable match {
      case e: InternalServerError => Some(Service1Operation2Error.InternalServerErrorCase(e))
      case e: NotFound => Some(Service1Operation2Error.NotFoundCase(e))
      case _ => None
    }
    def unliftError(e: Service1Operation2Error): Throwable = e match {
      case Service1Operation2Error.InternalServerErrorCase(e) => e
      case Service1Operation2Error.NotFoundCase(e) => e
    }
  }
  sealed trait Service1Operation2Error extends scala.Product with scala.Serializable {
    @inline final def widen: Service1Operation2Error = this
  }
  object Service1Operation2Error extends ShapeTag.Companion[Service1Operation2Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service1Operation2Error")

    val hints: Hints = Hints.empty

    case class InternalServerErrorCase(internalServerError: InternalServerError) extends Service1Operation2Error
    case class NotFoundCase(notFound: NotFound) extends Service1Operation2Error

    object InternalServerErrorCase {
      val hints: Hints = Hints.empty
      val schema: Schema[InternalServerErrorCase] = bijection(InternalServerError.schema.addHints(hints), InternalServerErrorCase(_), _.internalServerError)
      val alt = schema.oneOf[Service1Operation2Error]("InternalServerError")
    }
    object NotFoundCase {
      val hints: Hints = Hints.empty
      val schema: Schema[NotFoundCase] = bijection(NotFound.schema.addHints(hints), NotFoundCase(_), _.notFound)
      val alt = schema.oneOf[Service1Operation2Error]("NotFound")
    }

    implicit val schema: UnionSchema[Service1Operation2Error] = union(
      InternalServerErrorCase.alt,
      NotFoundCase.alt,
    ){
      case c: InternalServerErrorCase => InternalServerErrorCase.alt(c)
      case c: NotFoundCase => NotFoundCase.alt(c)
    }
  }
}
