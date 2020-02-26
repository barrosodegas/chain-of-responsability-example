package br.com.chain.of.responsability.chainofresponsability.processor.bySpringInjection

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
class ChainProcessorIT extends Specification {

    @Autowired
    List<ChainProcessor> chainProcessors

    def "should load the processors"() {
        given:
            def message = "Test"
        when:
            chainProcessors.first().process(message, [])
        then:
            chainProcessors.size() == 3
            chainProcessors.first() instanceof Link1Processor
            chainProcessors.get(1) instanceof Link2Processor
            chainProcessors.last() instanceof Link3Processor
    }

    def "should process the messages and populate the result list"() {
        given:
            def message = "Test"
            def results = []
        when:
            chainProcessors.first().process(message, results)
            chainProcessors.get(1).process(message, results)
            chainProcessors.last().process(message, results)
        then:
            results.first() == "Test Link1Processor"
            results.get(1) == "Test Link2Processor"
            results.last() == "Test Link3Processor"
    }

}
