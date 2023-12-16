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

trait ExampleService2Gen[F[_, _, _, _, _]] {
  self =>

  def service2Operation1(): F[Unit, ExampleService2Operation.Service2Operation1Error, Unit, Nothing, Nothing]
  def service2Operation2(): F[Unit, ExampleService2Operation.Service2Operation2Error, Unit, Nothing, Nothing]

  def transform: Transformation.PartiallyApplied[ExampleService2Gen[F]] = Transformation.of[ExampleService2Gen[F]](this)
}

object ExampleService2Gen extends Service.Mixin[ExampleService2Gen, ExampleService2Operation] {

  val id: ShapeId = ShapeId("com.example.service.smithy", "ExampleService2")
  val version: String = "1.0.0"

  val hints: Hints = Hints(
    alloy.SimpleRestJson(),
  )

  def apply[F[_]](implicit F: Impl[F]): F.type = F

  object ErrorAware {
    def apply[F[_, _]](implicit F: ErrorAware[F]): F.type = F
    type Default[F[+_, +_]] = Constant[smithy4s.kinds.stubs.Kind2[F]#toKind5]
  }

  val endpoints: List[smithy4s.Endpoint[ExampleService2Operation, _, _, _, _, _]] = List(
    ExampleService2Operation.Service2Operation1,
    ExampleService2Operation.Service2Operation2,
  )

  def endpoint[I, E, O, SI, SO](op: ExampleService2Operation[I, E, O, SI, SO]) = op.endpoint
  class Constant[P[-_, +_, +_, +_, +_]](value: P[Any, Nothing, Nothing, Nothing, Nothing]) extends ExampleService2Operation.Transformed[ExampleService2Operation, P](reified, const5(value))
  type Default[F[+_]] = Constant[smithy4s.kinds.stubs.Kind1[F]#toKind5]
  def reified: ExampleService2Gen[ExampleService2Operation] = ExampleService2Operation.reified
  def mapK5[P[_, _, _, _, _], P1[_, _, _, _, _]](alg: ExampleService2Gen[P], f: PolyFunction5[P, P1]): ExampleService2Gen[P1] = new ExampleService2Operation.Transformed(alg, f)
  def fromPolyFunction[P[_, _, _, _, _]](f: PolyFunction5[ExampleService2Operation, P]): ExampleService2Gen[P] = new ExampleService2Operation.Transformed(reified, f)
  def toPolyFunction[P[_, _, _, _, _]](impl: ExampleService2Gen[P]): PolyFunction5[ExampleService2Operation, P] = ExampleService2Operation.toPolyFunction(impl)

  type Service2Operation1Error = ExampleService2Operation.Service2Operation1Error
  val Service2Operation1Error = ExampleService2Operation.Service2Operation1Error
  type Service2Operation2Error = ExampleService2Operation.Service2Operation2Error
  val Service2Operation2Error = ExampleService2Operation.Service2Operation2Error
}

sealed trait ExampleService2Operation[Input, Err, Output, StreamedInput, StreamedOutput] {
  def run[F[_, _, _, _, _]](impl: ExampleService2Gen[F]): F[Input, Err, Output, StreamedInput, StreamedOutput]
  def endpoint: (Input, Endpoint[ExampleService2Operation, Input, Err, Output, StreamedInput, StreamedOutput])
}

object ExampleService2Operation {

  object reified extends ExampleService2Gen[ExampleService2Operation] {
    def service2Operation1() = Service2Operation1()
    def service2Operation2() = Service2Operation2()
  }
  class Transformed[P[_, _, _, _, _], P1[_ ,_ ,_ ,_ ,_]](alg: ExampleService2Gen[P], f: PolyFunction5[P, P1]) extends ExampleService2Gen[P1] {
    def service2Operation1() = f[Unit, ExampleService2Operation.Service2Operation1Error, Unit, Nothing, Nothing](alg.service2Operation1())
    def service2Operation2() = f[Unit, ExampleService2Operation.Service2Operation2Error, Unit, Nothing, Nothing](alg.service2Operation2())
  }

  def toPolyFunction[P[_, _, _, _, _]](impl: ExampleService2Gen[P]): PolyFunction5[ExampleService2Operation, P] = new PolyFunction5[ExampleService2Operation, P] {
    def apply[I, E, O, SI, SO](op: ExampleService2Operation[I, E, O, SI, SO]): P[I, E, O, SI, SO] = op.run(impl) 
  }
  case class Service2Operation1() extends ExampleService2Operation[Unit, ExampleService2Operation.Service2Operation1Error, Unit, Nothing, Nothing] {
    def run[F[_, _, _, _, _]](impl: ExampleService2Gen[F]): F[Unit, ExampleService2Operation.Service2Operation1Error, Unit, Nothing, Nothing] = impl.service2Operation1()
    def endpoint: (Unit, smithy4s.Endpoint[ExampleService2Operation,Unit, ExampleService2Operation.Service2Operation1Error, Unit, Nothing, Nothing]) = ((), Service2Operation1)
  }
  object Service2Operation1 extends smithy4s.Endpoint[ExampleService2Operation,Unit, ExampleService2Operation.Service2Operation1Error, Unit, Nothing, Nothing] with Errorable[Service2Operation1Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service2Operation1")
    val input: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Input.widen)
    val output: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Output.widen)
    val streamedInput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val streamedOutput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val hints: Hints = Hints(
      smithy.api.Http(method = smithy.api.NonEmptyString("POST"), uri = smithy.api.NonEmptyString("/service2/op1"), code = 204),
    )
    def wrap(input: Unit) = Service2Operation1()
    override val errorable: Option[Errorable[Service2Operation1Error]] = Some(this)
    val error: UnionSchema[Service2Operation1Error] = Service2Operation1Error.schema
    def liftError(throwable: Throwable): Option[Service2Operation1Error] = throwable match {
      case e: NotFound => Some(Service2Operation1Error.NotFoundCase(e))
      case _ => None
    }
    def unliftError(e: Service2Operation1Error): Throwable = e match {
      case Service2Operation1Error.NotFoundCase(e) => e
    }
  }
  sealed trait Service2Operation1Error extends scala.Product with scala.Serializable {
    @inline final def widen: Service2Operation1Error = this
  }
  object Service2Operation1Error extends ShapeTag.Companion[Service2Operation1Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service2Operation1Error")

    val hints: Hints = Hints.empty

    case class NotFoundCase(notFound: NotFound) extends Service2Operation1Error

    object NotFoundCase {
      val hints: Hints = Hints.empty
      val schema: Schema[NotFoundCase] = bijection(NotFound.schema.addHints(hints), NotFoundCase(_), _.notFound)
      val alt = schema.oneOf[Service2Operation1Error]("NotFound")
    }

    implicit val schema: UnionSchema[Service2Operation1Error] = union(
      NotFoundCase.alt,
    ){
      case c: NotFoundCase => NotFoundCase.alt(c)
    }
  }
  case class Service2Operation2() extends ExampleService2Operation[Unit, ExampleService2Operation.Service2Operation2Error, Unit, Nothing, Nothing] {
    def run[F[_, _, _, _, _]](impl: ExampleService2Gen[F]): F[Unit, ExampleService2Operation.Service2Operation2Error, Unit, Nothing, Nothing] = impl.service2Operation2()
    def endpoint: (Unit, smithy4s.Endpoint[ExampleService2Operation,Unit, ExampleService2Operation.Service2Operation2Error, Unit, Nothing, Nothing]) = ((), Service2Operation2)
  }
  object Service2Operation2 extends smithy4s.Endpoint[ExampleService2Operation,Unit, ExampleService2Operation.Service2Operation2Error, Unit, Nothing, Nothing] with Errorable[Service2Operation2Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service2Operation2")
    val input: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Input.widen)
    val output: Schema[Unit] = unit.addHints(smithy4s.internals.InputOutput.Output.widen)
    val streamedInput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val streamedOutput: StreamingSchema[Nothing] = StreamingSchema.nothing
    val hints: Hints = Hints(
      smithy.api.Http(method = smithy.api.NonEmptyString("POST"), uri = smithy.api.NonEmptyString("/service2/op2"), code = 204),
    )
    def wrap(input: Unit) = Service2Operation2()
    override val errorable: Option[Errorable[Service2Operation2Error]] = Some(this)
    val error: UnionSchema[Service2Operation2Error] = Service2Operation2Error.schema
    def liftError(throwable: Throwable): Option[Service2Operation2Error] = throwable match {
      case e: InternalServerError => Some(Service2Operation2Error.InternalServerErrorCase(e))
      case e: NotFound => Some(Service2Operation2Error.NotFoundCase(e))
      case _ => None
    }
    def unliftError(e: Service2Operation2Error): Throwable = e match {
      case Service2Operation2Error.InternalServerErrorCase(e) => e
      case Service2Operation2Error.NotFoundCase(e) => e
    }
  }
  sealed trait Service2Operation2Error extends scala.Product with scala.Serializable {
    @inline final def widen: Service2Operation2Error = this
  }
  object Service2Operation2Error extends ShapeTag.Companion[Service2Operation2Error] {
    val id: ShapeId = ShapeId("com.example.service.smithy", "Service2Operation2Error")

    val hints: Hints = Hints.empty

    case class InternalServerErrorCase(internalServerError: InternalServerError) extends Service2Operation2Error
    case class NotFoundCase(notFound: NotFound) extends Service2Operation2Error

    object InternalServerErrorCase {
      val hints: Hints = Hints.empty
      val schema: Schema[InternalServerErrorCase] = bijection(InternalServerError.schema.addHints(hints), InternalServerErrorCase(_), _.internalServerError)
      val alt = schema.oneOf[Service2Operation2Error]("InternalServerError")
    }
    object NotFoundCase {
      val hints: Hints = Hints.empty
      val schema: Schema[NotFoundCase] = bijection(NotFound.schema.addHints(hints), NotFoundCase(_), _.notFound)
      val alt = schema.oneOf[Service2Operation2Error]("NotFound")
    }

    implicit val schema: UnionSchema[Service2Operation2Error] = union(
      InternalServerErrorCase.alt,
      NotFoundCase.alt,
    ){
      case c: InternalServerErrorCase => InternalServerErrorCase.alt(c)
      case c: NotFoundCase => NotFoundCase.alt(c)
    }
  }
}
