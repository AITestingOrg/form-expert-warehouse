package org.aist.aide.formexpertwarehouse.service.controllers

import org.aist.aide.formexpertwarehouse.domain.models.Instance
import org.aist.aide.formexpertwarehouse.service.repositories.UnlabelledRepository
import org.aist.aide.formexpertwarehouse.service.repositories.WarehouseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("/api/v1/unlabelled")
class LabellerController @Autowired constructor(
    private val unlabelledRepository: UnlabelledRepository,
    private val warehouseRepository: WarehouseRepository
) {
    @GetMapping("page/{pageNum}/page-size/{pageSize}")
    fun getAll(@PathVariable pageNum: Int, @PathVariable pageSize: Int): List<Instance> {
        return unlabelledRepository.findAll(PageRequest.of(pageNum, pageSize)).content
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): ResponseEntity<Instance> {
        var instance = unlabelledRepository.findById(id)
        if (instance.isPresent)
            return ResponseEntity(instance.get(), HttpStatus.OK)
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("")
    fun createInstance(@RequestBody instance: Instance): ResponseEntity<String> {
        unlabelledRepository.save(instance)
        return ResponseEntity(instance.id, HttpStatus.OK)
    }

    @PutMapping("")
    fun updateInstance(@RequestBody instance: Instance): ResponseEntity<String> {
        var inDb = unlabelledRepository.findById(instance.id)
        if (inDb.isPresent) {
            unlabelledRepository.save(instance)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteInstance(@RequestBody instance: Instance): ResponseEntity<String> {
        var inDb = unlabelledRepository.findById(instance.id)
        if (inDb.isPresent) {
            unlabelledRepository.delete(instance)
            return ResponseEntity(HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/{id}")
    fun labelInstance(@PathVariable id: String): ResponseEntity<String> {
        var inDb = unlabelledRepository.findById(id)
        if (!inDb.isPresent) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
        var warehouseInstance = Instance("", inDb.get().label, inDb.get().form)
        warehouseRepository.save(warehouseInstance)
        unlabelledRepository.delete(inDb.get())
        return ResponseEntity(HttpStatus.OK)
    }
}