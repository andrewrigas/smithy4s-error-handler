$version: "2.0"

namespace com.example.service.smithy

use alloy#simpleRestJson

@simpleRestJson
service ExampleService2 {
    version: "1.0.0"
    operations: [Service2Operation1, Service2Operation2]
}

@http(method: "POST", uri: "/service2/op1", code: 204)
operation Service2Operation1 {
    errors: [NotFound]
}

@http(method: "POST", uri: "/service2/op2", code: 204)
operation Service2Operation2 {
    errors: [InternalServerError, NotFound]
}
