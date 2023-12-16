$version: "2.0"

namespace com.example.service.smithy

use alloy#simpleRestJson

@simpleRestJson
service ExampleService1 {
    version: "1.0.0"
    operations: [Service1Operation1, Service1Operation2]
}

@http(method: "POST", uri: "/service1/op1", code: 204)
operation Service1Operation1 {
    errors: [NotFound]
}

@http(method: "POST", uri: "/service1/op2", code: 204)
operation Service1Operation2 {
    errors: [InternalServerError, NotFound]
}
