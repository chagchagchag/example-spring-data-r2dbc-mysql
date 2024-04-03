package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.valueobject.BookName;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;

@SpringBootTest
public class BookR2dbcOperationsSelectTest {
  private static final Logger log = LoggerFactory.getLogger(BookR2dbcOperationsSelectTest.class);

  @Autowired
  private R2dbcEntityTemplate r2dbcEntityTemplate;

  @DisplayName("SELECT_단순한_SELECT_쿼리")
  @Test
  public void TEST_SELECT_단순한_SELECT_쿼리(){
    // given

    // when

    // then
    Criteria equalsBookName = Criteria.where("name").is("글루코스 혁명");
    Criteria priceGt = Criteria.where("price").greaterThan(1000);
    Criteria whereCriteria = equalsBookName.and(priceGt);

    Query where = Query.query(whereCriteria).limit(10);

    List<BookName> selected = r2dbcEntityTemplate.select(Book.class)
        .from("book")
        .as(BookName.class)
        .matching(where)
        .all()
        .toStream()
        .collect(Collectors.toList());

    selected.forEach(bookName -> {
      log.info("book.name = " + bookName);
    });
  }
}
