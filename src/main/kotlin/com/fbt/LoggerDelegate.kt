package com.fbt

import jakarta.inject.Singleton
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.slf4j.LoggerFactory

@Singleton
public class LoggerDelegate: JavaDelegate {
    override fun execute(delegateExecution: DelegateExecution) {
        log.info("Hello World: {}", delegateExecution)
        log.info("Hello Multiverse: {}", delegateExecution.getVariable("quantityrequired"))
    }

    companion object {
        private val log = LoggerFactory.getLogger(LoggerDelegate::class.java)
    }
}