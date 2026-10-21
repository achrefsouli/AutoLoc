package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;

import java.util.List;
import java.util.Optional;

@Service
public class ContratService {
    private final tn.esprit.autoloc.repository.Contrat contratRepository;
    public ContratService(tn.esprit.autoloc.repository.Contrat contratRepository) {
        this.contratRepository = contratRepository;
    }
    public Contrat saveContrat(Contrat contrat) {
        return this.contratRepository.save(contrat);
    }
    public List<Contrat> findAllContrats() {
        return this.contratRepository.findAll();
    }
    public Optional<Contrat> findContratById(Long idContrat) {
        return this.contratRepository.findById(idContrat);
    }
    public Contrat updateContrat(Contrat contrat) {
        return this.contratRepository.save(contrat);
    }
    public void deleteContratById(Long idContrat) {
        this.contratRepository.deleteById(idContrat);
    }
    public boolean existsContratById(Long idContrat) {
        return this.contratRepository.existsById(idContrat);
    }
}
