package io.chagchagchag.example.r2dbc_example.service;

import io.chagchagchag.example.r2dbc_example.repository.BookSaveRepository;
import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class BookService {
  private BookSaveRepository bookSaveRepository;
  public Flux<Book> insertNewBook(String name, BigDecimal price, Long authorId){
    return null;
  }
}
