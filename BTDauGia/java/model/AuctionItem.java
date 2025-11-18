package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuctionItem {
    private long id;
    private String description;
    private double initialPrice;
    private double priceStep;
    private Date startDate;
    private Date endDate;
    private User seller;
    private double currentPrice;
    private String details;
    private List<Bid> bids = new ArrayList<>();

    public AuctionItem(long id, String description, double initialPrice, double priceStep, User seller, String details) {
        this.id = id;
        this.description = description;
        this.initialPrice = initialPrice;
        this.currentPrice = initialPrice; // Giá hiện tại ban đầu bằng giá khởi điểm
        this.priceStep = priceStep;
        this.seller = seller;
        this.details = details;
        this.startDate = new Date();
        // Giả sử kết thúc sau 30 ngày
        this.endDate = new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000); 
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
        if (bid.getAmount() > this.currentPrice) {
            this.currentPrice = bid.getAmount();
        }
    }
    
    // Phương thức tính thời gian còn lại (giả lập getDuration trong đề)
    public String getDuration() {
        long diff = endDate.getTime() - new Date().getTime();
        if (diff <= 0) return "Đã kết thúc";
        long days = diff / (24 * 60 * 60 * 1000);
        long hours = (diff / (60 * 60 * 1000)) % 24;
        long minutes = (diff / (60 * 1000)) % 60;
        return days + " ngày " + hours + " giờ " + minutes + " phút";
    }

    // Getters
    public long getId() { return id; }
    public String getDescription() { return description; }
    public double getInitialPrice() { return initialPrice; }
    public double getCurrentPrice() { return currentPrice; }
    public List<Bid> getBids() { return bids; }
    public double getPriceStep() { return priceStep; }
    public User getSeller() { return seller; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
}