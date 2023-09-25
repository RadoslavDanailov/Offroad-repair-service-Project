package com.offroadrepairservice.util;

import com.offroadrepairservice.model.entity.Part;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class LoggedUser {

    private Long id;
    private String username;

    private List<Part> loggedUserCart;

    public List<Part> getLoggedUserCart() {
        return loggedUserCart;
    }

    public void setLoggedUserCart(List<Part> loggedUserCart) {
        this.loggedUserCart = loggedUserCart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLogged() {
        return this.username != null && this.id != null;
    }
}
