package com.ateam.dto;

public class BookDto {

    private String isbn;
    private String title;
    private String publisher;

    private String[] authorsIds;

    public BookDto() {
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthorsIds() {
        return authorsIds;
    }

    public void setAuthorsIds(String[] authorsIds) {
        this.authorsIds = authorsIds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        BookDto book = (BookDto) obj;

        return ((isbn != null) ? isbn.equals(book.isbn) : book.isbn == null);
    }

    @Override
    public String toString() {
        StringBuilder builder2 = new StringBuilder();
        builder2.append("BookDto [ [super: ").append(super.toString()).append("], isbn=").append(isbn)
            .append(", title=").append(title).append(", publisher=").append(publisher);
        return builder2.toString();
    }
}