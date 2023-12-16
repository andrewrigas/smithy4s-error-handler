package com.example.service

package object smithy {
  type ExampleService1[F[_]] = smithy4s.kinds.FunctorAlgebra[ExampleService1Gen, F]
  val ExampleService1 = ExampleService1Gen
  type ExampleService2[F[_]] = smithy4s.kinds.FunctorAlgebra[ExampleService2Gen, F]
  val ExampleService2 = ExampleService2Gen


}