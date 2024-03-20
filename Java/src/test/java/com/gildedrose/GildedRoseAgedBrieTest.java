package com.gildedrose;

import com.gildedrose.app.GildedRose;
import com.gildedrose.model.Item;
import org.junit.jupiter.api.Test;

import static com.gildedrose.CommonEmulation.emulateYDaysPassed;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseAgedBrieTest {

    @Test
    void givenItemArraysOfAgedBrieAndSellIn12DaysAndQuality37_whenOneDayHasPassed_qualityIncrementedByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 12, 37) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(9, app.getItems()[0].getSellIn());
        assertEquals(40, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfAgedBrieAndSellIn7DaysAndQuality47_whenThreeDaysHavePassed_qualityIncrementedByThree() {
        Item[] items = new Item[] { new Item("Aged Brie", 7, 47) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(4, app.getItems()[0].getSellIn());
        assertEquals(50, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfAgedBrieAndSellIn7DaysAndQuality47_whenFourDaysHavePassed_qualityDoesChange() {
        Item[] items = new Item[] { new Item("Aged Brie", 7, 47) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 4);

        assertEquals(3, app.getItems()[0].getSellIn());
        assertEquals(50, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfAgedBrieExpired_whenOneDayHasPassed_qualityIncreasedByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 46) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 1);

        assertEquals(-1, app.getItems()[0].getSellIn());
        assertEquals(48, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfAgedBrieExpired_whenThreeDaysHavePassed_qualityIncreasedBySix() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 44) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(-3, app.getItems()[0].getSellIn());
        assertEquals(50, app.getItems()[0].getQuality());
    }


}
