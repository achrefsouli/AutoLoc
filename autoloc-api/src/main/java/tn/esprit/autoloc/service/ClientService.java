package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final tn.esprit.autoloc.repository.Client clientRepository;
    public ClientService(tn.esprit.autoloc.repository.Client clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client saveClient(Client client) {
        return this.clientRepository.save(client);
    }
    public List<Client> findAllClients() {
        return this.clientRepository.findAll();
    }
    public Optional<Client> findClientById(Long idClient) {
        return this.clientRepository.findById(idClient);
    }
    public Client updateClient(Client client) {
        return this.clientRepository.save(client);
    }
    public void deleteClientById(Long idClient) {
        this.clientRepository.deleteById(idClient);
    }
    public boolean existsClientById(Long idClient) {
        return this.clientRepository.existsById(idClient);
    }
}
