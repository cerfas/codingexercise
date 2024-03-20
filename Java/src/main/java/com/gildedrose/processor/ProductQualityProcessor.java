package com.gildedrose.processor;

import com.gildedrose.model.Item;

public interface ProductQualityProcessor {
    public void updateAgedBrieProduct(Item product);
    public void updateBackStagePassesProduct(Item product);
    public void updateConjuredProduct(Item product);
    public void updateNormalProduct(Item product);
}
