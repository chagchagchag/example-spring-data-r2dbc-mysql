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

@SpringBootTest
public class BookR2dbcOperationsDeleteTest {
  private static final Logger log = LoggerFactory.getLogger(BookR2dbcOperationsDeleteTest.class);
  
  @Autowired
  private R2dbcEntityTemplate r2dbcEntityTemplate;
  
  @DisplayName("간단한_DELETE_QUERY")
  @Test
  public void TEST_간단한_DELETE_QUERY(){
    // given

    // when
    
    // then
    Criteria equalsBookName = Criteria.where("name").is("맛도리여행");
    Criteria priceGt = Criteria.where("price").greaterThanOrEquals(BigDecimal.valueOf(1000));
    Criteria where = equalsBookName.and(priceGt);

    r2dbcEntityTemplate.delete(Book.class)
        .from("book")
        .matching(Query.query(where))
        .all()
        .doOnNext(affected -> log.info("deleted row count = {}", affected))
        .block();
  }
  
}
