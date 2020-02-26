package br.com.chain.of.responsability.chainofresponsability.processor.bySpringInjection

interface ChainProcessor {

    fun process(message: String, results: MutableList<String>)

}
