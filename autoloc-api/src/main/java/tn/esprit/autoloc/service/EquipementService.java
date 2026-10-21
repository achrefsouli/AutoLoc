package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService {
    private final tn.esprit.autoloc.repository.Equipement equipementRepository;
    public EquipementService(tn.esprit.autoloc.repository.Equipement equipementRepository) {
        this.equipementRepository = equipementRepository;
    }
    public Equipement saveEquipement(Equipement equipement) {
        return this.equipementRepository.save(equipement);
    }
    public List<Equipement> findAllEquipements() {
        return this.equipementRepository.findAll();
    }
    public Optional<Equipement> findEquipementById(Long idEquipement) {
        return this.equipementRepository.findById(idEquipement);
    }
    public Equipement updateEquipement(Equipement equipement) {
        return this.equipementRepository.save(equipement);
    }
    public void deleteEquipementById(Long idEquipement) {
        this.equipementRepository.deleteById(idEquipement);
    }
    public boolean existsEquipementById(Long idEquipement) {
        return this.equipementRepository.existsById(idEquipement);
    }
}
