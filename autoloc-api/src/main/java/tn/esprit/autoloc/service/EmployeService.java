package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final tn.esprit.autoloc.repository.Employe employeRepository;
    private final tn.esprit.autoloc.repository.Agence agenceRepository;

    public EmployeService(tn.esprit.autoloc.repository.Employe employeRepository,
                          tn.esprit.autoloc.repository.Agence agenceRepository) {
        this.employeRepository = employeRepository;
        this.agenceRepository = agenceRepository;
    }
    public Employe saveEmploye(Employe employe) {
        return this.employeRepository.save(employe);
    }
    public List<Employe> findAllEmployes() {
        return this.employeRepository.findAll();
    }
    public Optional<Employe> findEmployeById(Long idEmploye) {
        return this.employeRepository.findById(idEmploye);
    }
    public Employe updateEmploye(Employe employe) {
        return this.employeRepository.save(employe);
    }
    public void deleteEmployeById(Long idEmploye) {
        this.employeRepository.deleteById(idEmploye);
    }
    public boolean existsEmployeById(Long idEmploye) {
        return this.employeRepository.existsById(idEmploye);
    }

    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = this.employeRepository.findById(idEmploye).orElse(null);
        if (employe != null) {
            employe.setAgence(null);
            return this.employeRepository.save(employe);
        }
        return null;
    }

    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = this.employeRepository.findById(idEmploye).orElse(null);
        Agence agence = this.agenceRepository.findById(idAgence).orElse(null);
        if (employe != null && agence != null) {
            employe.setAgence(agence);
            return this.employeRepository.save(employe);
        }
        return null;
    }
}
