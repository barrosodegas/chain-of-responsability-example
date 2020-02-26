package br.com.chain.of.responsability.chainofresponsability.processor.bySpringInjection

import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Order(2)
@Component
class Link2Processor : ChainProcessor {

    override fun process(message: String, results: MutableList<String>) {

        results.add("$message Link2Processor")
    }

}
