package com.gildedrose;

import com.gildedrose.app.GildedRose;
import com.gildedrose.model.Item;

import org.junit.jupiter.api.Test;

import static com.gildedrose.CommonEmulation.emulateYDaysPassed;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseConjuredTest {

    @Test
    void givenItemArraysOfConjuredProductWithSellIn19DaysAndQuality47_whenOneDayHasPassed_qualityDecreasedByTwo() {
        Item[] items = new Item[] { new Item("Conjured", 19, 47) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 1);

        assertEquals(18, app.getItems()[0].getSellIn());
        assertEquals(45, app.getItems()[0].getQuality());
    }


    @Test
    void givenItemArraysOfConjuredProductWithSellIn19DaysAndQuality47_whenThreeDaysHavePassed_qualityDecreasedBySix() {
        Item[] items = new Item[] { new Item("Conjured", 19, 47) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(16, app.getItems()[0].getSellIn());
        assertEquals(41, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfConjuredProductWithSellIn6DaysAndQuality4_whenTwoDaysHavePassed_qualityIsZero() {
        Item[] items = new Item[] { new Item("Conjured", 6, 4) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 2);

        assertEquals(4, app.getItems()[0].getSellIn());
        assertEquals(0, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfConjuredProductWithSellIn6DaysAndQuality4_whenFourDaysHavePassed_qualityIsStillZero() {
        Item[] items = new Item[] { new Item("Conjured", 6, 4) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 4);

        assertEquals(2, app.getItems()[0].getSellIn());
        assertEquals(0, app.getItems()[0].getQuality());
    }
}
