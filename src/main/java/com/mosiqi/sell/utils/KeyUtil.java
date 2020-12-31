package com.mosiqi.sell.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * generate unique ID
     * format: time + random number
     * @return
     */
    //Repeated id is still possible in multi-thread situation，
    // add "synchronized" to solve this.
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        //generate 6 place random number
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);

    }
}
