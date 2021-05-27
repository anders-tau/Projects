package web.service.misc;

import java.util.Random;

public class AppGetRandomValue {
    public long getRandom() {
        Random objGenerator = new Random();
        long randomId = objGenerator.nextInt();
        randomId = (randomId < 0) ? (-randomId) : randomId;
        return randomId;
    }
}
