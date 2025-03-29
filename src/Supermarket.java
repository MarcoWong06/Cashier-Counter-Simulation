import Queue.LinkedQueue;

/**
 * Copyright (c) 2025, WONG Sai Lung. All rights reserved.
 * @author WONG, Sai Lung
 * @version v1.0.0
 */
public class Supermarket {
    private final int maxTellers;
    private final Teller[] tellers;
    private final LinkedQueue waitLine;

    /**
     * Create a new supermarket with maximum tellers, initialize the supermarket.
     *
     * @param maxTellers Integer of maximum tellers in the supermarket
     */
    public Supermarket(int maxTellers) {
        this.maxTellers = maxTellers;
        tellers = new Teller[maxTellers];
        waitLine = new LinkedQueue();

        for (int i = 0; i < maxTellers; i++) {
            tellers[i] = new Teller();
        }
    }

    /**
     * The customer start checkout after finishing choosing the item.
     *
     * @param customer who start checkout
     */
    public void checkOut(Customer customer) {
        waitLine.enqueue(customer);
    }

    /**
     * Start a serve process for all serving counter.
     */
    public void process(int timeStart) {
        for (int i = 0; i < maxTellers; i++) {
            if (tellers[i].isServing()) {
                tellers[i].serve();
            }
            if (!waitLine.isEmpty() && !tellers[i].isServing()) {
                tellers[i].startServe((Customer)(waitLine.dequeue()), timeStart);
            }
        }
    }

    /**
     * get leaving time of the customer who are serving.
     *
     * @param tellerIdx The index of teller
     * @return {@code 0} if the teller is not serving else the leaving time of the customer
     */
    public int getCustomerLeaveTime(int tellerIdx) {
        if (tellers[tellerIdx].isServing()) {
            return tellers[tellerIdx].getCustomerServing().getTimeToLeave();
        } else {
            return 0;
        }
    }

    /**
     * Get the waiting queue inside the supermarket.
     *
     * @return String of the waiting queue
     */
    public String getWaitingQueue() {
        return waitLine.toString();
    }

    public int getWaitingQueueSize() {
        return waitLine.size();
    }

}
