package com.example.demo.mappers

import com.example.demo.dto.Child
import com.example.demo.dto.Person
import com.example.demo.entities.ChildEntity
import com.example.demo.entities.PersonEntity
import com.example.demo.utils.TestUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PersonMapperTest {
    private val personMapper: PersonMapper = PersonMapper(ChildMapper())

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
        personDTO.getChild().forEach { testChildData(it) }
    }

    private fun testChildData(childDTO: Child) {
        assertEquals("child firstName", childDTO.firstName)
        assertEquals("child lastName", childDTO.lastName)
        assertEquals(2, childDTO.age)
        assertEquals(15, childDTO.weight)
        assertEquals(50, childDTO.height)
    }

    private fun createPersonEntity(): PersonEntity {
        val personEntity = PersonEntity("firstName", "lastName", 10, "male")
        personEntity.id = TestUtils.generateLongId()
        personEntity.addChild { createChildEntity(personEntity) }
        return personEntity
    }

    private fun createChildEntity(personEntity: PersonEntity): ChildEntity {
        val childEntity = ChildEntity("child firstName", "child lastName", 2, 15, 50, personEntity)
        childEntity.id = TestUtils.generateLongId()
        return childEntity
    }
}