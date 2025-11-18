package model;
import java.util.Date; // Dùng Date cho đơn giản hơn Calendar trong JSP

public class Bid {
    private User bidder;
    private AuctionItem item;
    private double amount;
    private Date created;

    public Bid(User bidder, AuctionItem item, double amount) {
        this.bidder = bidder;
        this.item = item;
        this.amount = amount;
        this.created = new Date();
    }

    public User getBidder() { return bidder; }
    public double getAmount() { return amount; }
}