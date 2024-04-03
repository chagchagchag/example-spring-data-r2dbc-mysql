package io.chagchagchag.example.r2dbc_example.config;

import io.asyncer.r2dbc.mysql.MySqlConnectionConfiguration;
import io.asyncer.r2dbc.mysql.MySqlConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
public class R2dbcMySqlConfig {

  @Bean
  public MySqlConnectionFactory mySqlConnectionFactory(){
    MySqlConnectionConfiguration config = MySqlConnectionConfiguration.builder()
        .host("localhost")
        .port(23306)
        .username("user").password("test1357")
        .database("example")
        .build();

    return MySqlConnectionFactory.from(config);
  }

  @Bean
  public ReactiveTransactionManager transactionManager(MySqlConnectionFactory connectionFactory){
    return new R2dbcTransactionManager(connectionFactory);
  }

  @Bean
  public ConnectionFactoryInitializer initializer(MySqlConnectionFactory connectionFactory){
    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    initializer.setDatabasePopulator(populator);
    return initializer;
  }

  @Bean
  public R2dbcEntityTemplate r2dbcEntityTemplate(
      MySqlConnectionFactory connectionFactory
  ){
    return new R2dbcEntityTemplate(connectionFactory);
  }

}
