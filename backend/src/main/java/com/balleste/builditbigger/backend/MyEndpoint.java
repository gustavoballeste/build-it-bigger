/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.balleste.builditbigger.backend;

import com.balleste.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.balleste.com",
                ownerName = "backend.builditbigger.balleste.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that return a joke.
     */

    @ApiMethod(name = "sayAJoke")
    public MyBean sayAJoke() {
        MyBean response = new MyBean();
        response.setData((JokeProvider.getJoke()));
        return response;
    }
}
