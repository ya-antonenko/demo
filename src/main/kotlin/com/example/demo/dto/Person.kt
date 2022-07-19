package com.example.demo.dto

data class Person(
    val firstName: String,
    val lastName: String,
    var age: Int? = null,
    var sex: String? = null
) {

    private val child: MutableList<Child> = mutableListOf()

    fun addChild(block: Person.() -> Child) {
        child.add(block())
    }

    fun setChild(block: Person.() -> MutableSet<Child>) {
        child.clear()
        child.addAll(block())
    }

    fun getChild(): MutableList<Child> {
        return child
    }
}