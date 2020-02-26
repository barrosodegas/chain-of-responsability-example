package br.com.chain.of.responsability.chainofresponsability.processor.manual

class ChainManual2Processor(nextProcessor: ChainManualProcessor? = null) : ChainManualProcessor(nextProcessor) {

    override fun process(message: String, results: MutableList<String>) {

        results.add("$message ChainManual2Processor")

        nextProcessor?.process(message, results)
    }

}
