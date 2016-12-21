package com.balleste;

import java.util.Random;

public class JokeProvider {

    private static String[] jokes = new String[]{
            "Programmer, a machine that turns coffe into code.",
            "Hardware, the part of a computer that you can kick.",
            "Unix is very friendly... It' just very particular about who its friends are.",
            "CAPS LOCK, preventing Login Since 1980.",
            "What do you call a programmer from Finland? \n" +
                "Nerdic.",
            "Programming is like sex:\n" +
                    "One mistake and you have to support it for the rest of your life."
    };

    public static String getJoke() {
        int size = jokes.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return jokes[index];
    }
}
