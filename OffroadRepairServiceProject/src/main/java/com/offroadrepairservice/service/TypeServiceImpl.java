package com.offroadrepairservice.service;

import com.offroadrepairservice.model.entity.PartTypes;
import com.offroadrepairservice.model.entity.Type;
import com.offroadrepairservice.repo.TypeRepo;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class TypeServiceImpl implements TypeService{

    private final TypeRepo repo;

    public TypeServiceImpl(TypeRepo repo) {
        this.repo = repo;
    }


    @Override
    public void initType() {
        if (this.repo.count() != 0){
            return;
        }
        Arrays.stream(PartTypes.values()).
                forEach(type1 -> {
                    Type type = new Type();
                    type.setTypeName(type1);
                    type.setDescription("...");

                    this.repo.save(type);
                });
    }

    @Override
    public Type findType(PartTypes type) {
        return this.repo.findByTypeName(type).orElseThrow();
    }

    @Override
    public Type findTypeByTypeName(PartTypes typeName) {
        return this.repo.findByTypeName(typeName).orElseThrow();
    }
}
