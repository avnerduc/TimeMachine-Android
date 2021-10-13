package com.example.timemachine;

import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

  private Chronometer chronometer;
  private SessionManager manager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    chronometer = findViewById(R.id.chronometer);
    manager = new SessionManager();
  }

  public void start(View view) {
    manager.start();
    chronometer.setBase(SystemClock.elapsedRealtime());
    chronometer.start();
  }

  public void stop(View view) {
    try {
      manager.stop();
    }
    catch (IllegalStateException e) {
      showErrorToast(e.getMessage());
    }
    chronometer.stop();
  }

  private void showErrorToast(String message) {
    Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
    toast.show();
  }

  public void pause(View view) {}
  public void resume(View view) {}
}