package com.balleste.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.balleste.android.displayjoke.JokeDisplayActivity;
import com.balleste.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by gustavoballeste on 20/12/16.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;
    private ProgressBar mSpinner;

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.mContext = context;
        mSpinner = progressBar;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (mSpinner != null) {
            mSpinner.setVisibility(View.VISIBLE);
        }
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
////                    .setRootUrl("http://100.114.79.155:8080/_ah/api/") use o ip da máquina para testar em um dispositivo real
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-153218.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.sayAJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.EXTRA_JOKE,result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
        if (mSpinner != null) {
            mSpinner.setVisibility(View.GONE);
        }
    }
}
