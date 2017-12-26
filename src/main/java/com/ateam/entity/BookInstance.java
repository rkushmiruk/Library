package com.ateam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "book_instance")
public class BookInstance {

    private static final int SIMPLE_NUMBER = 31;
    private Long id;
    private String inventoryNumber;
    private String status;
    private Long bookId;

    public BookInstance() {

    }

    public BookInstance(final String inventoryNumber, final String status, final Long bookId) {
        this.inventoryNumber = inventoryNumber;
        this.status = status;
        this.bookId = bookId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_instance_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "inventory_number")
    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "id_book")
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BookInstance that = (BookInstance) o;

        return bookId != null ? bookId.equals(that.bookId) : that.bookId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = SIMPLE_NUMBER * result + (inventoryNumber != null ? inventoryNumber.hashCode() : 0);
        result = SIMPLE_NUMBER * result + (status != null ? status.hashCode() : 0);
        result = SIMPLE_NUMBER * result + (bookId != null ? bookId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookInstance{");
        sb.append("id=").append(id);
        sb.append(", inventoryNumber='").append(inventoryNumber).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", bookId=").append(bookId);
        sb.append('}');
        return sb.toString();
    }
}
