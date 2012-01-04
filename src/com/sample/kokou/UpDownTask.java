package com.sample.kokou;

import android.os.AsyncTask;

abstract public class UpDownTask extends AsyncTask<Void, Void, Void> {
    private static final int INTERVAL = 500;   // 0.5秒
    protected NumericView view;
    
    public UpDownTask(NumericView view) {
        this.view = view;
    }
    
    @Override
    protected Void doInBackground(Void... params) {
        while (true) {
            if ( isCancelled() ) {
                return null;
            }
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                return null;
            }
            publishProgress(null);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        yield(view);
    }
    
    abstract void yield(NumericView view);
}
