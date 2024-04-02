package io.chagchagchag.example.r2dbc_example.repository.valueobject;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookAuthor(
    Long id,
    String name,
    BigDecimal price,
    LocalDateTime publishedAt,
    String saleStatus,
    String authorName
) {

}
