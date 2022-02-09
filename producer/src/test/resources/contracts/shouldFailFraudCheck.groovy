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
			amount: regex("[0-9]{1,9}")
		)
    }

    response {
        status OK()
        headers {
			contentType applicationJson()
        }
        body (
            fraud: "false"
        )
    }
}