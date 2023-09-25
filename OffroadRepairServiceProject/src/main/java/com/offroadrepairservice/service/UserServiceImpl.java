package com.offroadrepairservice.service;

import com.offroadrepairservice.model.dto.UserDTO;
import com.offroadrepairservice.model.entity.Part;
import com.offroadrepairservice.util.LoggedUser;
import com.offroadrepairservice.model.dto.RegisterDTO;
import com.offroadrepairservice.model.entity.User;
import com.offroadrepairservice.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Set;

@Service
public class UserServiceImpl {

    private final UserRepo repo;
    private final PasswordEncoder encoder;
    private final LoggedUser loggedUser;
    private final HttpSession session;

    public UserServiceImpl(UserRepo repo, PasswordEncoder encoder, LoggedUser loggedUser, HttpSession session) {
        this.repo = repo;
        this.encoder = encoder;
        this.loggedUser = loggedUser;
        this.session = session;
    }

    public UserDTO findUserByUsername(String username) {
        User user = this.getUserByUsername(username);
        if (user == null) {
            return null;
        }

        return this.mapUserDTO(user);
    }

    public UserDTO findUserByEmail(String email) {
        User user = repo.findByEmail(email).orElse(null);
        if (user == null) {
            return null;
        }

        return this.mapUserDTO(user);
    }

    public boolean checkCredentials(String username, String password) {
        User user = this.getUserByUsername(username);

        if (user == null) {
            return false;
        }

        return encoder.matches(password, user.getPassword());
    }

    public void login(String username) {
        User user = this.getUserByUsername(username);
        this.loggedUser.setId(user.getId());
        this.loggedUser.setUsername(user.getUsername());
//        this.loggedUser.setLoggedUserCart(user.getCart());
    }

    public void register(RegisterDTO registerDTO) {
        this.repo.save(this.mapUser(registerDTO));
        this.login(registerDTO.getUsername());
    }

    public void logout() {
        this.session.invalidate();
        this.loggedUser.setId(null);
        this.loggedUser.setUsername(null);
    }

    public void addPartToUser(Long userId, Part part){
        User user = this.getUserById(userId);
        if (user.getCart().stream().noneMatch(p -> p.getId().equals(part.getId()))){
            user.addPartToCart(part);

            this.repo.save(user);
        }
    }

    public void removePartFromUser(Long userId, Long partId){
        User user = getUserById(userId);
        user.removePartFromCart(partId);
        this.repo.save(user);
    }

    public void deleteAllParts(Long userId){
        User user = getUserById(userId);
        user.deleteAllPartsFromCart();
        this.repo.save(user);
    }


    private User getUserById(Long userId) {
        return this.repo.findById(userId).orElseThrow();
    }

    private User getUserByUsername(String username) {
        return this.repo.findByUsername(username).orElse(null);
    }

    private User mapUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(encoder.encode(registerDTO.getPassword()));
        return user;
    }

    private UserDTO mapUserDTO(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setEmail(user.getEmail())
                .setUsername(user.getUsername());
    }

    public Long sumTimeNeededToChange(Long userId) {
        User user = getUserById(userId);

        if (user != null && user.getCart() != null) {
            long sum = user.getCart().stream()
                    .mapToLong(Part::getTimeNeededToChange)
                    .sum();
            Long sumInMinutes = sum / 60;
            return sumInMinutes;
        }
        else return 0L;
    }

    public BigDecimal sumTotalPrice(Long userId){
        User user = getUserById(userId);
        Set<Part>cart = user.getCart();

        if (user.getCart() != null) {
            BigDecimal totalPrice = BigDecimal.ZERO;

            for (Part part : cart){
                if (part.getPrice() != null){
                    totalPrice = totalPrice.add(part.getPrice());
                }
            }
            return totalPrice;
        }
      return null;
    }
}
