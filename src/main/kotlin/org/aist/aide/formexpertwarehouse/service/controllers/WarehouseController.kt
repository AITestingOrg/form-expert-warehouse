package org.aist.aide.formexpertwarehouse.service.controllers

import org.aist.aide.formexpertwarehouse.domain.models.Instance
import org.aist.aide.formexpertwarehouse.service.repositories.WarehouseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/warehouse")
class WarehouseController @Autowired constructor(private val warehouseRepository: WarehouseRepository) {
    @GetMapping("/page/{pageNum}/page-size/{pageSize}")
    fun getAll(@PathVariable pageNum: Int, @PathVariable pageSize: Int) : List<Instance> {
        return warehouseRepository.findAll(PageRequest.of(pageNum, pageSize)).content
    }
}
