package com.example.demo.repositories

import com.example.demo.entities.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonRepository : JpaRepository<PersonEntity, Long> {
    override fun findById(id: Long): Optional<PersonEntity>
    override fun findAll(): List<PersonEntity>
}