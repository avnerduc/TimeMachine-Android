package com.example.timemachine;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.time.Instant;

public class MainActivity extends AppCompatActivity {

  Chronometer stopwatch;
  long startTime, endTime;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }

  public void start(View view) {
    startTime = SystemClock.elapsedRealtime();
    stopwatch.start();
  }

  public void stop(View view) {
    endTime = SystemClock.elapsedRealtime();
    stopwatch.stop();

  }

}