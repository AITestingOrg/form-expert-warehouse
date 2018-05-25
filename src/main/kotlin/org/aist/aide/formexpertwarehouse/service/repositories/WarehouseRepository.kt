package org.aist.aide.formexpertwarehouse.service.repositories

import org.aist.aide.formexpertwarehouse.domain.models.Instance
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseRepository : MongoRepository<Instance, String>