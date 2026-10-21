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
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.PaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/Paiement")
public class PaiementController {
    private final PaiementService paiementService;
    public PaiementController(PaiementService paiementService) {
        this.paiementService = paiementService;
    }
    @PostMapping("/add")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.savePaiement(paiement);
    }
    @GetMapping("/getAll")
    public List<Paiement> getAllPaiements() {
        return paiementService.findAllPaiements();
    }
    @GetMapping("/get/{idPaiement}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable Long idPaiement) {
        return paiementService.findPaiementById(idPaiement)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idPaiement}")
    public ResponseEntity<Paiement> updatePaiement(@PathVariable Long idPaiement, @RequestBody Paiement paiement) {
        if (!paiementService.existsPaiementById(idPaiement)) {
            return ResponseEntity.notFound().build();
        }
        paiement.setIdPaiement(idPaiement);
        return ResponseEntity.ok(paiementService.updatePaiement(paiement));
    }
    @DeleteMapping("/delete/{idPaiement}")
    public ResponseEntity<Void> deletePaiement(@PathVariable Long idPaiement) {
        if (!paiementService.existsPaiementById(idPaiement)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        paiementService.deletePaiementById(idPaiement);
        return ResponseEntity.noContent().build();
    }
}
