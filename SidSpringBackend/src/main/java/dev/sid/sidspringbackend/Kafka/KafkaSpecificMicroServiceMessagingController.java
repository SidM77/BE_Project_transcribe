package dev.sid.sidspringbackend.Kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class KafkaSpecificMicroServiceMessagingController {
    public KafkaSpecificMicroServiceMessagingController(KafkaTemplate<String, MessageRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, MessageRequest> kafkaTemplate;

    @PostMapping("api/v1/sendSingleTestLink")
    public void publish (@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("oralTestTopic", messageRequest);
        System.out.println("At producer currently "+ messageRequest.toString()
        );
    }

    @PostMapping("api/v1/multipleMailsTesting")
    public void publishMailsTest (@RequestBody List<MessageRequest> messageRequest) {
//        kafkaTemplate.send("oralTestTopic", messageRequest);
        for (MessageRequest message : messageRequest) {
            kafkaTemplate.send("oralTestTopic", message);

            System.out.println("At producer currently "+ message.toString());
        }
    }
}
