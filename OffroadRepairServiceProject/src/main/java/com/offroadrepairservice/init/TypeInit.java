package com.offroadrepairservice.init;

import com.offroadrepairservice.service.TypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TypeInit implements CommandLineRunner {

    private final TypeService typeService;

    public TypeInit(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public void run(String... args) {
        this.typeService.initType();
    }
}
