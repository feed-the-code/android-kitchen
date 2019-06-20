package com.codefood.util.validation

class TestForm : Form {
    val unrelated = "hihihi"
    val field1: Field<String> =
        Field(emptyList(), value = "test1")
    val field2: Field<String> =
        Field(
            listOf(Rule { input -> "not equal".takeIf { input != field1.value } }),
            "test2"
        )
}