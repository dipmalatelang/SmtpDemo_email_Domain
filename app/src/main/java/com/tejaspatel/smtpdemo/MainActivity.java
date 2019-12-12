package com.tejaspatel.smtpdemo;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      sendMessage();
   }

   private void sendMessage() {
      new Thread(new Runnable() {

         @Override
         public void run() {
            try {
               GMailSender sender = new GMailSender("tera Email",
                    "tera password");
               sender.sendMail("kuch data", "message ka body",
                    "tera mail id", "receiver ka mail id");
            } catch (Exception e) {
               Log.e("SendMail", e.getMessage(), e);
            }
         }

      }).start();
   }
}
