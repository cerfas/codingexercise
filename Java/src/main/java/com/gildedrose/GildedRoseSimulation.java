package com.gildedrose;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GildedRoseSimulation {

    private static final Logger LOG = Logger.getLogger(GildedRoseSimulation.class.toString());

    public static void main(String[] args) {
        LOG.log(Level.INFO, "****************  SIMULATE PRODUCT UPDATING ************");

        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        for (int day = 4 ; day > 0 ; day--) {
            LOG.log(Level.INFO , "-------- {0} days before expiration --------", day);
            LOG.log(Level.INFO,"name, sellIn, quality");
            for (Item product : items) {
                LOG.log(Level.INFO, "product info : {0}", product);
            }
            app.updateQuality();
        }
    }

}
