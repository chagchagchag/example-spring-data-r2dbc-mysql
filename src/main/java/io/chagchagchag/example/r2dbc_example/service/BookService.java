package io.chagchagchag.example.r2dbc_example.service;

import static io.chagchagchag.example.r2dbc_example.repository.type.SaleStatus.FOR_SALE;

import io.chagchagchag.example.r2dbc_example.repository.BookSaveRepository;
import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.factory.BookFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Service
public class BookService {
  private final BookSaveRepository bookSaveRepository;
  private final BookFactory bookFactory;
  private final TransactionalOperator transactionalOperator;

  @Transactional
  public Flux<Book> insertNewBook(String name, BigDecimal price, Long authorId){
    Book newBook = bookFactory.newBook(name, price, LocalDateTime.now(), authorId);
    return bookSaveRepository.save(newBook)
        .flatMap(book -> {
          Book forSale = bookFactory.withSaleStatus(book, FOR_SALE);
          return bookSaveRepository.save(forSale);
        })
        .thenMany(bookSaveRepository.findAll());
  }

  public Flux<Book> insertNewBookTransactionalOperator1(String name, BigDecimal price, Long authorId){
    Book newBook = bookFactory.newBook(name, price, LocalDateTime.now(), authorId);
    Flux<Book> flux = bookSaveRepository.save(newBook)
        .flatMap(book -> {
          Book forSale = bookFactory.withSaleStatus(book, FOR_SALE);
          return bookSaveRepository.save(forSale);
        })
        .thenMany(bookSaveRepository.findAll());
    return transactionalOperator.transactional(flux);
  }

  public Flux<Book> insertNewBookTransactionalOperator2(String name, BigDecimal price, Long authorId){
    Book newBook = bookFactory.newBook(name, price, LocalDateTime.now(), authorId);
    Flux<Book> flux = bookSaveRepository.save(newBook)
        .flatMap(book -> {
          Book forSale = bookFactory.withSaleStatus(book, FOR_SALE);
          return bookSaveRepository.save(forSale);
        })
        .thenMany(bookSaveRepository.findAll());
    return transactionalOperator.execute(status -> flux);
  }

}
