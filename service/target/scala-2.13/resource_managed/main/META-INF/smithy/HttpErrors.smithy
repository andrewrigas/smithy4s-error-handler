$version: "2.0"

namespace com.example.service.smithy

@error("client")
@httpError(404)
structure NotFound {
    @required
    code: Integer = 404
    @required
    message: String = "Resource not found."
}

@error("server")
@httpError(500)
structure InternalServerError {
    @required
    code: Integer = 500
    @required
    message: String = "Internal server error."
}

