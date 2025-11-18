package model;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private String title;
    private List<Topic> topics = new ArrayList<>();

    public Category(String title) { this.title = title; }
    
    public void addTopic(Topic topic) {
        this.topics.add(topic);
        topic.setCategory(this);
    }
    
    public List<Topic> getTopics() { return topics; }
    public String getTitle() { return title; }
}