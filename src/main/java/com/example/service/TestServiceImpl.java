package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.dto.Sample;

@Service
public class TestServiceImpl implements TestService {

  // @Autowired
  // private MessageChannel test2;

  private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

  @Override
  public void send1(Sample sample) {
    // test2.send(MessageBuilder.withPayload(sample).build());
    logger.info("simple message sent successfully");
  }

  @Async
  @Override
  public void send2(Sample sample) {

    // test2.send(MessageBuilder.withPayload(sample).build());
    logger.info("Async message sent successfully");

  }

  @Override
  public void send3(Sample sample) {

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        // test2.send(MessageBuilder.withPayload(sample).build());
        logger.info("Runnable run() method call successfully");
      }

      @Override
      public String toString() {
        return "wrapper-Message-Sent-Kafka";
      }
    };

    new Thread(runnable).start();
    logger.info("Using runnable message sent successfully");
  }

  @Override
  public void send4(Sample sample) {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {

        // test2.send(MessageBuilder.withPayload(sample).build());
        logger.info("Thread run() method call successfully");

      }

      @Override
      public String toString() {
        return "without-wrapper-Message-Sent-Kafka";
      }
    });
    thread.start();
    logger.info("Using w/o wrapper message sent successfully");

  }

}
