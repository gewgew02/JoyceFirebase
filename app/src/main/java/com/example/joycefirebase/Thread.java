package com.example.joycefirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Thread extends AppCompatActivity {
    private Button buttonPlaceOrder, buttonClaimOrder;
    TextView textViewGreeting;
    private volatile boolean stopThreadFlag = false;
    private Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
//
//        buttonPlaceOrder = findViewById(R.id.buttonPlaceOrder);
//        buttonClaimOrder = findViewById(R.id.buttonClaimOrder);
//        textViewGreeting = findViewById(R.id.textViewGreeting);
//
//        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                buttonPlaceOrder(4);
//                Toast.makeText(Thread.this, "Placing your order to the kitchen"
//                        , Toast.LENGTH_SHORT).show();
//            }
        }
}
//
//        buttonClaimOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stopThread();
//                textViewGreeting.setText("Order is coming");
//                Toast.makeText(Thread.this, "Order is coming"
//                        , Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    public void buttonPlaceOrder(int seconds) {
//        placeOrderRunnable runnable = new placeOrderRunnable(4);
//        new Thread(runnable).start();
//    }
//
//    public void stopThread() {
//        stopThreadFlag = true;
//    }
//    class placeOrderRunnable implements Runnable
//    {
//        int seconds;
//        placeOrderRunnable(int seconds){
//            this.seconds = seconds;
//        }
//
//        @Override
//        public void run() {
//            for(int i =0; i< seconds; i++){
//                if(stopThreadFlag)
//                {
//                    return;
//                }
//                if(i == 4) {
//                    mainHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewGreeting.setText("ORDER PLACED, PLEASE WAIT");
//                        }
//                    });
//
//                }
//                Log.d("THREAD ACTIVITY", "Start Thread : " + i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
