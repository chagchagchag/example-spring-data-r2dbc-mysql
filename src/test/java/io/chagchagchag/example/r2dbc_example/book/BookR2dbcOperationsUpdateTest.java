package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;

@SpringBootTest
public class BookR2dbcOperationsUpdateTest {
  private static final Logger log = LoggerFactory.getLogger(BookR2dbcOperationsUpdateTest.class);

  @Autowired
  private R2dbcEntityTemplate r2dbcEntityTemplate;

  @DisplayName("간단한_UPDATE_QUERY")
  @Test
  public void TEST_간단한_UPDATE_QUERY(){
    // given

    // when

    // then
    Criteria equalsBookName = Criteria.where("name").is("맛도리여행");
    Criteria priceGt = Criteria.where("price").greaterThanOrEquals(BigDecimal.valueOf(1000));
    Criteria where = equalsBookName.and(priceGt);

    Update update = Update.update("price", BigDecimal.valueOf(10000));

    r2dbcEntityTemplate.update(Book.class)
        .inTable("book")
        .matching(Query.query(where))
        .apply(update)
        .doOnNext(affected -> log.info("affected row count = {}", affected))
        .block();
  }

}
