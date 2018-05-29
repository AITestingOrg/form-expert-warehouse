package org.aist.aide.formexpertwarehouse.domain.models

import org.aist.aide.formexpert.common.models.Form
import org.springframework.data.annotation.Id

data class Instance(@Id val id: String, val label: String, val form: Form) : AuditModel()