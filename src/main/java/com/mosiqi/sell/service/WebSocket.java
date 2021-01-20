package com.mosiqi.sell.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webScoketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session){
        this.session = session;
        webScoketSet.add(this);
        log.info("[websocket notice] new connection, total:{}", webScoketSet.size());
    }

    @OnClose
    public void onClose(){
        webScoketSet.remove(this);
        log.info("[websocket notice] connection closed,total:{}", webScoketSet.size());
    }

    @OnMessage
    public void onMessage(String message){
        log.info("[websocket notice] receive message from client:{}", message);
    }

    public void sendMessage(String message){
        for(WebSocket webSocket : webScoketSet){
            log.info("[websocket notice] message broadcast, message={}",message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
