package com.codecool.shop.buckets;

public enum BucketName {

    PRODUCT_IMAGE("testbucketshop2021");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
