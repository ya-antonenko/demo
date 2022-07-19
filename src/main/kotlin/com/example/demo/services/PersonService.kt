package com.example.demo.services

import com.example.demo.dto.Person
import com.example.demo.mappers.PersonMapper
import com.example.demo.repositories.PersonRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class PersonService(
    private val personRepository: PersonRepository,
    private val personMapper: PersonMapper
) {

    fun getPerson(id: Long): Person? {
        val personEntity = personRepository.findById(id)
        return if (personEntity.isPresent) personMapper.mapPersonEntityToPerson(personEntity.get()) else null
    }

    fun getAllPersons(): List<Person> {
        val personEntities = personRepository.findAll()
        return personMapper.mapPersonEntitiesToPersons(personEntities)
    }

}