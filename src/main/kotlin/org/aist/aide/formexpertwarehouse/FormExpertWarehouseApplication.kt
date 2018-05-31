package org.aist.aide.formexpertwarehouse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
class FormExpertWarehouseApplication

fun main(args: Array<String>) {
    runApplication<FormExpertWarehouseApplication>(*args)
}
