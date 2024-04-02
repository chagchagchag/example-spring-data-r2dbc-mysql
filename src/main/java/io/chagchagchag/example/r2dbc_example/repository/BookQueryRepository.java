package io.chagchagchag.example.r2dbc_example.repository;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.type.SaleStatus;
import io.chagchagchag.example.r2dbc_example.repository.valueobject.BookAuthor;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface BookQueryRepository extends ReactiveSortingRepository<Book, Long> {
  @Query(
      "SELECT b.*, a.name as author_name "
    + "FROM book b "
    + "INNER JOIN author a "
    + "    ON b.author_id = a.id "
    + "WHERE b.sale_status = :saleStatus"
  )
  Flux<BookAuthor> findBookBySaleStatusQuery(@Param("saleStatus") SaleStatus saleStatus);
}
