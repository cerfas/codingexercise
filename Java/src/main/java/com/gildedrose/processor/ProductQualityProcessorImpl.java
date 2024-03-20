package com.gildedrose.processor;

import com.gildedrose.model.Item;

public class ProductQualityProcessorImpl implements ProductQualityProcessor {

    private static final ProductQualityProcessorImpl PRODUCT_QUALITY_PROCESSOR = new ProductQualityProcessorImpl();
    private ProductQualityProcessorImpl() {
        //Just for the sake of making sonar happy.
    }

    public void updateBackStagePassesProduct(Item product) {
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

    public void updateConjuredProduct(Item conjuredProduct) {
        diminishSellIn(conjuredProduct);
        if(conjuredProduct.getQuality() > 0) {
            conjuredProduct.setQuality(conjuredProduct.getQuality() - 2);
        }
    }
    public void updateNormalProduct(Item item) {
        diminishSellIn(item);
        if(item.getQuality() > 0 && item.getSellIn() >= 0) {
            diminishQuality(item);
        } else if (item.getSellIn() < 0 && item.getQuality() - 2 >= 0) {
            item.setQuality(item.getQuality() - 2);
        }
    }
    public void updateAgedBrieProduct(Item product) {
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

    public static ProductQualityProcessorImpl getQualityProcessorInstance() {
        return PRODUCT_QUALITY_PROCESSOR;
    }
}
