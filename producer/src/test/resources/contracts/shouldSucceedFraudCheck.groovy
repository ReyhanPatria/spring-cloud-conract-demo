package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method POST()
        urlPath("/fraud/check")
		headers {
			contentType(applicationJson())
		}
        body (
			amount: 1000000000
		)
    }

    response {
        status OK()
        headers {
			contentType applicationJson()
        }
        body (
            fraud: "true"
        )
    }
}