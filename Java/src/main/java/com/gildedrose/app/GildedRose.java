package com.gildedrose.app;

import com.gildedrose.model.Item;
import com.gildedrose.processor.ProductQualityProcessor;
import com.gildedrose.processor.ProductQualityProcessorImpl;

public class GildedRose {
    private final Item[] items;
    private final ProductQualityProcessor qualityUpdateProcessor = ProductQualityProcessorImpl.getQualityProcessorInstance();
    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (Item product : this.getItems()) {
            if (product.getName().contains("Sulfuras")) {
                //Nothing shall be updated.
            }  else if(product.getName().contains("Aged Brie")) {
                qualityUpdateProcessor.updateAgedBrieProduct(product);
            }  else if(product.getName().contains("Backstage passes")) {
                qualityUpdateProcessor.updateBackStagePassesProduct(product);
            }  else if(product.getName().contains("Conjured")) {
                qualityUpdateProcessor.updateConjuredProduct(product);
            } else {
                qualityUpdateProcessor.updateNormalProduct(product);
            }
        }
    }
    public Item[] getItems() {
        return items;
    }
}
