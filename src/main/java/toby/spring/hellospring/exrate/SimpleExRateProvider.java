package toby.spring.hellospring.exrate;

import java.io.IOException;
import java.math.BigDecimal;
import toby.spring.hellospring.payment.ExRateProvider;

public class SimpleExRateProvider implements ExRateProvider {

  @Override
  public BigDecimal getExRate(String currency) throws IOException {
    if (currency.equals("USD")) return BigDecimal.valueOf(1000);
    throw new IllegalArgumentException("지원 되지 않는 통화 입니다.");
  }
}
