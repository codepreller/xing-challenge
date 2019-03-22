package de.xing.model;

public class UserDto {
    final User data;

    public UserDto(User data) {
        this.data = data;
    }

    public User getData() {
        return data;
    }
}