package com.ateam.entity;

public enum Role {
    LIBRARIAN, READER;

    Role() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append('}');
        return sb.toString();
    }
}
