package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceService {
    private final tn.esprit.autoloc.repository.Agence agenceRepository;
    public AgenceService(tn.esprit.autoloc.repository.Agence agenceRepository) {
        this.agenceRepository = agenceRepository;
    }
    public Agence saveAgence(Agence agence) {
        return this.agenceRepository.save(agence);
    }
    public List<Agence> findAllAgences() {
        return this.agenceRepository.findAll();
    }
    public Optional<Agence> findAgenceById(Long idAgence) {
        return this.agenceRepository.findById(idAgence);
    }
    public Agence updateAgence(Agence agence) {
        return this.agenceRepository.save(agence);
    }
    public void deleteAgenceById(Long idAgence) {
        this.agenceRepository.deleteById(idAgence);
    }
    public boolean existsAgenceById(Long idAgence) {
        return this.agenceRepository.existsById(idAgence);
    }
}
