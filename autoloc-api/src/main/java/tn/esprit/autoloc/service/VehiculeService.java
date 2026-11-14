package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {
    private final tn.esprit.autoloc.repository.Vehicule vehiculeRepository;
    private final tn.esprit.autoloc.repository.Agence agenceRepository;
    private final tn.esprit.autoloc.repository.Equipement equipementRepository;

    public VehiculeService(tn.esprit.autoloc.repository.Vehicule vehiculeRepository,
                           tn.esprit.autoloc.repository.Agence agenceRepository,
                           tn.esprit.autoloc.repository.Equipement equipementRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.agenceRepository = agenceRepository;
        this.equipementRepository = equipementRepository;
    }
    public Vehicule saveVehicule(Vehicule vehicule) {
        return this.vehiculeRepository.save(vehicule);
    }
    public List<Vehicule> findAllVehicules() {
        return this.vehiculeRepository.findAll();
    }
    public Optional<Vehicule> findVehiculeById(Long idVehicule) {
        return this.vehiculeRepository.findById(idVehicule);
    }
    public Vehicule updateVehicule(Vehicule vehicule) {
        return this.vehiculeRepository.save(vehicule);
    }
    public void deleteVehiculeById(Long idVehicule) {
        this.vehiculeRepository.deleteById(idVehicule);
    }
    public boolean existsVehiculeById(Long idVehicule) {
        return this.vehiculeRepository.existsById(idVehicule);
    }

    public Vehicule affecterVehicule(Long idVehicule, Long idAgence) {
        Vehicule vehicule = this.vehiculeRepository.findById(idVehicule).orElse(null);
        Agence agence = this.agenceRepository.findById(idAgence).orElse(null);
        if (vehicule != null && agence != null) {
            vehicule.setAgence(agence);
            return this.vehiculeRepository.save(vehicule);
        }
        return null;
    }

    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = this.vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = this.equipementRepository.findById(idEquipement).orElse(null);
        if (vehicule != null && equipement != null) {
            if (vehicule.getEquipements() == null) {
                vehicule.setEquipements(new HashSet<>());
            }
            vehicule.getEquipements().add(equipement);
            return this.vehiculeRepository.save(vehicule);
        }
        return null;
    }

    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = this.vehiculeRepository.findById(idVehicule).orElse(null);
        Equipement equipement = this.equipementRepository.findById(idEquipement).orElse(null);
        if (vehicule != null && equipement != null && vehicule.getEquipements() != null) {
            vehicule.getEquipements().removeIf(eq -> eq.getIdEquipement() != null && eq.getIdEquipement().equals(idEquipement));
            return this.vehiculeRepository.save(vehicule);
        }
        return null;
    }
}
