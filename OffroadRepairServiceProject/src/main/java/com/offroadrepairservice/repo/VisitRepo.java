package com.offroadrepairservice.repo;

import com.offroadrepairservice.model.entity.Part;
import com.offroadrepairservice.model.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Long> {

    List<Visit> findByLicensePlate(String licensePlate);

    List<Visit> findByDateReserved (LocalDate localDate);

}
