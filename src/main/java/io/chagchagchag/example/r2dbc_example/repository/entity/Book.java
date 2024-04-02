package io.chagchagchag.example.r2dbc_example.repository.entity;

import io.chagchagchag.example.r2dbc_example.repository.type.SaleStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Book {
  @Id
  private Long id;
  private String name;
  private BigDecimal price;
//  @Column("published_at") // snake case 와 camel case 가 정확히 일치하면 생략 가능
  private LocalDateTime publishedAt;
//  @Column("sale_status") // snake case 와 camel case 가 정확히 일치하면 생략 가능
  private SaleStatus saleStatus;
  private Long authorId;
}
