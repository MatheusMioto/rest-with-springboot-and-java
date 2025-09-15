package br.com.erudio.integrationtests.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@XmlRootElement
public class BookDTOV1 implements Serializable {

    private Long id;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    public BookDTOV1() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookDTOV1 bookDTOV1)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), bookDTOV1.getId()) && Objects.equals(getAuthor(), bookDTOV1.getAuthor()) && Objects.equals(getLaunchDate(), bookDTOV1.getLaunchDate()) && Objects.equals(getPrice(), bookDTOV1.getPrice()) && Objects.equals(getTitle(), bookDTOV1.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getLaunchDate(), getPrice(), getTitle());
    }
}



