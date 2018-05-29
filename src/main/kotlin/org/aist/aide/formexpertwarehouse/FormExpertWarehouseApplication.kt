package org.aist.aide.formexpertwarehouse

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class FormExpertWarehouseApplication

fun main(args: Array<String>) {
    runApplication<FormExpertWarehouseApplication>(*args)
}
