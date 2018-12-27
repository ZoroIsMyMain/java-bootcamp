package com.client.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.api.model.Client;
import com.client.api.repository.ClientRepository;

@Service
public class ClientService {

	 private final ClientRepository repository;
	 
	 @Autowired
	 public ClientService(final ClientRepository repository) {
		 this.repository = repository;
	 }
	 public List<Client> findAllClient(){
		 return repository.findAll();
	 }
	 public Client findClientById(final Long id){
		 return repository.findById(id).orElse(null);
	 
	 }
	 
	 public Client findClientByName(final String firstName) {
		List<Client> lisClient = repository.findAll();
		for(Client cli: lisClient) {
			if (cli.getFirstName().equals(firstName)) {
				return cli;
			}
		}
		return null;
	 }
	 
	 public Client findClientByNickName(final String nickName) {
		 List<Client> lisClient = repository.findAll();
		 for(Client cli : lisClient) {
			 if (cli.getNickName().equals(nickName)) {
				 return cli;
			}
		 }
		 return null;
	 }
	 
	 public Client createClient(final Client cli) {
		 cli.setIdClient(null);
		 return repository.save(cli);
	 }
	 
	 public Client updateClient(final Client clien) {
		 List<Client> lisClient = repository.findAll();
		 for(Client cli : lisClient) {
			 if (cli.getIdClient()==clien.getIdClient()){
				 cli.setFirstName(clien.getFirstName());
				 cli.setLastName(clien.getLastName());
				 cli.setNickName(clien.getNickName());
				 cli.setPassword(clien.getPassword());
				 return cli;				 	
			}
		 }
		 return null;
	 }
	 
	 public void deleteClient(final Client cli) {
		 repository.delete(cli);
		 
	 }
	 
}