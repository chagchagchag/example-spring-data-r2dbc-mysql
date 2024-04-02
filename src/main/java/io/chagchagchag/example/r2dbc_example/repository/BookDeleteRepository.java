package io.chagchagchag.example.r2dbc_example.repository;

import java.math.BigDecimal;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface BookDeleteRepository extends ReactiveCrudRepository<Book, Long> {
  Mono<Long> deleteBySaleStatusAndPriceGreaterThan(SaleStatus saleStatus, BigDecimal price);
  Mono<Long> deleteBySaleStatus(SaleStatus saleStatus);
}
