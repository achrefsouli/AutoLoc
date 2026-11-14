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
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/Employe")
public class EmployeController {
    private final EmployeService employeService;
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }
    @PostMapping("/add")
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }
    @GetMapping("/getAll")
    public List<Employe> getAllEmployes() {
        return employeService.findAllEmployes();
    }
    @GetMapping("/get/{idEmploye}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable Long idEmploye) {
        return employeService.findEmployeById(idEmploye)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idEmploye}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable Long idEmploye, @RequestBody Employe employe) {
        if (!employeService.existsEmployeById(idEmploye)) {
            return ResponseEntity.notFound().build();
        }
        employe.setIdEmploye(idEmploye);
        return ResponseEntity.ok(employeService.updateEmploye(employe));
    }
    @DeleteMapping("/delete/{idEmploye}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long idEmploye) {
        if (!employeService.existsEmployeById(idEmploye)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        employeService.deleteEmployeById(idEmploye);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/desaffecter/{idEmploye}")
    public ResponseEntity<Employe> desaffecterEmploye(@PathVariable Long idEmploye) {
        Employe employe = employeService.desaffecterEmploye(idEmploye);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employe);
    }

    @PutMapping("/affecter/{idEmploye}/{idAgence}")
    public ResponseEntity<Employe> affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        Employe employe = employeService.affecterEmploye(idEmploye, idAgence);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employe);
    }
}
