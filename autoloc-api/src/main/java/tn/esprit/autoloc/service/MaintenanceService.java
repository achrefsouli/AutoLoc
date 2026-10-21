package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    private final tn.esprit.autoloc.repository.Maintenance maintenanceRepository;
    public MaintenanceService(tn.esprit.autoloc.repository.Maintenance maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return this.maintenanceRepository.save(maintenance);
    }
    public List<Maintenance> findAllMaintenances() {
        return this.maintenanceRepository.findAll();
    }
    public Optional<Maintenance> findMaintenanceById(Long idMaintenance) {
        return this.maintenanceRepository.findById(idMaintenance);
    }
    public Maintenance updateMaintenance(Maintenance maintenance) {
        return this.maintenanceRepository.save(maintenance);
    }
    public void deleteMaintenanceById(Long idMaintenance) {
        this.maintenanceRepository.deleteById(idMaintenance);
    }
    public boolean existsMaintenanceById(Long idMaintenance) {
        return this.maintenanceRepository.existsById(idMaintenance);
    }
}
