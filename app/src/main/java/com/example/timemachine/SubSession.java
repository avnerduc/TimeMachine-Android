package com.example.timemachine;

import java.time.Duration;
import java.time.Instant;

public class SubSession {

  Instant start;
  Instant end;

  SubSession(){
  }

  public void start() {
    start = Instant.now();
  }

  public void stop(){
    end = Instant.now();
  }

  public Duration getDuration() throws IllegalStateException {
    if (start == null){
      throw new IllegalStateException ("No start or end Instances");
    }
    if (end == null) {
      return Duration.between(start, Instant.now());
    }
    return Duration.between(start, end);
  }

}

