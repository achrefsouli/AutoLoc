package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.VehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/Vehicule")
public class VehiculeController {
    private final VehiculeService vehiculeService;
    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }
    @PostMapping("/add")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.saveVehicule(vehicule);
    }
    @GetMapping("/getAll")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.findAllVehicules();
    }
    @GetMapping("/get/{idVehicule}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long idVehicule) {
        return vehiculeService.findVehiculeById(idVehicule)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idVehicule}")
    public ResponseEntity<Vehicule> updateVehicule(@PathVariable Long idVehicule, @RequestBody Vehicule vehicule) {
        if (!vehiculeService.existsVehiculeById(idVehicule)) {
            return ResponseEntity.notFound().build();
        }
        vehicule.setIdVehicule(idVehicule);
        return ResponseEntity.ok(vehiculeService.updateVehicule(vehicule));
    }
    @DeleteMapping("/delete/{idVehicule}")
    public ResponseEntity<Void> deleteVehicule(@PathVariable Long idVehicule) {
        if (!vehiculeService.existsVehiculeById(idVehicule)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        vehiculeService.deleteVehiculeById(idVehicule);
        return ResponseEntity.noContent().build();
    }
}
