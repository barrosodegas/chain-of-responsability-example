package br.com.chain.of.responsability.chainofresponsability.processor.bySpringInjection

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(3)
@Component
class Link3Processor : ChainProcessor {

    override fun process(message: String, results: MutableList<String>) {

        results.add("$message Link3Processor")
    }

}
