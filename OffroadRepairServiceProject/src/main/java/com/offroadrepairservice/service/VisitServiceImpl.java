package com.offroadrepairservice.service;

import com.offroadrepairservice.model.dto.VisitDTO;
import com.offroadrepairservice.model.entity.Part;
import com.offroadrepairservice.model.entity.User;
import com.offroadrepairservice.model.entity.Visit;
import com.offroadrepairservice.repo.UserRepo;
import com.offroadrepairservice.repo.VisitRepo;
import com.offroadrepairservice.util.LoggedUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VisitServiceImpl {
    private VisitRepo repo;
    private UserRepo userRepo;
    private LoggedUser loggedUser;
    private UserServiceImpl userService;


    public VisitServiceImpl(VisitRepo repo, UserRepo userRepo, LoggedUser loggedUser, UserServiceImpl userService){
        this.repo = repo;
        this.userRepo = userRepo;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @Transactional
    public void addVisit(VisitDTO visitDTO){
        Visit visit = new Visit();
        User user = userRepo.getById(loggedUser.getId());
        List<Part>cart = new ArrayList<>();
        cart.addAll(user.getCart());
        loggedUser.setLoggedUserCart(cart);

        visit.setUser(user);
        visit.setCarMake(visitDTO.getCarMake());
        visit.setCarModel(visitDTO.getCarModel());
        visit.setDateReserved(visitDTO.getDateReserved());
        visit.setLicensePlate(visitDTO.getLicensePlate());
        visit.setTotalTime(userService.sumTimeNeededToChange(user.getId()));
        visit.setTotalPrice(userService.sumTotalPrice(user.getId()));
        visit.setReservedParts(loggedUser.getLoggedUserCart());
        this.repo.save(visit);
    }

    public List<Visit> findVisitByLicensePlate(String licensePlate){

        List<Visit> visit = this.repo.findByLicensePlate(licensePlate);
        return visit;
    }

    public Visit findVisitById(Long id){
        return this.repo.findById(id).orElseThrow();
    }

}
