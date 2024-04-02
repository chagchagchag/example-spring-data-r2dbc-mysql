package io.chagchagchag.example.r2dbc_example.repository;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookSaveRepository extends ReactiveCrudRepository<Book, Long> {
}
