package com.offroadrepairservice.repo;

import com.offroadrepairservice.model.entity.PartTypes;
import com.offroadrepairservice.model.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {

    Optional<Type>findByTypeName(PartTypes type);

}
