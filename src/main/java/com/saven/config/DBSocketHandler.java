package com.saven.config;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.saven.model.GapsIndex;
import com.saven.service.UserService;

@Component
public class DBSocketHandler extends TextWebSocketHandler {
	
	Timer timer;	
	DateTimeFormatter timeFormatter = 
			DateTimeFormatter.ofPattern("HH:mm:ss");
	
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();

	@Override
	public void handleTextMessage(final WebSocketSession session, TextMessage message)
			throws InterruptedException, IOException {
		//Map<String, String> value = new Gson().fromJson(message.getPayload(), Map.class);
		
		TimerTask timerTask = new TimerTask() {			
			@Override
			public void run() {
				sendData(session);
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 0, 1*1000);
		
		/*if (sessions.size()==1){
			timer.scheduleAtFixedRate(
					() ->sendData(session, value.get("name")),0,1,TimeUnit.SECONDS);
		}*/
		/*for(WebSocketSession webSocketSession : sessions) {
			webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
		}*/
		//User user = userService.getUserById(value.get("name"));
		/*ApplicationContext ctx = new AnnotationConfigApplicationContext();
		userService1 = ctx.getBean(UserService.class);
		User user1 = userService1.getUserById(value.get("name"));
		
		session.sendMessage(new TextMessage("Hello " + user1.getUserName() + " your email is : "+user1.getMail()));
		*/
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//the messages will be broadcasted to all users.
		sessions.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//session.close(status);
		timer.cancel();;
	}
	
	private void sendData(WebSocketSession session){
		UserService userService1 = ApplicationContextHolder.getContext().getBean(UserService.class);
		List<GapsIndex> gaps = userService1.getLatestGaps();
		try {
			session.sendMessage(new TextMessage(new Gson().toJson(gaps)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		/*for (WebSocketSession sess: sessions){
			try{
				session.sendMessage(new TextMessage(user.getUserName()+":"+user.getMail()));
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
	   }*/
   }

}