package org.aist.aide.formexpertwarehouse.service.repositories

import org.aist.aide.formexpertwarehouse.domain.models.Instance
import org.springframework.data.mongodb.repository.MongoRepository

interface UnlabelledRepository : MongoRepository<Instance, String>