package com.sumit.threadsasync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1, button2;
    private WorkerThread workerThread;

//    private Runnable task = new Runnable() {
//        @Override
//        public void run() {
//            Log.d("sumit -1 " , Thread.currentThread().getName()); // it will print sumit -1 after main
//            //in separate thread if we want to frizz the  main ui using  thread.sleep it is not possible
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.d("sumit", Thread.currentThread().getName()); // it will print main as a thread name
        WorkerThread  thread = new WorkerThread();
       workerThread.start();
        // Log.d("sumit", Thread.currentThread().getName()); // it will print main as a thread name
        button1 = findViewById(R.id.tvData);
        button2 = findViewById(R.id.tvData2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           workerThread.addtasktoQueue(TaskOne);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    workerThread.addtasktoQueue(TaskTwo);
            }
        });
    }

    private Runnable TaskOne = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private  Runnable TaskTwo = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
