/**
 * Copyright (c) 2025, WONG Sai Lung. All rights reserved.
 * @author WONG, Sai Lung
 * @version v1.0.1
 */
public class Teller {

    private int serveTimeRemaining;
    Customer customerServing;

    /**
     * Create a new teller in a supermarket.
     */
    public Teller() {
        this.serveTimeRemaining = 0;
    }

    /**
     * Return a {@code boolean} that is the teller serving a customer or not.
     *
     * @return a {@code boolean} that is the teller serving a customer or not
     */
    public boolean isServing() {
        return this.serveTimeRemaining > 0;
    }

    /**
     * Start serve a new customer.
     *
     * @param customer who needs to startServe
     * @throws ServingException if the teller serving a customer
     */
    public void startServe(Customer customer, int timeStart) {
        if (isServing()) throw new ServingException("Serving is already in progress");

        this.customerServing = customer;
        customer.setTimeToLeave(customer.getTimeServing() + timeStart);
        this.serveTimeRemaining = this.customerServing.getTimeServing();
    }

    /**
     * Keep serve the customer.
     */
    public void serve() {
        if (!isServing()) throw new ServingException("No one is serving");

        this.serveTimeRemaining--;

        if (this.serveTimeRemaining == 0) {
            this.customerServing = null;
        }
    }

    public int getServeTimeRemaining() {
        return serveTimeRemaining;
    }

    public Customer getCustomerServing() {
        return customerServing;
    }
}
