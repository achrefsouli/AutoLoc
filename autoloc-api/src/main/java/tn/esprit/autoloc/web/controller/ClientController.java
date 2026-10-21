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
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }
    @GetMapping("/getAll")
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }
    @GetMapping("/get/{idClient}")
    public ResponseEntity<Client> getClientById(@PathVariable Long idClient) {
        return clientService.findClientById(idClient)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{idClient}")
    public ResponseEntity<Client> updateClient(@PathVariable Long idClient, @RequestBody Client client) {
        if (!clientService.existsClientById(idClient)) {
            return ResponseEntity.notFound().build();
        }
        client.setIdClient(idClient);
        return ResponseEntity.ok(clientService.updateClient(client));
    }
    @DeleteMapping("/delete/{idClient}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient) {
        if (!clientService.existsClientById(idClient)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        clientService.deleteClientById(idClient);
        return ResponseEntity.noContent().build();
    }
}
