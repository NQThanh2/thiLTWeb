package model;
import java.util.Date;

public class Booking {
    private long id;
    private Customer customer;
    private Tour tour;
    private Date departureDate;
    private int noAdults;
    private int noChildren;

    // Constructors, Getters, and Setters
    public Booking() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Tour getTour() { return tour; }
    public void setTour(Tour tour) { this.tour = tour; }
    public Date getDepartureDate() { return departureDate; }
    public void setDepartureDate(Date departureDate) { this.departureDate = departureDate; }
    public int getNoAdults() { return noAdults; }
    public void setNoAdults(int noAdults) { this.noAdults = noAdults; }
    public int getNoChildren() { return noChildren; }
    public void setNoChildren(int noChildren) { this.noChildren = noChildren; }
}