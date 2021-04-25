package me.sadensmol.service

import io.mockk.*
import me.sadensmol.model.AppServer
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update

const val INSTANCE_ID="test_instance_id"
const val LAST_HEAR_BEAT=123L
val APP_SERVER=AppServer(instanceId = INSTANCE_ID,lastHearbeat = LAST_HEAR_BEAT)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DbUpdaterTest() {

    private val mongoTemplate: MongoTemplate = mockk()

    private val dbUpdater = DbUpdater(mongoTemplate, INSTANCE_ID)
    private val classSlot = slot<Class<Any>>()

    @Test
    fun `when update db then pass proper class`(){
        every {mongoTemplate.findAndModify(any(),any(),any(),any<Class<Any>>())}  returns APP_SERVER

        dbUpdater.updateDb()

        verify (exactly = 1){
            mongoTemplate.findAndModify(any(),any(),
        any(),capture(classSlot))  }

        assertEquals(AppServer::class.java,classSlot.captured)
    }

}