package com.internship.internproject;

import java.sql.Timestamp;

public class ratingModel {
    private int min;
    private int max;
    private float rated;
    private String timeDate;

    public ratingModel(int min, int max, float rated, String timeDate) {
        this.min = min;
        this.max = max;
        this.rated = rated;
        this.timeDate = timeDate;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public float getRated() {
        return rated;
    }

    public String getTimeDate() {
        return timeDate;
    }
}
