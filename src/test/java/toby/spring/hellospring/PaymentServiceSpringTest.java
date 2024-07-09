package toby.spring.hellospring;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Clock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import toby.spring.hellospring.payment.ExRateProviderStub;
import toby.spring.hellospring.payment.Payment;
import toby.spring.hellospring.payment.PaymentService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestPaymentConfig.class)
class PaymentServiceSpringTest {

  @Autowired PaymentService paymentService;
  @Autowired ExRateProviderStub exRateProviderStub;
  @Autowired Clock clock;


  @Test
  void prepare() throws IOException {
    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    assertThat(payment.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(500));
    assertThat(payment.getConvertedAmount()).isEqualByComparingTo(
        payment.getExRate().multiply(payment.getForeignCurrencyAmount())
    );


    exRateProviderStub.setExRate(BigDecimal.valueOf(1_000));
    Payment payment2 = paymentService.prepare(1L, "USD", BigDecimal.TEN);

    assertThat(payment2.getExRate()).isEqualByComparingTo(BigDecimal.valueOf(1_000));


  }

  @Test
  void validUntill() throws IOException {
  }
}
