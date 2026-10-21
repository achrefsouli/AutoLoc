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
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.AgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/Agence")
public class AgenceController {
    private final AgenceService agenceService;
    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }
    @PostMapping("/add")
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.saveAgence(agence);
    }
    @GetMapping("/getAll")
    public List<Agence> getAllAgences() {
        return agenceService.findAllAgences();
    }
    @GetMapping("/get/{idAgence}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable Long idAgence) {
        return agenceService.findAgenceById(idAgence)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idAgence}")
    public ResponseEntity<Agence> updateAgence(@PathVariable Long idAgence, @RequestBody Agence agence) {
        if (!agenceService.existsAgenceById(idAgence)) {
            return ResponseEntity.notFound().build();
        }
        agence.setIdAgence(idAgence);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }
    @DeleteMapping("/delete/{idAgence}")
    public ResponseEntity<Void> deleteAgence(@PathVariable Long idAgence) {
        if (!agenceService.existsAgenceById(idAgence)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        agenceService.deleteAgenceById(idAgence);
        return ResponseEntity.noContent().build();
    }
}
