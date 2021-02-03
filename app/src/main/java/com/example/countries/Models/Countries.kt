package com.example.countries

data class Example(
    val name:String,

    val capital:String,

    val population:Int,

    val borders:List<String>,

    val languages:List<com.example.countries.Models.Language>,

    val region:String,

    val subregion:String,

    val flag:String
)
