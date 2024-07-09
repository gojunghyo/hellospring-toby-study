package toby.spring.hellospring.exrate;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import toby.spring.hellospring.payment.ExRateProvider;

public class CachedExRateProvider implements ExRateProvider {

  private BigDecimal cachedExRate;
  private final ExRateProvider target;
  private LocalDateTime cacheExpiryTime;

  public CachedExRateProvider(ExRateProvider target) {
    this.target = target;
  }

  @Override
  public BigDecimal getExRate(String currency) throws IOException {

    if (cachedExRate == null || cacheExpiryTime.isBefore(LocalDateTime.now())) {
      cachedExRate = target.getExRate(currency);
      cacheExpiryTime = LocalDateTime.now().plusSeconds(3);
      System.out.println("Cache updated");
    }



    return cachedExRate;

  }
}
