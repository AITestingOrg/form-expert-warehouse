package org.aist.aide.formexpertwarehouse.domain.models

data class Instance(val label: String, val fields: List<Field>) : AuditModel()