package com.example.demo.controllers

import com.example.demo.dto.Person
import com.example.demo.services.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/persons")
class PersonController(private val personService: PersonService) {

    @GetMapping("/{id}")
    fun getPerson(@PathVariable id: UUID): Person {
        return personService.getPerson(id)
    }

    @GetMapping
    fun getAllPersons(): List<Person> {
        return personService.getAllPersons()
    }

}