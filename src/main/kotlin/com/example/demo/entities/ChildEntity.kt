package com.example.demo.entities

import javax.persistence.*

@Entity
@Table(name = "child")
class ChildEntity(
    @Column(name = "first_name", nullable = false)
    val firstName: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "age")
    var age: Int? = null,
    @Column(name = "weight")
    var weight: Int? = null,
    @Column(name = "height")
    var height: Int? = null,
    @ManyToOne
    @JoinColumn(name = "person_id")
    val person: PersonEntity
) : BaseAuditEntity<Long>() {
}