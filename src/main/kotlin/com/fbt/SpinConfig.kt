package com.fbt

import io.micronaut.context.annotation.Factory
import io.micronaut.core.annotation.Order
import jakarta.inject.Singleton
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin

@Factory
class SpinConfig {
@Singleton
fun spin(): ProcessEnginePlugin {
return SpinProcessEnginePlugin()
}
}