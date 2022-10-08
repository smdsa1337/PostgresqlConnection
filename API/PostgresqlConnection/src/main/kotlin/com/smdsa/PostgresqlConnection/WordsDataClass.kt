package com.smdsa.PostgresqlConnection

import javax.persistence.*

@Entity
@Table(name = "table_of_words")
data class WordsDataClass(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long, val word: String)