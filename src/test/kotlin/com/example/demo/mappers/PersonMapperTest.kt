package com.example.demo.mappers

import com.example.demo.dto.Person
import com.example.demo.entities.PersonEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

internal class PersonMapperTest {
    private val personMapper: PersonMapper = PersonMapper()

    @Test
    fun testMapEntityToDTO() {
        val personDTO = personMapper.mapPersonEntityToPerson(createPersonEntity())
        testPersonData(personDTO)
    }

    @Test
    fun testMapEntitiesToDTOs() {
        val personEntity1 = createPersonEntity()
        val personEntity2 = createPersonEntity()
        val personDTOs = personMapper.mapPersonEntitiesToPersons(listOf(personEntity1, personEntity2))
        assertEquals(2, personDTOs.size)
        personDTOs.forEach { testPersonData(it) }
    }

    private fun testPersonData(personDTO: Person) {
        assertEquals("firstName", personDTO.firstName)
        assertEquals("lastName", personDTO.lastName)
        assertEquals(10, personDTO.age)
        assertEquals("male", personDTO.sex)
    }

    private fun createPersonEntity(): PersonEntity {
        return PersonEntity(UUID.randomUUID(), "firstName", "lastName", 10, "male")
    }
}