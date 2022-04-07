package websocket;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ServerEndpoint("/websocket/{username}")
@Component
public class WebSocketServer {

	private static Map < Session, String > sessionUsernameMap = new Hashtable < > ();
	private static Map < String, Session> usernameSessionMap = new Hashtable < > ();
	
	private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
	
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username) throws IOException {
		logger.info("Test");
		sessionUsernameMap.put(session, username);
		usernameSessionMap.put(username, session);
		String message = "Hello " + username + " !";
		broadcast(message);
		
	}
	
	@OnMessage
	public void onMessage(Session session, String message) throws IOException {
		// Handle new messages
	    logger.info("Entered into Message: Got Message:" + message);
	    String username = sessionUsernameMap.get(session);

	}
	
	@OnClose
	public void onClose(Session session) throws IOException {
		logger.info("Close");
		String username = sessionUsernameMap.get(session);
		sessionUsernameMap.remove(session);
		usernameSessionMap.remove(username);
		String message = username + " disconnected";
		broadcast(message);
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		logger.info("Error");
	}
	
	private void broadcast(String message) {
		sessionUsernameMap.forEach((session, username) -> {
			try {
				session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				logger.info("Exception: " + e.getMessage().toString());
				e.printStackTrace();
			}
		});
	}
}
