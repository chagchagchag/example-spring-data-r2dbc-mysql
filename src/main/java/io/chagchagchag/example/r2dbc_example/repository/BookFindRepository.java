package io.chagchagchag.example.r2dbc_example.repository;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.valueobject.BookName;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface BookFindRepository extends ReactiveSortingRepository<Book, Long> {
  Mono<Book> findFirstByNameOrderByPriceDesc(String name);
  Mono<BookName> findFirstByNameOrderByPublishedAtDesc(String name);
}
