package com.example.demo.services

import com.example.demo.dto.Person
import com.example.demo.entities.PersonEntity
import com.example.demo.mappers.PersonMapper
import com.example.demo.repositories.PersonRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import java.util.*

internal class PersonServiceTest {

    private val personRepository = Mockito.mock(PersonRepository::class.java)
    private val personService: PersonService = PersonService(personRepository, PersonMapper())

    @Test
    fun testGetPerson() {
        val personId = UUID.randomUUID();
        `when`(personRepository.findById(personId)).thenReturn(createPersonEntity())
        val person = personService.getPerson(personId)
        testPersonData(person)
    }

    @Test
    fun testGetAllPerson() {
        `when`(personRepository.findAll()).thenReturn(listOf(createPersonEntity(), createPersonEntity()))
        val persons = personService.getAllPersons()
        assertEquals(2, persons.size)
        persons.forEach { testPersonData(it) }
    }

    private fun testPersonData(person: Person) {
        assertEquals("firstName", person.firstName)
        assertEquals("lastName", person.lastName)
        assertEquals(20, person.age)
        assertEquals("female", person.sex)
    }

    private fun createPersonEntity(): PersonEntity {
        return PersonEntity(UUID.randomUUID(), "firstName", "lastName", 20, "female")
    }
}