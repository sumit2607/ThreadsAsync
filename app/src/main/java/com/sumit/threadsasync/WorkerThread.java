package com.sumit.threadsasync;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class WorkerThread extends  Thread{
    private Handler handler; // for adding the task
    @Override
    public void run() {
        super.run();
        //Log.d("sumit -1 " , Thread.currentThread().getName());

        Looper.prepare(); // creating thr instance
        handler = new Handler(Looper.myLooper());
        Looper.loop();
    }
    public void addtasktoQueue(Runnable task){

       if(handler!=null){
           handler.post(task);
       }
    }
}
