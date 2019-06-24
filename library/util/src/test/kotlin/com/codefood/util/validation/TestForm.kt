package com.codefood.util.validation

class TestForm : Form {
    val unrelated = "hihihi"
    val field1: Field<String?> =
        Field.optional { value = "test1" }
    val field2: Field<String?> =
        Field.optional {
            rules {
                +Rule<String?> { input -> "not equal".takeIf { input != field1.value } }
            }
            value = "test2"
        }
}