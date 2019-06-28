package com.codefood.util.validation

import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object FormSpec : Spek({

    val form by memoized { TestForm() }


    describe("Generics") {
        it("can retrieve fieldMembers") {
            assertEquals("test1", form.fieldMembers[0].value)
            assertEquals("test2", form.fieldMembers[1].value)
        }
    }

    describe("Cross validation") {
        it("unequal input") {
            form.field2.input("something")
            assertEquals("not equal", form.field2.error)
        }
        it("equal input") {
            form.field2.input("test1")
            assertEquals(null, form.field2.error)
        }
    }

    describe("Validate Form") {
        it("initial invalid") {
            assertEquals(false, form.isValid)
        }
        it("turns field dirty") {
            form.validate()
            assertEquals(true, form.field1.isDirty)
            assertEquals(true, form.field2.isDirty)
        }
        it("valid after input") {
            form.field1.input("test1")
            form.field2.input("test1")
            assertEquals(true, form.isValid)
        }
    }
})
