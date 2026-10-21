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
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.MaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/Maintenance")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }
    @PostMapping("/add")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.saveMaintenance(maintenance);
    }
    @GetMapping("/getAll")
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.findAllMaintenances();
    }
    @GetMapping("/get/{idMaintenance}")
    public ResponseEntity<Maintenance> getMaintenanceById(@PathVariable Long idMaintenance) {
        return maintenanceService.findMaintenanceById(idMaintenance)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idMaintenance}")
    public ResponseEntity<Maintenance> updateMaintenance(@PathVariable Long idMaintenance, @RequestBody Maintenance maintenance) {
        if (!maintenanceService.existsMaintenanceById(idMaintenance)) {
            return ResponseEntity.notFound().build();
        }
        maintenance.setIdMaintenance(idMaintenance);
        return ResponseEntity.ok(maintenanceService.updateMaintenance(maintenance));
    }
    @DeleteMapping("/delete/{idMaintenance}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long idMaintenance) {
        if (!maintenanceService.existsMaintenanceById(idMaintenance)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        maintenanceService.deleteMaintenanceById(idMaintenance);
        return ResponseEntity.noContent().build();
    }
}
