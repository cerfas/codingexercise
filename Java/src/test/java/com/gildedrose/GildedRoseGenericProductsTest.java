package com.gildedrose;

import com.gildedrose.app.GildedRose;
import com.gildedrose.model.Item;

import org.junit.jupiter.api.Test;

import static com.gildedrose.CommonEmulation.emulateYDaysPassed;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseGenericProductsTest {

    @Test
    void givenArrayOfProductsInitializedWithOneNormalProduct_whenCheckingProductNameSuccessAndQualityDecreasedByOne() {
        Item[] items = new Item[] { new Item("Mozzarella", 30, 80) };
        GildedRose app = new GildedRose(items);

        emulateYDaysPassed(app,1);

        assertEquals("Mozzarella", app.getItems()[0].getName());
        assertEquals(79, app.getItems()[0].getQuality());
    }

    @Test
    void givenArrayOfItemsWithOneNormalProductAndSellingGreaterThanQuality_when8HavePassed_qualityIsZero() {
        Item[] items = new Item[] { new Item("Elixir of capucine", 10, 7) };
        GildedRose app = new GildedRose(items);

        emulateYDaysPassed(app,8);

        assertEquals(2, app.getItems()[0].getSellIn());
        assertEquals(0, app.getItems()[0].getQuality());
    }

    @Test
    void givenArrayOfItemsWithOneNormalProductAlmostExpired_when2DaysHavePassed_qualityDecreasedByTwo() {
        Item[] items = new Item[] { new Item("Vanilla extract", 0, 7) };
        GildedRose app = new GildedRose(items);

        emulateYDaysPassed(app,2);

        assertEquals(-2, app.getItems()[0].getSellIn());
        assertEquals(3, app.getItems()[0].getQuality());
    }

    @Test
    void givenArrayOfItemsWithMixedProduct_when4DaysHavePassed_qualityAndSellInHaveChangeSuitably() {
        GildedRose app = new GildedRose(TestFixture.getItemsGeneral());

        emulateYDaysPassed(app,4);
        assertEquals("+5 Dexterity Vest", app.getItems()[0].getName());
        assertEquals(6, app.getItems()[0].getSellIn());
        assertEquals(16, app.getItems()[0].getQuality());

        assertEquals("Aged Brie", app.getItems()[1].getName());
        assertEquals(-2, app.getItems()[1].getSellIn());
        assertEquals(6, app.getItems()[1].getQuality());

        assertEquals("Elixir of the Mongoose", app.getItems()[2].getName());
        assertEquals(1, app.getItems()[2].getSellIn());
        assertEquals(3, app.getItems()[2].getQuality());


        assertEquals("Sulfuras, Hand of Ragnaros", app.getItems()[3].getName());
        assertEquals(0, app.getItems()[3].getSellIn());
        assertEquals(80, app.getItems()[3].getQuality());

        assertEquals(-1, app.getItems()[4].getSellIn());
        assertEquals(80, app.getItems()[4].getQuality());

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[5].getName());
        assertEquals(11, app.getItems()[5].getSellIn());
        assertEquals(24, app.getItems()[5].getQuality());

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.getItems()[6].getName());
        assertEquals(6, app.getItems()[6].getSellIn());
        assertEquals(49, app.getItems()[6].getQuality());

        assertEquals(1, app.getItems()[7].getSellIn());
        assertEquals(49, app.getItems()[7].getQuality());

        assertEquals("Conjured Mana Cake", app.getItems()[8].getName());
        assertEquals(-1, app.getItems()[8].getSellIn());
        assertEquals(0, app.getItems()[8].getQuality());

    }
}
