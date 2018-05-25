package org.aist.aide.formexpertwarehouse.domain.models

import org.springframework.data.annotation.Id

data class Instance(@Id val id: String, val label: String, val fields: List<Field>) : AuditModel()