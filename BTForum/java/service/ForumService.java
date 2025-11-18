package service;

import model.*;
import java.util.*;

public class ForumService {
    private static Map<String, User> users = new HashMap<>();
    private static List<Category> categories = new ArrayList<>();
    private static List<Topic> allTopics = new ArrayList<>();
    private static long idCounter = 1; // Tạo ID tự động

    static {
        // Tạo User mẫu [cite: 404]
        User u1 = new User("chuotcon", "chuotcon", "chuot@mail.com");
        User u2 = new User("admin", "123", "admin@mail.com");
        users.put(u1.getUserName(), u1);
        users.put(u2.getUserName(), u2);

        // Tạo Category và Topic mẫu [cite: 408-416]
        Category cat = new Category("Chuyện học phí và các chính sách hỗ trợ học tập");
        categories.add(cat);

        createSampleTopic(cat, u1, "Chuyện học phí!!!", "Tại sao phải đóng học phí?", 
                          new String[]{"Thưa anh chị...", "Vấn đề là..."});
        createSampleTopic(cat, u2, "Thủ tướng: Trường ĐH tư quyết mức học phí", "Nội dung bài báo...", null);
    }

    // Hàm hỗ trợ tạo dữ liệu mẫu
    private static void createSampleTopic(Category cat, User u, String title, String content, String[] replies) {
        Topic t = new Topic(idCounter++, title, content, u);
        if (replies != null) {
            for (String rep : replies) {
                t.addMessage(new Message(idCounter++, "Re: " + title, rep, users.get("admin")));
            }
        }
        cat.addTopic(t);
        allTopics.add(t);
    }

    public User checkUser(String name, String password) {
        User u = users.get(name);
        if (u != null && u.verify(name, password)) {
            return u;
        }
        return null;
    }

    public List<Topic> getTopics() { return allTopics; }

    public Topic getTopic(long id) {
        for (Topic t : allTopics) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public void addNewTopic(String title, String content, User creator) {
        // Mặc định thêm vào category đầu tiên cho đơn giản
        Category cat = categories.get(0);
        Topic t = new Topic(idCounter++, title, content, creator);
        cat.addTopic(t);
        allTopics.add(0, t); // Thêm vào đầu danh sách
    }

    public void addReply(long topicId, String title, String content, User creator) {
        Topic t = getTopic(topicId);
        if (t != null) {
            Message msg = new Message(idCounter++, title, content, creator);
            t.addMessage(msg);
        }
    }
}