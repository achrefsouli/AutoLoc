package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final tn.esprit.autoloc.repository.Employe employeRepository;
    public EmployeService(tn.esprit.autoloc.repository.Employe employeRepository) {
        this.employeRepository = employeRepository;
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
}
