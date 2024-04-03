package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.factory.BookFactory;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookFixtures {
  private static final BookFactory bookFactory = new BookFactory();
  public static Book newRandomBook(String bookName, Long authorId){
    return bookFactory.newBook(bookName, BigDecimal.valueOf(13000), LocalDateTime.now(), authorId);
  }
}
