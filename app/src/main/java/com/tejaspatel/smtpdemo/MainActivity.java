package com.tejaspatel.smtpdemo;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      new Thread(new Runnable() {

         @Override
         public void run() {
            try {
               GMailSender sender = new GMailSender("tej72793@gmail.com",
                    "Uzumymwlxgiwyl");
               sender.sendMail("Hello from JavaMail", "Body from JavaMail",
                    "tej72793@gmail.com", "tpatel0279@gmail.com");
            } catch (Exception e) {
               Log.e("SendMail", e.getMessage(), e);
            }
         }

      }).start();
   }
}
