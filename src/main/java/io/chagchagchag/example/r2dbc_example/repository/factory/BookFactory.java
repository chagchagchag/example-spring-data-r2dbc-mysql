package io.chagchagchag.example.r2dbc_example.repository.factory;

import io.chagchagchag.example.r2dbc_example.repository.entity.Book;
import io.chagchagchag.example.r2dbc_example.repository.type.SaleStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class BookFactory {
  public Book of(Long id, String name, BigDecimal price, LocalDateTime publishedAt, SaleStatus saleStatus){
    return new Book(id, name, price, publishedAt, saleStatus);
  }

  public Book newBook(String name, BigDecimal price, LocalDateTime publishedAt){
    return of(null, name, price, publishedAt, SaleStatus.WAITING_FOR_SALE);
  }

  public Book withSaleStatus(Book book, SaleStatus saleStatus){
    return of(book.getId(), book.getName(), book.getPrice(), book.getPublishedAt(), book.getSaleStatus());
  }
}
