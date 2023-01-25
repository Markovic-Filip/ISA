package isa.isa.user.dto;

public class AuthenticatedDTO {

    private String role;
    private String username;
    private UserTokenState token;

    public AuthenticatedDTO(){}

    public AuthenticatedDTO(String role, String username, UserTokenState token) {
        this.role = role;
        this.username = username;
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserTokenState getToken() {
        return token;
    }

    public void setToken(UserTokenState token) {
        this.token = token;
    }
}
