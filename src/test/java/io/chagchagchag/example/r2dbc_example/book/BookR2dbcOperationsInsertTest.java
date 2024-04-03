package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;

@SpringBootTest
public class BookR2dbcOperationsInsertTest {
  private static final Logger log = LoggerFactory.getLogger(BookR2dbcOperationsInsertTest.class);

  @Autowired
  private R2dbcEntityTemplate r2dbcEntityTemplate;

  @DisplayName("INSERT_책_데이터_1개_insert")
  @Test
  public void TEST_INSERT_책_데이터_1개_insert(){
    // given
    
    // when
    
    // then
    Book newBook = BookFixtures.newRandomBook("글루코스 혁명", 1L);

    Book inserted = r2dbcEntityTemplate.insert(Book.class)
        .into("book")
        .using(newBook)
        .block();

    log.info("book.name = {}, book.price = {} ", inserted.getName(), inserted.getPrice());
  }
  
}
