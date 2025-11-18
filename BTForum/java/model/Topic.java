package model;
import java.util.Stack;

public class Topic extends Entry {
    private Stack<Message> messages;
    private Category category;

    public Topic(long id, String title, String content, User creator) {
        super(id, title, content, creator);
        this.messages = new Stack<>();
    }

    public void addMessage(Message message) {
        this.messages.push(message);
    }

    public Message getNewMessage() {
        if (!messages.isEmpty()) {
            return messages.peek(); // Lấy bài mới nhất
        }
        return null;
    }

    public Stack<Message> getMessages() { return messages; }
    public void setCategory(Category category) { this.category = category; }
}