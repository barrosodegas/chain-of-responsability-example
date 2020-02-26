package br.com.chain.of.responsability.chainofresponsability.processor.manual

class ChainManual1Processor(nextProcessor: ChainManualProcessor? = null) : ChainManualProcessor(nextProcessor) {

    override fun process(message: String, results: MutableList<String>) {

        results.add("$message ChainManual1Processor")

        nextProcessor?.process(message, results)
    }

}
