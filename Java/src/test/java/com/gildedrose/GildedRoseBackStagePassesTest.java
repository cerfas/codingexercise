package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.CommonEmulation.emulateYDaysPassed;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseBackStagePassesTest {

    @Test
    void givenItemArraysOfBackStagePassesWithSellIn12AndQuality37_whenOneDayHasPassed_qualityIncrementedByOne() {
        Item[] items = new Item[] { new Item("Backstage passes", 12, 37) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 1);

        assertEquals(11, app.getItems()[0].getSellIn());
        assertEquals(38, app.getItems()[0].getQuality());
    }


    @Test
    void givenItemArraysOfBackStagePassesWithSellInLowerThan10DaysButGreaterThan5_whenOneDayHasPassed_qualityIncrementedByTwo() {
        Item[] items = new Item[] { new Item("Backstage passes", 7, 20) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 1);

        assertEquals(6, app.getItems()[0].getSellIn());
        assertEquals(22, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfBackStagePassesWithSellInLowerThan10DaysButGreaterThan5_whenThreeDayHavePassed_qualityIncrementedBySix() {
        Item[] items = new Item[] { new Item("Backstage passes", 10, 27) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(7, app.getItems()[0].getSellIn());
        assertEquals(33, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfBackStagePassesWithSellInLowerThan5DaysButGreaterThan1_whenOneDayHasPassed_qualityIncrementedBy3() {
        Item[] items = new Item[] { new Item("Backstage passes", 4, 17) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 1);

        assertEquals(3, app.getItems()[0].getSellIn());
        assertEquals(20, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfBackStagePassesWithSellInLowerThan5DaysButGreaterThan1_whenOneDayHasPassed_qualityRemain50() {
        Item[] items = new Item[] { new Item("Backstage passes", 4, 48) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 3);

        assertEquals(1, app.getItems()[0].getSellIn());
        assertEquals(48, app.getItems()[0].getQuality());
    }

    @Test
    void givenItemArraysOfBackStagePassesAfterConcert_whenOneDayHasPassed_qualityIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes", 0, 48) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 1);

        assertEquals(-1, app.getItems()[0].getSellIn());
        assertEquals(0, app.getItems()[0].getQuality());
    }

    /**
     * This test emulates a scenario of cumulative increments both simple and complex depending on
     * SellIn period.
     * Initial Quality: 7
     * with SellIn of 20  after 18 days have passed so remaining days equals 2, we have:
     * An increment by one when SellIn is lower and equal to 9 so for the first 10 days
     * the quality  sums up to 7 + 10 * 1 = 17
     * From then 10 to 5 excluded the increment double
     * 17 + 2 * 4 = 25
     * 15 days have elapsed From 5 to  1  the increment triples
     * We have 3 remaining days
     * 25 + 4 * 3 = 37
     *
     * Backstage passes to a TAFKAL80ETC concert, 15, 20
     * */

    @Test
    void givenItemArraysOfBackStagePassesWithSellIn20_when18DayHavePassed_qualityIs36() {
        Item[] items = new Item[] { new Item("Backstage passes", 20, 7) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 18);

        assertEquals(2, app.getItems()[0].getSellIn());
        assertEquals(37, app.getItems()[0].getQuality());
    }

    /**
     * The scenario with the cumulative type of increase, but with a quality check after the concert.
     * */

    @Test
    void givenItemArraysOfBackStagePassesWithSellIn20_when21DayHavePassed_qualityIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes", 20, 7) };

        GildedRose app = new GildedRose(items);
        emulateYDaysPassed(app, 21);

        assertEquals(-1, app.getItems()[0].getSellIn());
        assertEquals(0, app.getItems()[0].getQuality());
    }
}
