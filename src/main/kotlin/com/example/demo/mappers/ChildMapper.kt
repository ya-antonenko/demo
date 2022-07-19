package com.example.demo.mappers

import com.example.demo.dto.Child
import com.example.demo.entities.ChildEntity
import org.springframework.stereotype.Component

@Component
class ChildMapper {

    fun mapChildEntitiesToChildDTOs(childEntities: MutableList<ChildEntity>): MutableSet<Child> {
        return childEntities.map { mapChildEntityToChildDTO(it) }
            .toCollection(mutableSetOf())
    }

    fun mapChildEntityToChildDTO(childEntity: ChildEntity): Child {
        return Child(
            firstName = childEntity.firstName,
            lastName = childEntity.lastName,
            age = childEntity.age,
            weight = childEntity.weight,
            height = childEntity.height
        )
    }
}