package com.domos.dmatacama.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @PutMapping("/{id}/estado")
public DmatacamaModel cambiarEstadoDomo(@PathVariable Long id, @RequestParam String nuevoEstado) {

    DmatacamaModel domo = dmatacamaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Domo no encontrado con el ID: " + id));
    

    domo.setEstado(nuevoEstado);
    

    return dmatacamaRepository.save(domo);
}

    @PutMapping("/{id}/reservar")
    public DmatacamaModel reservarDomo(@PathVariable Long id, @RequestParam String cliente, @RequestParam int personas) {
        DmatacamaModel domo = dmatacamaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Domo no encontrado"));
        
        if (!domo.getEstado().equals("Disponible")) {
            throw new IllegalArgumentException("El domo no está disponible para reservar.");
        }
        
        // Aplicar la reserva
        domo.setEstado("Ocupado");
        domo.setCliente(cliente);
        domo.setPersonasReserva(personas);
        
        return dmatacamaRepository.save(domo);
    }

    @GetMapping
    public List<DmatacamaModel> listarDomos() {
        return dmatacamaRepository.findAll();
    }
}
