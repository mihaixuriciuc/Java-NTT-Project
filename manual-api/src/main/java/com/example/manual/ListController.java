package com.example.manual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ListController {
    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public List<Pets> getAll(@RequestParam(required = false) String type,
                              @RequestParam(defaultValue = "name") String sort,
                              @RequestParam(defaultValue = "cresc") String order) {
        return petService.processPets(type,sort,order);
    }
}