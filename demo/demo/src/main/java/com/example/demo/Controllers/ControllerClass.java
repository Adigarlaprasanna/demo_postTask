package com.example.demo.Controllers;

import com.example.demo.Entities.Entity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/demo")

public class ControllerClass{
    @PostMapping("/data")
    public Entity data() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("data.json");
        File file = classPathResource.getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        Entity entity = objectMapper.readValue(file, Entity.class);
        return entity;
    }
    @PostMapping("/getdata")
    public List<Entity> dataDetails() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("DataFile.json");
        File file = classPathResource.getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        List<Entity> listOfEntities = objectMapper.readValue(file, new TypeReference<List<Entity>>() {});

        return listOfEntities;
    }

}
