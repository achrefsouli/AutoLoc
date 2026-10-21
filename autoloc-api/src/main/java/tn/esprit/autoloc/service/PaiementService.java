package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {
    private final tn.esprit.autoloc.repository.Paiement paiementRepository;
    public PaiementService(tn.esprit.autoloc.repository.Paiement paiementRepository) {
        this.paiementRepository = paiementRepository;
    }
    public Paiement savePaiement(Paiement paiement) {
        return this.paiementRepository.save(paiement);
    }
    public List<Paiement> findAllPaiements() {
        return this.paiementRepository.findAll();
    }
    public Optional<Paiement> findPaiementById(Long idPaiement) {
        return this.paiementRepository.findById(idPaiement);
    }
    public Paiement updatePaiement(Paiement paiement) {
        return this.paiementRepository.save(paiement);
    }
    public void deletePaiementById(Long idPaiement) {
        this.paiementRepository.deleteById(idPaiement);
    }
    public boolean existsPaiementById(Long idPaiement) {
        return this.paiementRepository.existsById(idPaiement);
    }
}
