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
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.EquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/Equipement")
public class EquipementController {
    private final EquipementService equipementService;
    public EquipementController(EquipementService equipementService) {
        this.equipementService = equipementService;
    }
    @PostMapping("/add")
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.saveEquipement(equipement);
    }
    @GetMapping("/getAll")
    public List<Equipement> getAllEquipements() {
        return equipementService.findAllEquipements();
    }
    @GetMapping("/get/{idEquipement}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long idEquipement) {
        return equipementService.findEquipementById(idEquipement)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idEquipement}")
    public ResponseEntity<Equipement> updateEquipement(@PathVariable Long idEquipement, @RequestBody Equipement equipement) {
        if (!equipementService.existsEquipementById(idEquipement)) {
            return ResponseEntity.notFound().build();
        }
        equipement.setIdEquipement(idEquipement);
        return ResponseEntity.ok(equipementService.updateEquipement(equipement));
    }
    @DeleteMapping("/delete/{idEquipement}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long idEquipement) {
        if (!equipementService.existsEquipementById(idEquipement)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        equipementService.deleteEquipementById(idEquipement);
        return ResponseEntity.noContent().build();
    }
}
