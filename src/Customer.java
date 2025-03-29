/**
 * Copyright (c) 2025, WONG Sai Lung. All rights reserved.
 * @author WONG, Sai Lung
 * @version v1.0.0
 */
public class Customer {
    private final int timeServing;
    private int timeToLeave;

    /**
     * Customer who are served in the supermarket.
     *
     * @param timeServing Customer serving time
     */
    public Customer(int timeServing) {
        this.timeServing = timeServing;
    }

    public int getTimeServing() {
        return timeServing;
    }

    public int getTimeToLeave() {
        return timeToLeave;
    }

    public void setTimeToLeave(int timeToLeave) {
        this.timeToLeave = timeToLeave;
    }

    @Override
    public String toString() {
        return "" + timeServing;
    }
}