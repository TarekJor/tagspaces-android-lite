package org.tagspaces.androidle;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import org.apache.cordova.*;

public class TagSpaces extends Activity implements CordovaInterface
{
    private CordovaWebView mainWebView;
    private final ExecutorService threadPool = Executors.newCachedThreadPool();
    private CordovaPlugin activityResultCallback;
    private boolean keepRunning;
    private boolean activityResultKeepRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainWebView = (CordovaWebView) findViewById(R.id.mainWebView);
        mainWebView.getSettings().setDomStorageEnabled(true);
        mainWebView.getSettings().setJavaScriptEnabled(true);

        Config.init(this);
        mainWebView.loadUrl(Config.getStartUrl());
        //mainWebView.loadUrl("file:///android_asset/www/index.html");
    }

    /* CordovaInterface Method */
    @Override
    public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode) {
        this.activityResultCallback = command;
        this.activityResultKeepRunning = this.keepRunning;
        // If multitasking turned on, then disable it for activities that return results
        if (command != null) {
            this.keepRunning = false;
        }
        super.startActivityForResult(intent, requestCode);
    }

    /* CordovaInterface Method */
    @Override
    public void setActivityResultCallback(CordovaPlugin plugin) {
        this.activityResultCallback = plugin;
    }

    /* CordovaInterface Method */
    @Override
    public Activity getActivity() {
        return this;
    }

    /* CordovaInterface Method */
    @Override
    public Object onMessage(String id, Object data) {
        // TODO Auto-generated method stub
        return null;
    }

    /* CordovaInterface Method */
    @Override
    public ExecutorService getThreadPool() {
        return threadPool;
    }
}