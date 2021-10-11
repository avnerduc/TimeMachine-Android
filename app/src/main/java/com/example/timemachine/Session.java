package com.example.timemachine;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class Session {

  private SubSession currentSub;
  private List<SubSession> subSessions;
  private Duration totalFinishedDuration;

  Session() {
    subSessions = new LinkedList<>();
    totalFinishedDuration = Duration.ZERO;
  }

  public void start() throws IllegalStateException  {
    if (currentSub == null){
      throw new IllegalStateException ("There's already a running session!");
    }
    currentSub = new SubSession();
    currentSub.start();
  }

  //  public void pause();
  //  public void resume();

  public void stop() throws IllegalStateException  {
    if (currentSub == null){
      throw new IllegalStateException ("There's no running session to pause!");
    }
    currentSub.stop();
    subSessions.add(currentSub);
    totalFinishedDuration = currentPlusTotalDuration();
    currentSub = null;
  }

  public Duration getCurrentDuration() throws IllegalStateException  {
    if (currentSub == null){
      throw new IllegalStateException ("There's no running session to pause!");
    }
    return currentSub.getDuration();
  }

  public Duration getTotalDuration() throws IllegalStateException {
    if (currentSub == null){
      return totalFinishedDuration;
    }
    return currentPlusTotalDuration();
  }

  private Duration currentPlusTotalDuration(){
    return totalFinishedDuration.plus(currentSub.getDuration());
  }

}
