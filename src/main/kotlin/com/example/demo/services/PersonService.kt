package com.example.demo.services

import com.example.demo.dto.Person
import com.example.demo.mappers.PersonMapper
import com.example.demo.repositories.PersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(
    private val personRepository: PersonRepository,
    private val personMapper: PersonMapper
) {

    fun getPerson(id: UUID): Person {
        val personEntity = personRepository.findById(id)
        return personMapper.mapPersonEntityToPerson(personEntity)
    }

    fun getAllPersons(): List<Person> {
        val personEntities = personRepository.findAll()
        return personMapper.mapPersonEntitiesToPersons(personEntities)
    }

}