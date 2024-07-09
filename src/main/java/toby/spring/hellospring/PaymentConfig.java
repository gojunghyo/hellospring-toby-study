package toby.spring.hellospring;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import toby.spring.hellospring.exrate.WebApiExRateProvider;
import toby.spring.hellospring.payment.ExRateProvider;
import toby.spring.hellospring.payment.PaymentService;

@Configuration
public class PaymentConfig {

  @Bean
  public PaymentService paymentService() {
    return new PaymentService(exRateProvider(), clock());
  }

  @Bean
  public ExRateProvider exRateProvider() {
    return new WebApiExRateProvider();
  }

  @Bean
  public Clock clock() {
    return Clock.systemDefaultZone();
  }
}
