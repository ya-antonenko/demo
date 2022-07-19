package com.example.demo.mappers

import com.example.demo.dto.Person
import com.example.demo.entities.PersonEntity
import org.springframework.stereotype.Component

@Component
class PersonMapper(private val childMapper: ChildMapper) {

    fun mapPersonEntitiesToPersons(personEntities: List<PersonEntity>): List<Person> {
        return personEntities.map { mapPersonEntityToPerson(it) }
            .toCollection(mutableListOf())
    }

    fun mapPersonEntityToPerson(personEntity: PersonEntity): Person {
        val person = Person(
            firstName = personEntity.firstName,
            lastName = personEntity.lastName,
            age = personEntity.age,
            sex = personEntity.sex
        )
        person.setChild { childMapper.mapChildEntitiesToChildDTOs(personEntity.child) }
        return person
    }
}