package com.ateam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    private static final int SIMPLE_NUMBER = 31;
    private Long id;
    private String isbn;
    private String title;
    private String publisher;
    private String availability;
    private Set<Author> authors;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "publisher")
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Column(name = "availability")
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        return availability != null ? availability.equals(book.availability) : book.availability == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = SIMPLE_NUMBER * result + (isbn != null ? isbn.hashCode() : 0);
        result = SIMPLE_NUMBER * result + (title != null ? title.hashCode() : 0);
        result = SIMPLE_NUMBER * result + (publisher != null ? publisher.hashCode() : 0);
        result = SIMPLE_NUMBER * result + (availability != null ? availability.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", publisher='").append(publisher).append('\'');
        sb.append(", availability='").append(availability).append('\'');
        sb.append(", authors=").append(authors);
        sb.append('}');
        return sb.toString();
    }
}
