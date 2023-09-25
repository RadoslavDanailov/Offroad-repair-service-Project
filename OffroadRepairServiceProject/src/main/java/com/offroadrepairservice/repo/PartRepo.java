package com.offroadrepairservice.repo;

import com.offroadrepairservice.model.entity.Part;
import com.offroadrepairservice.model.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
@Repository
public interface PartRepo extends JpaRepository<Part, Long> {


    Set<Part> findPartByType(Type type);

    Optional<Part> findByManufacturer(String manufacturer);


    @Query("select p, u from Part p join p.user u on u.id = :id")
    Set<Part>findAllByUserId(@Param("id") Long id);


}
