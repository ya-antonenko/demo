package com.example.demo.services

import com.example.demo.KotlinAppApplicationTests
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import javax.transaction.Transactional

@Transactional
internal class PersonServiceTest @Autowired constructor(
    private val personService: PersonService
) : KotlinAppApplicationTests() {

    @Test
    @Sql(value = ["insertPerson.sql"])
    @Sql(value = ["deletePerson.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun testGetPerson() {
        val personId1 = 1L
        val person1 = personService.getPerson(personId1)
        assertEquals("firstName1", person1?.firstName)
        assertEquals("lastName1", person1?.lastName)
        assertEquals(25, person1?.age)
        assertEquals("male", person1?.sex)

        val child1 = person1?.getChild()?.find { it.firstName == "child firstName1" }
        assertEquals("child lastName1", child1?.lastName)
        assertEquals(10, child1?.age)
        assertEquals(30, child1?.weight)
        assertEquals(150, child1?.height)

        val child2 = person1?.getChild()?.find { it.firstName == "child firstName2" }
        assertEquals("child lastName2", child2?.lastName)
        assertEquals(1, child2?.age)
        assertNull(child2?.weight)
        assertNull(child2?.height)

        val personId2 = 2L
        val person2 = personService.getPerson(personId2)
        assertEquals("firstName2", person2?.firstName)
        assertEquals("lastName2", person2?.lastName)
        assertNull(person2?.age)
        assertNull(person2?.sex)
        person2?.getChild()?.isEmpty()?.let { assertTrue(it) }
    }

    @Test
    @Sql(value = ["insertPerson.sql"])
    @Sql(value = ["deletePerson.sql"], executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    fun testGetAllPerson() {
        val persons = personService.getAllPersons()
        assertEquals(2, persons.size)
        persons.find { it.firstName == "firstName1" }
            .let { it?.getChild()?.isNotEmpty()?.let { it1 -> assertTrue(it1) } }
    }
}