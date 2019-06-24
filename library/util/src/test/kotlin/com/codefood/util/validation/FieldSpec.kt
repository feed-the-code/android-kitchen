package com.codefood.util.validation

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object FieldSpec : Spek({

    val field by memoized {
        Field.optional<String> {
            value = ""
            rules {
                +Rule<String?> { input -> "empty".takeIf { input.isNullOrEmpty() } }
            }
        }
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

    describe("Builder") {
        describe("Required builder") {
            val requiredField by memoized {
                Field.required<String> {
                    message = REQUIRED_MESSAGE
                    alsoNull = ""
                    rules {
                        +Rule<String> { input -> "length".takeIf { input.length < 3 } }
                    }
                }
            }

            it("empty") {
                requiredField.input("")
                assertEquals(REQUIRED_MESSAGE, requiredField.error)
            }

            it("checks non empty") {
                requiredField.input("a")
                assertEquals("length", requiredField.error)
            }

            it("valid input") {
                requiredField.input("abc")
                assertEquals(null, requiredField.error)
            }
        }
    }
})

const val REQUIRED_MESSAGE = "Required"