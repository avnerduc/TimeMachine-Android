package com.example.timemachine;

import java.util.LinkedList;
import java.util.List;


public class SessionManager {

    private Session currentSession;
    private List<Session> sessionList;


    public SessionManager() {
        sessionList = new LinkedList<>();
    }

    public void start() {
        currentSession = new Session();
        currentSession.start();
    }

    public void stop() throws IllegalStateException { //todo: change name to 'end'?
        if (currentSession == null) {
            throw new IllegalStateException ("There's no running session to stop!");
        }
        currentSession.stop();
        sessionList.add(currentSession);
        currentSession = null;
    }
}
