package com.webscocket.testing.demo.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class HelloMessageResponse {
    private String content;
}
