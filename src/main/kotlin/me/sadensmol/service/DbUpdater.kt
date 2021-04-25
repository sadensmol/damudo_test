package me.sadensmol.service

import me.sadensmol.model.AppServer
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class DbUpdater(
    private val mongoTemplate: MongoTemplate,
    @Value("\${instanceId}") private val instanceId:String,
) {

    @Scheduled(fixedDelayString = "\${heartBeatInSec}000")
    fun updateDb() {
        mongoTemplate.findAndModify(
            Query(Criteria.where("instanceId").`is`(instanceId)),
            Update().inc("lastHearbeat", 1),
            FindAndModifyOptions.options().returnNew(true).upsert(true),
            AppServer::class.java
        )
    }
}