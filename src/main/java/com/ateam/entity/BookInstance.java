package com.ateam.entity;

import javax.persistence.*;

@Entity
@Table(name = "book_instance")
public class BookInstance {
    private Long id;
    private String inventoryNumber;
    private String status;
    private Long bookId;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookInstance that = (BookInstance) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (inventoryNumber != null ? !inventoryNumber.equals(that.inventoryNumber) : that.inventoryNumber != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return bookId != null ? bookId.equals(that.bookId) : that.bookId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (inventoryNumber != null ? inventoryNumber.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (bookId != null ? bookId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookInstance{" +
                "id=" + id +
                ", inventoryNumber='" + inventoryNumber + '\'' +
                ", status='" + status + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
