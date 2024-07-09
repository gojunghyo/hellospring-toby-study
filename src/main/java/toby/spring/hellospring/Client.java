package toby.spring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import toby.spring.hellospring.payment.Payment;
import toby.spring.hellospring.payment.PaymentService;

public class Client {

  public static void main(String[] args) throws IOException, InterruptedException {
    BeanFactory beanFactory = new AnnotationConfigApplicationContext(PaymentConfig.class);
    PaymentService paymentService = beanFactory.getBean(PaymentService.class);

    Payment payment = paymentService.prepare(100L, "USD", BigDecimal.valueOf(50.7));
    System.out.println("payment1 " + payment);
  }

}
