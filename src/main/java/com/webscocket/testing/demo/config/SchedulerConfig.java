package com.webscocket.testing.demo.config;

import com.webscocket.testing.demo.messages.Greeting;
import com.webscocket.testing.demo.messages.HelloMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.util.HtmlUtils;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedDelay = 3000)
    public void sendUpdateMessages(){
        simpMessagingTemplate.convertAndSend("/topic/greetings",new Greeting("Hello Scheduler!"));
    }
}
