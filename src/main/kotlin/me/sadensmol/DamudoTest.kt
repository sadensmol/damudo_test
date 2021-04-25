package me.sadensmol
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import javax.annotation.PostConstruct

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories("me.sadensmol")
class DamudoTest

fun main(args: Array<String>) {
    runApplication<DamudoTest>(*args)

}

