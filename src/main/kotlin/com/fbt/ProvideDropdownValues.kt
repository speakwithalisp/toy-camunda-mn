package com.fbt

import camundajar.impl.com.google.gson.Gson
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.camunda.bpm.engine.variable.Variables
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats
import org.camunda.bpm.engine.variable.value.ObjectValue
import org.camunda.bpm.engine.variable.value.SerializationDataFormat
import org.camunda.spin.DataFormats
import org.camunda.spin.Spin.*
import org.camunda.spin.json.SpinJsonNode
import org.slf4j.LoggerFactory

@Singleton
class ProvideDropdownValues: JavaDelegate {
    override fun execute(delegateExecution: DelegateExecution) {
        val towers = listOf<HashMap<String, String>>(hashMapOf("value" to "A", "label" to "Tower A"), hashMapOf("value" to "B", "label" to "Tower B"))
        val towersJson = Variables.objectValue(towers).serializationDataFormat(SerializationDataFormats.JSON).create()
        delegateExecution.setVariable("towers", towersJson)
       log.info("set {}", delegateExecution.getVariableTyped<ObjectValue>("towers").valueSerialized)
    }
    companion object {
            private val log = LoggerFactory.getLogger(ProvideDropdownValues::class.java)
    }
}