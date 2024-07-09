package toby.spring.hellospring;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toby.spring.hellospring.payment.ExRateProvider;
import toby.spring.hellospring.payment.ExRateProviderStub;
import toby.spring.hellospring.payment.PaymentService;

@Configuration
public class TestPaymentConfig {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(exRateProvider(),clock());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new ExRateProviderStub(BigDecimal.valueOf(500));
  }

  @Bean
  public Clock clock() {
    return Clock.fixed(Instant.now(), ZoneId.systemDefault());
  }
}
