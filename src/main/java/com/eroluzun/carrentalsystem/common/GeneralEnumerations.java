package com.eroluzun.carrentalsystem.common;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GeneralEnumerations {

    public enum CarStatus {

        AVAILABLE,
        ON_RENT,
        IN_MAINTENANCE,
        BROKEN,
        CLOSED_FOR_RENTAL
    }

    public enum OrderStatus {

        IN_PROGRESS,
        BILLED
    }

}

