package br.com.chain.of.responsability.chainofresponsability.processor.bySpringInjection

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(1)
@Component
class Link1Processor : ChainProcessor {

    override fun process(message: String, results: MutableList<String>) {

        results.add("$message Link1Processor")
    }

}
