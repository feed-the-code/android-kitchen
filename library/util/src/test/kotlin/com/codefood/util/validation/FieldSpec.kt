package com.codefood.util.validation

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object FieldSpec : Spek({

    val field by memoized {
        Field(
            value = "",
            rules = listOf(Rule { input -> "empty".takeIf { input.isNullOrEmpty() } })
        )
    }

    describe("Initial State") {
        it("is not dirty") {
            assertEquals(false, field.isDirty)
        }
        it("can set initial input") {
            assertEquals("", field.value)
        }
        it("has no error") {
            assertEquals(null, field.error)
        }
        it("has rule") {
            assertEquals("empty", field.rules.first().validate(""))
        }
    }

    describe("Validation") {
        it("is dirty after input") {
            field.input("something")
            assertEquals(true, field.isDirty)
        }
        it("takes valid input") {
            field.input("something")
            assertEquals(null, field.error)
        }
        it("takes invalid input") {
            field.input("")
            assertEquals("empty", field.error)
        }
    }
})