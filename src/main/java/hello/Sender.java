package hello;

import javax.annotation.ManagedBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@ManagedBean
public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topic, String payload) {
    LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);

    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic,payload);
    future.addCallback(new ListenableFutureCallback<SendResult<String,String>>() {

      @Override
      public void onSuccess(SendResult<String, String> result) {
        LOGGER.info("successfully sent msg to kafka");
      }

      @Override
      public void onFailure(Throwable ex) {
        LOGGER.info("failed to send msg to kafka");
      }

    });
  }
}