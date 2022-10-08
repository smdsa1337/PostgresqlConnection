package com.smdsa.PostgresqlConnection

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PostgresqlConnectionApplication

fun main(args: Array<String>) {
	runApplication<PostgresqlConnectionApplication>(*args)
}