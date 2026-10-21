package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {
    private final tn.esprit.autoloc.repository.Vehicule vehiculeRepository;
    public VehiculeService(tn.esprit.autoloc.repository.Vehicule vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
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
}
