package com.example.Counter;

import com.example.Railway.Carrige;

public class Counter {
    public static int findSizeOfTrain(Carrige start){
        if (start == null) return 0;
        if (start.getLinkNext() == null) return 1;

        int resultSize;

        start.setLight(true);
        Carrige now;
        int tempSize;

        do {
            tempSize = 1;
            now = start.getLinkNext();
            while (!now.getLight()) {
                now = now.getLinkNext();
                tempSize++;
            }
            
            now.setLight(false);
            resultSize = tempSize;

            while (tempSize != 0) {
                now = now.getLinkPrev();
                tempSize--;
            }

        } while(now.getLight());

        return resultSize;

    }
}
