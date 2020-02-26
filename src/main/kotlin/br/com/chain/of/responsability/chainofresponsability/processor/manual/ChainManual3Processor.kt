package br.com.chain.of.responsability.chainofresponsability.processor.manual

class ChainManual3Processor(nextProcessor: ChainManualProcessor? = null) : ChainManualProcessor(nextProcessor) {

    override fun process(message: String, results: MutableList<String>) {

        results.add("$message ChainManual3Processor")

        nextProcessor?.process(message, results)
    }

}
