package com.qilin.cms.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/6/8.
 */
public class WebsocketEndPoint extends TextWebSocketHandler{
    private static final List<WebSocketSession> users = new ArrayList<>();
    private Log log = LogFactory.getLog(WebsocketEndPoint.class);

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("链接成功......");
        users.add(session);
        String userName = (String) session.getAttributes().get("WEBSOCKET_USERNAME");
        log.info("username:"+ userName);
        if(userName!= null){
            //查询未读消息
            int count = 5;
            session.sendMessage(new TextMessage(count + ""));
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        String name = session.getId();
        TextMessage returnMessage = new TextMessage(name+":"+message.getPayload()+"");
        sendMessageToUsers(returnMessage);
    }

    public void sendMessageToUsers(TextMessage message){
        for(WebSocketSession user:users){
            if(user.isOpen()){
                try {
                    user.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
