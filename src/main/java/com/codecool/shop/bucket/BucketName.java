package com.codecool.shop.bucket;

public enum BucketName {
    IMAGE("testbucketshop2021");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
