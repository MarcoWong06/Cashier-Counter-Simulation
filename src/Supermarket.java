import Queue.LinkedQueue;

/**
 * Copyright (c) 2025, WONG Sai Lung. All rights reserved.
 * @author WONG, Sai Lung
 * @version v1.0.1
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
     * Process the supermarket, serve the customer in the queue.
     *
     * @param timeStart The time start of the supermarket
     * @return {@code true} if there is a customer served else {@code false}
     */
    public boolean process(int timeStart) {
        boolean result = false;
        for (int i = 0; i < maxTellers; i++) {
            if (tellers[i].isServing()) {
                tellers[i].serve();
            }
            if (!waitLine.isEmpty() && !tellers[i].isServing()) {
                tellers[i].startServe((Customer)(waitLine.dequeue()), timeStart);
                result = true;
            }
        }
        return result;
    }

    /**
     * get leaving time of the customer who is serving.
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
