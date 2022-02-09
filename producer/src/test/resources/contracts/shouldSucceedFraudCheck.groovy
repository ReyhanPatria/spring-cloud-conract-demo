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
			amount: regex("[1-9][0-9]{9,}")
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