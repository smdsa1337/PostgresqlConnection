package com.smdsa.PostgresqlConnection

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/")
@RestController
class WordsController(val repository: WordRepository) {

    @GetMapping
    fun getAllWords() = repository.findAll()

    @GetMapping("/{id}")
    private fun getWord(@PathVariable id: Long) = repository.findById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveWord(@RequestBody word: WordsDataClass) = repository.save(word)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteWord(@PathVariable id: Long) = repository.deleteById(id)
}