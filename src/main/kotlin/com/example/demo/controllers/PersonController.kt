package com.example.demo.controllers

import com.example.demo.dto.Person
import com.example.demo.services.PersonService
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class PersonController(private val personService: PersonService) {

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: Long): ResponseEntity<Person> {
        val person = personService.getPerson(id)
        return if (person != null) ResponseEntity(person, OK) else ResponseEntity(NO_CONTENT)
    }

    @GetMapping
    fun getAllPersons(): ResponseEntity<List<Person>> {
        val persons = personService.getAllPersons()
        return if (persons.isNotEmpty()) ResponseEntity(persons, OK) else ResponseEntity(NO_CONTENT)
    }

}