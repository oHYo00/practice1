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
		System.out.println("받은 데이터>>" +  message.getText());
		OutputMessage2 out = new OutputMessage2();
		String menu = "";
		switch (message.getText()) {
		case "1":
			menu = "오늘 날씨: 맑음<br>" +"10) 온도		11) 미세먼지			12) 강수확률";
			break;
		case "2":
			menu = "내일 날씨: 흐림  미세 먼지: 나쁨 강수확률 : 40% 20) 모레날씨		21)이번주 날씨		22) 다음주 날씨	";
			break;
		case "20":
			menu = "챗 봇>> 모레 날씨: 흐림 미세 먼지: 보통 강수확률 : 60%";
			break;
		case "10":
			menu = "챗 봇>> 현재 기온:32.5C  100) 하루전체온도	    200) 오전기온			300) 오후기온";
			break;
		case "100":
			menu = "챗 봇>>최저 기온: 22C 최고 기온: 32C 1000) 오늘의 복장 추천	1) 다시 처음 메뉴";
			break;
		case "1000":
			menu = "챗 봇>>  오늘복장은 반팔 반바지에 해빛이 강한 관계로 선크림을 바르는것을 추천 합니다.	100)이전 메뉴로";
			break;
		default:
			menu = "챗 봇>>선택한 번호는 없는 메뉴입니다. 다시 입력해주세요.";
			break;
		}
		System.out.println(menu);
		out.setMenu(menu);
		return out;
	}
	
	
	@MessageMapping("/chat") //채팅 내용 받을 때 사용하는 주소 
    @SendTo("/topic/messages") //가입주소한 브라우저에 return message를 json으로 변환해서 보내줌.
	public OutputMessage send(Message message) {
		System.out.println("받은 데이터>>" +  message);
		OutputMessage out = new OutputMessage();
		out.setFrom(message.getFrom());
		out.setText(message.getText());
		Date date = new Date();
		out.setTime(date.getHours() + ":" + date.getMinutes());
		return out;
	}
}
