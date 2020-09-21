package com.webscocket.testing.demo.Controller;

import com.webscocket.testing.demo.messages.Greeting;
import com.webscocket.testing.demo.messages.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(@Payload HelloMessage message) throws Exception{
        Thread.sleep(1000);//simulated delay
        return new Greeting("Hello "+ HtmlUtils.htmlEscape(message.getName())+"!");
    }

//    @SubscribeMapping("/chat")
//    public HelloMessage sendWelcomeMessageOnSubscription(){
//        HelloMessage helloMessage = new HelloMessage();
//        helloMessage.setName("Hello world");
//        return helloMessage;
//    }

}
