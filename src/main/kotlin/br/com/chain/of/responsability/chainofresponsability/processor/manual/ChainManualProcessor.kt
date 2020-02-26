package br.com.chain.of.responsability.chainofresponsability.processor.manual

abstract class ChainManualProcessor(var nextProcessor: ChainManualProcessor? = null) {

    abstract fun process(message: String, results: MutableList<String>)

}
