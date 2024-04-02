package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.BookFindRepository;
import io.chagchagchag.example.r2dbc_example.repository.valueobject.BookName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookFindRepositoryExampleTest {
  private Logger log = LoggerFactory.getLogger(BookFindRepositoryExampleTest.class);

  @Autowired
  private BookFindRepository bookFindRepository;

  @DisplayName("QUERY_METHOD__가격이_가장_높은_책을_조회")
  @Test
  public void TEST_QUERY_METHOD__가격이_가장_높은_책을_조회(){
    // given

    // when

    // then
    Book book = bookFindRepository
        .findFirstByNameOrderByPriceDesc("바람과 함께 사라지다")
        .block();

    log.info("book.name = {}", book.getName());
    log.info("book.name = {}", book.getPrice());
    log.info("book.name = {}", book.getSaleStatus());
  }

  @DisplayName("QUERY_METHOD__가장_최근에_출간된_책의_이름을_조회")
  @Test
  public void TEST_QUERY_METHOD__가장_최근에_출간된_책의_이름을_조회(){
    // given

    // when

    // then
    BookName book = bookFindRepository
        .findFirstByNameOrderByPublishedAtDesc("바람과 함께 사라지다")
        .block();

    log.info("book.name = {}", book.name());
  }


}
