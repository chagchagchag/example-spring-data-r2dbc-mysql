package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.BookAuthor;
import io.chagchagchag.example.r2dbc_example.repository.BookQueryRepository;
import io.chagchagchag.example.r2dbc_example.repository.SaleStatus;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookQueryRepositoryExampleTest {
  private final static Logger log = LoggerFactory.getLogger(BookQueryRepositoryExampleTest.class);

  @Autowired
  private BookQueryRepository bookQueryRepository;

  @DisplayName("QUERY_METHOD__FOR_SALE_상태의_책을_조회")
  @Test
  public void TEST_QUERY_METHOD__FOR_SALE_상태의_책을_조회(){
    // given

    // when

    // then
    List<BookAuthor> bookAuthors = bookQueryRepository
        .findBookBySaleStatusQuery(SaleStatus.FOR_SALE)
        .toStream()
        .collect(Collectors.toList());

    bookAuthors.forEach(bookAuthor -> {
      log.info("bookAuthor = "+ bookAuthor);
    });
  }


}
