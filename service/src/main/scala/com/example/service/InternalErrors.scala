package com.example.service

sealed trait InternalErrors

object InternalErrors {

  case object ValidationError extends InternalErrors
  case object UserNotFoundError extends InternalErrors
  case object DatabaseError extends InternalErrors
}
