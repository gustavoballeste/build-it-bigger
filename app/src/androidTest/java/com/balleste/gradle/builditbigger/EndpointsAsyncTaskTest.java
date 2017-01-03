package com.balleste.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.InstrumentationRegistry.getContext;

/**
 * Created by gustavoballeste on 28/12/16.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();

    @Test
    public void testNonEmptyString() {
        String joke = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext());
        endpointsAsyncTask.execute();
        try {
            joke = endpointsAsyncTask.get();
            Log.d(TAG, "Joke: " + joke);
        } catch (InterruptedException | ExecutionException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
        assertNotNull(joke);
        assertTrue(joke.length() > 0);
    }
}