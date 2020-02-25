package be.ehb.notedroid.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements Serializable {

    private String title;
    private String content;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfAjustment;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.dateOfCreation = LocalDateTime.now();
        this.dateOfAjustment = LocalDateTime.now();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getDateOfAjustment() {
        return dateOfAjustment;
    }

    public void setDateOfAjustment(LocalDateTime dateOfAjustment) {
        this.dateOfAjustment = dateOfAjustment;
    }
}
