$version: "2.0"

namespace com.example.service.smithy

@error("client")
@httpError(404)
structure NotFound {
    @required
    message: String = "Resource not found."
}

@error("server")
@httpError(500)
structure InternalServerError {
    @required
    message: String = "Internal server error."
}

