package org.aist.aide.formexpertwarehouse.domain.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.util.*

@JsonIgnoreProperties(value = *arrayOf("createdAt", "updatedAt"), allowGetters = true)
abstract class AuditModel : Serializable {
    @CreatedDate
    var createdAt: Date? = null

    @LastModifiedDate
    var updatedAt: Date? = null
}