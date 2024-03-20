In Spring Boot, you can implement API versioning using content negotiation. Content negotiation involves the server selecting the appropriate representation of a resource based on the client's preferences. Here's an example of how you can achieve API versioning using content negotiation:

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping(value = "/data", produces = { "application/vnd.mycompany.v1+json", "application/vnd.mycompany.v2+json" })
    public ResponseEntity<String> getData(HttpServletRequest request) {
        String acceptHeader = request.getHeader(HttpHeaders.ACCEPT);
        if (acceptHeader != null && acceptHeader.contains("v1")) {
            return ResponseEntity.ok("Version 1 data");
        } else if (acceptHeader != null && acceptHeader.contains("v2")) {
            return ResponseEntity.ok("Version 2 data");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Unsupported API version");
        }
    }
}

In this example:

We have a controller class ApiController with a method getData mapped to the /api/data endpoint.
The produces attribute of the @GetMapping annotation specifies the supported media types for this endpoint. Each media type corresponds to a different version of the API.
Inside the method, we retrieve the Accept header from the request to determine the client's preferred version.
Based on the version requested by the client, the appropriate response is returned. If the requested version is not supported, a 406 Not Acceptable status code is returned.
Clients can specify the desired version in the Accept header when making requests to this endpoint. For example:

To request version 1: Accept: application/vnd.mycompany.v1+json
To request version 2: Accept: application/vnd.mycompany.v2+json
