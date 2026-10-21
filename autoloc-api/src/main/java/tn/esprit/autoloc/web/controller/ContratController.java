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
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.ContratService;

import java.util.List;

@RestController
@RequestMapping("/api/Contrat")
public class ContratController {
    private final ContratService contratService;
    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }
    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.saveContrat(contrat);
    }
    @GetMapping("/getAll")
    public List<Contrat> getAllContrats() {
        return contratService.findAllContrats();
    }
    @GetMapping("/get/{idContrat}")
    public ResponseEntity<Contrat> getContratById(@PathVariable Long idContrat) {
        return contratService.findContratById(idContrat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idContrat}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long idContrat, @RequestBody Contrat contrat) {
        if (!contratService.existsContratById(idContrat)) {
            return ResponseEntity.notFound().build();
        }
        contrat.setIdContrat(idContrat);
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }
    @DeleteMapping("/delete/{idContrat}")
    public ResponseEntity<Void> deleteContrat(@PathVariable Long idContrat) {
        if (!contratService.existsContratById(idContrat)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        contratService.deleteContratById(idContrat);
        return ResponseEntity.noContent().build();
    }
}
