package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.service.BookService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

@SpringBootTest
public class BookSaveRepositoryExampleTest {
  private final Logger log = LoggerFactory.getLogger(BookSaveRepositoryExampleTest.class);

  @Autowired
  private BookService bookService;


  @DisplayName("TRANSACTIONAL_ANNOTATION__SAVE_NEW_BOOK")
  @Test
  public void TEST_TRANSACTIONAL_ANNOTATION__SAVE_NEW_BOOK(){
    // given

    // when

    // then
    log.info("save start >>> ");
    List<Book> result = bookService
        .insertNewBook("글루코스 혁명", BigDecimal.valueOf(2000), 1L)
        .toStream()
        .collect(Collectors.toList());
    log.info("save end <<< ");


    log.info("after result >>> ");
    result.forEach(book -> {
      log.info("book.name = {}, book.price ={}, book.saleStatus = {}, book.authorId = {}",
        book.getName(), book.getPrice(), book.getSaleStatus(), book.getAuthorId()
      );
    });
  }


}
