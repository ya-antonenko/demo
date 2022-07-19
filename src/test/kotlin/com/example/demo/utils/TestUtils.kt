package com.example.demo.utils

class TestUtils {

    companion object {
        fun generateLongId(): Long {
            return (Math.random() * 100).toLong()
        }
    }
}