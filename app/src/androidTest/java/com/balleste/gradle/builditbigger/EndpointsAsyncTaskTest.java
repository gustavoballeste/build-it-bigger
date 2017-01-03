package com.balleste.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


/**
 * Created by gustavoballeste on 28/12/16.
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {
    private static final String TAG = EndpointsAsyncTask.class.getSimpleName();
    @Test
    public void testNonEmptyString() {
        String joke = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext(),null);
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
