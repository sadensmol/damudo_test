package me.sadensmol.model

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.PropertySource
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Document("appserver")
data class AppServer(
    val instanceId: String,
    val lastHearbeat: Long,
    )

