package com.multi.spring.chat.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.multi.spring.chat.model.dto.Message;
import com.multi.spring.chat.model.dto.OutputMessage;
import com.multi.spring.chat.model.dto.OutputMessage2;

@Controller
public class WebSocketController {
	

	
	@MessageMapping("/chat2") //채팅 내용 받을 때 사용하는 주소 
    @SendTo("/topic/messages2")
	public OutputMessage2 send2(Message message) { //from: guest, text:1
		System.out.println("받은 데이터>>" +  message);
		OutputMessage2 out = new OutputMessage2();
		String menu = "";
		switch (message.getText()) {
		case "1":
			menu = "챗 봇>> DB에서 가지고 온 주문목록 <br>" +
					"상품명: 가방";
			break;
		case "2":
			menu = "챗 봇>> DB에서 가지고 온 배송 상황 목록 <br>" +
					"상품명: 가방		배송 준비중";
			break;
	
		default:
			menu = "챗 봇>>선택한 번호는 없는 메뉴입니다. 다시 입력해주세요.";
			break;
		}
		out.setMenu(menu);
		return out;
	}
	
	
	
	@MessageMapping("/chat") //채팅 내용 받을 때 사용하는 주소 
    @SendTo("/topic/messages") //가입주소한 브라우저에 return message를 json으로 변환해서 보내줌.
	public OutputMessage send(Message message) {
		System.out.println("받은 데이터>>" +  message);
		OutputMessage out = new OutputMessage();
		out.setFrom(message.getFrom()); //sendMessage 가져옴
		out.setText(message.getText());
		Date date = new Date();
		out.setTime(date.getHours() + ":" + date.getMinutes());
		return out;
	}
}
