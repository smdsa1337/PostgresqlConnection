package com.smdsa.PostgresqlConnection

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WordRepository : CrudRepository<WordsDataClass, Long> {}