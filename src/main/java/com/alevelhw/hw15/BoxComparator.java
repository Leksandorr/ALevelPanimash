package com.alevelhw.hw15;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
        double volume1 = o1.getVolume();
        double volume2 = o2.getVolume();
        if (volume1 == 0 || volume2 == 0) {
            if (volume1 == 0) {
                return -1;
            }
            else {
                return 1;
            }
        }
        return Double.compare(volume2, volume1);
    }
}
