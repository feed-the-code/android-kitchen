package com.codefood.arch

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtendWith
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

@ExtendWith(InstantExecutorExtension::class)
object StateControllerSpec : Spek({
    describe("State Controller of Any type") {
        val controller by memoized { StateController<Any>() }

        describe("initial state") {
            it("status should be loading") {
                assertEquals(controller.status, Status.LOADING)
            }
            it("data should be null") {
                assertEquals(controller.data, null)
            }
            it("error should be null") {
                assertEquals(controller.error, null)
            }
        }

        describe("observations") {
            it("should observe success") {
                val liveData by controller
                controller.success(true)
                assertEquals(liveData.value?.status, Status.SUCCESS)
            }
        }
    }
})