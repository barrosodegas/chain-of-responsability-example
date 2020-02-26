package br.com.chain.of.responsability.chainofresponsability.processor.manual

import org.springframework.stereotype.Component

@Component
class ProcessorFactory {

    fun createChainManualWithProcessors1() : ChainManualProcessor {

        return ChainManual1Processor()
    }

    fun createChainManualWithProcessors1And2() : ChainManualProcessor {

        return ChainManual1Processor(
                nextProcessor = ChainManual2Processor()
        )
    }

    fun createChainManualWithProcessors12And3() : ChainManualProcessor {

        return ChainManual1Processor(
                nextProcessor = ChainManual2Processor(
                        nextProcessor = ChainManual3Processor()
                )
        )
    }

}
