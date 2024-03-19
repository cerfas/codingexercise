package com.gildedrose;

public class CommonEmulation {
    public static void emulateYDaysPassed(GildedRose gildedRose, int days) {
        for(int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }
    }
}
