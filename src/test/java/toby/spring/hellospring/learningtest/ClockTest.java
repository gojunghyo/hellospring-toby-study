package toby.spring.hellospring.learningtest;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClockTest {

  // Clock 이용해서 LocalDateTime.now
  @Test
  void clock() throws InterruptedException {
    Clock clock = Clock.systemDefaultZone();

    LocalDateTime dt1 = LocalDateTime.now(clock);
    Thread.sleep(1000);
    LocalDateTime dt2 = LocalDateTime.now(clock);

    Assertions.assertThat(dt2).isAfter(dt1);
  }


  // Clock 테스트해서 사용할때 원하는 시간을 지정해서 현재 시간을 가져오게 할수 있는가?
  @Test
  void fixedClock() throws InterruptedException {
    Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    LocalDateTime dt1 = LocalDateTime.now(clock);
    LocalDateTime dt2 = LocalDateTime.now(clock);

    Assertions.assertThat(dt2).isEqualTo(dt1);
  }

}
