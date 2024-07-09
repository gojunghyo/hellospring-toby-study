package toby.spring.hellospring.payment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import toby.spring.hellospring.exrate.WebApiExRateProvider;

class PaymentServiceTest {

  @Test
  @DisplayName("prepare 메소드가 요구사항 3가지를 잘 충족했는지 검증")
  void prepare() throws IOException {
//    PaymentService paymentService = new PaymentService(new ExRateProviderStub(BigDecimal.valueOf(500)),);
//
//    Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
//
//    // 환율 정보 가져옴
//    Assertions.assertThat(payment.getExRate()).isEqualTo(BigDecimal.valueOf(500));
//
//    // 원화 환산금액 계산
//    Assertions.assertThat(payment.getConvertedAmount()).isEqualByComparingTo(
//        payment.getExRate().multiply(payment.getForeignCurrencyAmount())
//    );
//
//    // 원화환산금액의 유효시간 계산
//    Assertions.assertThat(payment.getValidUntil())
//        .isAfter(LocalDateTime.now());

  }
}
