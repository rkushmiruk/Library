package com.ateam.dto;

public class ChangePasswordDto {

    private Long userId;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    public ChangePasswordDto() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmNewPassword) {
        this.confirmPassword = confirmNewPassword;
    }

    @Override
    public String toString() {
        StringBuilder builder2 = new StringBuilder();
        builder2.append("ChangePasswordDto [ [super: ").append(super.toString()).append("], userId=").append(userId)
            .append(", oldPassword=").append(oldPassword).append(", newPassword=").append(newPassword)
            .append(", confirmPassword=").append(confirmPassword).append("] ");
        return builder2.toString();
    }
}
