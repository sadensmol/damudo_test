package me.sadensmol.service

import io.mockk.*
import io.mockk.InternalPlatformDsl.toArray
import me.sadensmol.model.AppServer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DbUpdaterITest(
    @Autowired private val dbUpdater: DbUpdater,
    @Autowired private val mongoTemplate: MongoTemplate,
) {

    @Test
    fun `when update db then number of heart beats increased`(){

        val collection = mongoTemplate.findAll(AppServer::class.java)
        assertEquals(1, collection.size)
        dbUpdater.updateDb();

        val collection2 = mongoTemplate.findAll(AppServer::class.java)
        assertEquals(1, collection2.size)

        assertEquals(collection[0].lastHearbeat+1,collection2[0].lastHearbeat)
    }

}