package com.tejaspatel.smtpdemo;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   String TAG ="";

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      sendMessage();
//      sendmsg();
   }

   private void sendMessage() {
      new Thread(new Runnable() {

         @Override
         public void run() {
            try {
               GMailSender sender = new GMailSender("support@cotravel.in",
                    "Jiyakiyan@9");
               sender.sendMail("Cotravel", "welcome",
                    "support@cotravel.in", "dipaffwl@gmail.com");

               Log.d(TAG, "run: "+sender);
            } catch (Exception e) {
               Log.e("SendMail", e.getMessage(), e);
            }
         }

      }).start();
   }

   private void sendmsg()
   {

      GMailSender sender = new GMailSender("support@cotravel.in","Jiyakiyan@9");
      try {
         sender.sendMail("Cotravel", "welcome",
                 "support@cotravel.in", "dipaffwl@gmail.com");
      } catch (Exception e) {
         Log.e(TAG, "Failed sending email.", e);
      }
   }
}
