package io.chagchagchag.example.r2dbc_example.book;

import io.chagchagchag.example.r2dbc_example.repository.Book;
import io.chagchagchag.example.r2dbc_example.repository.BookDeleteRepository;
import io.chagchagchag.example.r2dbc_example.repository.SaleStatus;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDeleteRepositoryExampleTest {
  private final Logger log = LoggerFactory.getLogger(BookDeleteRepositoryExampleTest.class);
  
  @Autowired
  private BookDeleteRepository bookDeleteRepository;
  
  @DisplayName("QUERY_METHOD__SALE_STATUS_가_HOLD_이면서_11000원_이상인_책을_삭제")
  @Test
  public void TEST_QUERY_METHOD__SALE_STATUS_가_HOLD_이면서_11000원_이상인_책을_삭제(){
    // given
    
    // when
    
    // then
    Long count = bookDeleteRepository
        .deleteBySaleStatusAndPriceGreaterThan(SaleStatus.HOLD, BigDecimal.valueOf(11000))
        .block();

    log.info("count = {}", count);
  }

  @DisplayName("QUERY_METHOD__SALE_STATUS_가_HOLD_인_모든_책을_삭제")
  @Test
  public void TEST_QUERY_METHOD__SALE_STATUS_가_HOLD_인_모든_책을_삭제(){
    // given

    // when
    Long count = bookDeleteRepository
        .deleteBySaleStatus(SaleStatus.HOLD)
        .block();

    // then
    log.info("count = {}", count);
  }

  
}
