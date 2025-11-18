package service;

import model.AuctionItem;
import model.Bid;
import model.User;
import java.util.ArrayList;
import java.util.List;

public class AuctionService {
    private static List<User> users = new ArrayList<>();
    private static List<AuctionItem> items = new ArrayList<>();

    static {
        // Tạo User mẫu
        User u1 = new User("hoangnv", "hoangnv", "ABC Corp", "0909123456", "hoang@mail.com", "TPHCM");
        User u2 = new User("mrhuy", "123", "Đỗ Cao Huy", "0983243936", "traisitinhs@yahoo.com", "A75/6B/24 TB");
        User u3 = new User("phandinhthanh", "123", "Thanh Phan", "0909000000", "thanh@mail.com", "HN");
        users.add(u1);
        users.add(u2);
        users.add(u3);

        // Tạo Item mẫu theo đề bài [cite: 122]
        items.add(new AuctionItem(1, "Máy chụp hình Canon IXY 910 IS (8.0 MP)", 100000, 100000, u2, "Chi tiết Canon..."));
        items.add(new AuctionItem(2, "Laptop Acer 3680-2682 hang xach tay", 3000000, 200000, u2, "Chất lượng còn hoàn hảo..."));
        items.add(new AuctionItem(3, "Máy nghe nhạc APPLE IPHONE 16GB", 500000, 50000, u1, "Hàng mới 99%"));
        items.add(new AuctionItem(4, "Bán gấp Nokia N72 chính hãng", 2600000, 100000, u3, "Cần bán gấp..."));
        items.add(new AuctionItem(5, "Nước hoa Embrace Him-8057", 150000, 20000, u1, "Mùi hương nam tính..."));

        // Giả lập vài lượt bid có sẵn
        bid(u3, items.get(0), 200000); // phandinhthanh bid Canon
        bid(u3, items.get(0), 300000); 
    }

    public List<AuctionItem> getAllAuctionItems() { return items; }

    public AuctionItem getAuctionItem(Long id) {
        for (AuctionItem item : items) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public User authenticateUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    // Phương thức đặt giá static để dùng chung
    public static void bid(User user, AuctionItem item, double amount) {
        if (amount > item.getCurrentPrice()) {
            item.addBid(new Bid(user, item, amount));
        }
    }
}