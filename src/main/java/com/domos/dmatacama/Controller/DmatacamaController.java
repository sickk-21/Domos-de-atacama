package com.domos.dmatacama.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domos.dmatacama.Model.DmatacamaModel;
import com.domos.dmatacama.Repository.DmatacamaRepository;

@RestController
@RequestMapping("/api/domos")
@CrossOrigin(origins = "*")
public class DmatacamaController {
    private final DmatacamaRepository dmatacamaRepository;

    public DmatacamaController(DmatacamaRepository dmatacamaRepository) {
        this.dmatacamaRepository = dmatacamaRepository;
    }

    @GetMapping
    public List<DmatacamaModel> listarDomos() {
        return dmatacamaRepository.findAll();
    }
}
