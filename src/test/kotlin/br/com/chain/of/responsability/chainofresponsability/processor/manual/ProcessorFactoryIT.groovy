package br.com.chain.of.responsability.chainofresponsability.processor.manual

import br.com.chain.of.responsability.chainofresponsability.LauncherApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [LauncherApplication])
@SpringBootTest(classes = [LauncherApplication])
class ProcessorFactoryIT extends Specification {

    @Autowired
    ProcessorFactory factory

    def "should create the manual processors by factory with only the processor one"() {
        given:

        when:
            def chainManualProcessor = factory.createChainManualWithProcessors1()
        then:
            chainManualProcessor
            chainManualProcessor instanceof ChainManual1Processor
            !chainManualProcessor.nextProcessor
    }

    def "should create the manual processors by factory with only the processor one and two"() {
        given:

        when:
            def chainManualProcessor = factory.createChainManualWithProcessors1And2()
        then:
            chainManualProcessor
            chainManualProcessor instanceof ChainManual1Processor
            chainManualProcessor.nextProcessor instanceof ChainManual2Processor
            !chainManualProcessor.nextProcessor.nextProcessor
    }

    def "should create the manual processors by factory with only the processor one, two and three"() {
        given:

        when:
            def chainManualProcessor = factory.createChainManualWithProcessors12And3()
        then:
            chainManualProcessor
            chainManualProcessor instanceof ChainManual1Processor
            chainManualProcessor.nextProcessor instanceof ChainManual2Processor
            chainManualProcessor.nextProcessor.nextProcessor instanceof ChainManual3Processor
            !chainManualProcessor.nextProcessor.nextProcessor.nextProcessor
    }

}
