package com.example.demo.repositories

import com.example.demo.entities.PersonEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class PersonRepository {

    fun findById(id: UUID): PersonEntity {
        return createPersonEntity(id)
    }

    fun findAll(): List<PersonEntity> {
        return createAllPersonEntities()
    }

    private fun createPersonEntity(id: UUID): PersonEntity {
        return PersonEntity(
            id = id,
            firstName = "Johnny",
            lastName = "Depp",
            age = 59,
            sex = "male"
        )
    }

    private fun createAllPersonEntities(): List<PersonEntity> {
        val personEntity1 = createPersonEntity(UUID.randomUUID())
        val personEntity2 = PersonEntity(
            id = UUID.randomUUID(),
            firstName = "Angelina",
            lastName = "Jolie",
            age = 47,
            sex = "female"
        )
        return listOf(personEntity1, personEntity2)
    }
}