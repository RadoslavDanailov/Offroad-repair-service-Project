package com.offroadrepairservice.service;

import com.offroadrepairservice.model.entity.PartTypes;
import com.offroadrepairservice.model.entity.Type;

public interface TypeService {

    void initType();

    Type findType(PartTypes type);

    Type findTypeByTypeName(PartTypes typeName);

}
