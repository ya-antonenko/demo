package com.example.demo.entities

import javax.persistence.*

@Entity
@Table(name = "person")
class PersonEntity(
    @Column(name = "first_name", nullable = false)
    val firstName: String,
    @Column(name = "last_name", nullable = false)
    val lastName: String,
    @Column(name = "age")
    var age: Int? = null,
    @Column(name = "sex")
    val sex: String? = null,
    @OneToMany(
        mappedBy = "person",
        fetch = FetchType.LAZY,
        orphanRemoval = true,
        cascade = [CascadeType.ALL]
    )
    val child: MutableList<ChildEntity> = mutableListOf()
) : BaseAuditEntity<Long>() {

    fun addChild(block: PersonEntity.() -> ChildEntity) {
        child.add(block())
    }

    fun setChild(block: PersonEntity.() -> MutableSet<ChildEntity>) {
        child.clear()
        child.addAll(block())
    }

}