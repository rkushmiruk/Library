package com.ateam.dto;

public class CredentialsDto {

    private String email;
    private String password;

    public CredentialsDto() {
    }

    public CredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CredentialsDto [ [super: ").append(super.toString()).append("], email=").append(email)
            .append(", password=").append(password).append("] ");
        return builder.toString();
    }
}
