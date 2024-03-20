package com.gildedrose;

import com.gildedrose.app.GildedRose;
import com.gildedrose.model.Item;

import org.junit.jupiter.api.Test;

import static com.gildedrose.CommonEmulation.emulateYDaysPassed;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Elapsed day is emulated with a for loop, where 1 iteration corresponds to one elapsed day.
 * **/

class GildedRoseSulfurasTest {

    @Test
    void givenItemArraysOfSulfurasAndSelling7Days_whenOneDayHasPassed_qualityDoesChange() {
        Item[] items = new Item[] { new Item("Sulfuras", 30, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Sulfuras", app.getItems()[0].getName());
        assertEquals(80, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfSulfurasAndSelling7Days_whenThreeDaysHavePassed_qualityDoesChange() {
        Item[] items = new Item[] { new Item("Sulfuras", 7, 80) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(7, app.getItems()[0].getSellIn());
        assertEquals(80, app.getItems()[0].getQuality());
    }

}
