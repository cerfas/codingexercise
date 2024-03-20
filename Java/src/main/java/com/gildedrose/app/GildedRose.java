package com.gildedrose.app;

import com.gildedrose.model.Item;

public class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    public void updateQuality() {
        for (Item product : this.getItems()) {
            if (product.getName().contains("Sulfuras")) {
                //Nothing shall be updated.
            }  else if(product.getName().contains("Aged Brie")) {
                updateAgedBrie(product);
            }  else if(product.getName().contains("Backstage passes")) {
                updateBackStagePassesProduct(product);
            }  else if(product.getName().contains("Conjured")) {
                updateConjuredProduct(product);
            } else {
                updateNormalProduct(product);
            }
        }
    }

    private void updateBackStagePassesProduct(Item product) {
        diminishSellIn(product);
        if(product.getQuality() < 50) {
            if (product.getSellIn() >= 10) {
                augmentQuality(product);
            } else if (product.getSellIn() < 10 && product.getSellIn() > 5) {
                if(product.getQuality() + 2 <= 50) {
                    product.setQuality(product.getQuality() + 2);
                }
            } else if (product.getSellIn() <= 5 && product.getSellIn() >= 0) {
                if(product.getQuality() + 3 <= 50) {
                    product.setQuality(product.getQuality() + 3);
                }
            } else if (product.getSellIn() < 0 ){
                product.setQuality(0);
            }
        }
    }

    private void updateConjuredProduct(Item conjuredProduct) {
        diminishSellIn(conjuredProduct);
        if(conjuredProduct.getQuality() > 0) {
            conjuredProduct.setQuality(conjuredProduct.getQuality() - 2);
        }
    }
    private void updateNormalProduct(Item item) {
        diminishSellIn(item);
        if(item.getQuality() > 0 && item.getSellIn() >= 0) {
            diminishQuality(item);
        } else if (item.getSellIn() < 0 && item.getQuality() - 2 >= 0) {
            item.setQuality(item.getQuality() - 2);
        }
    }
    private void updateAgedBrie(Item product) {
        diminishSellIn(product);
        if(product.getQuality() < 50) {
            if(product.getSellIn() < 0 && product.getQuality() + 2 <= 50) {
                product.setQuality(product.getQuality() + 2);
            } else {
                augmentQuality(product);
            }
        }
    }

    private void diminishSellIn(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }
    private void augmentQuality(Item product) {
        product.setQuality(product.getQuality() + 1);
    }

    private void diminishQuality(Item product) {
        product.setQuality(product.getQuality() - 1);
    }

    public Item[] getItems() {
        return items;
    }
}
