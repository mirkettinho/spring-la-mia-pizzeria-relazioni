package org.java.app.pizzeria.serv;

import java.util.List;

import org.java.app.pizzeria.pojo.Offerta;
import org.java.app.pizzeria.repo.OffertaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaServ {
	
	@Autowired
	private OffertaRepo offertaRepo;
	
	public void save(Offerta offerta) {
		
		offertaRepo.save(offerta);
	}
	
	public List<Offerta> findAll() {
		
		return offertaRepo.findAll();
	}
	
	public Offerta findById(Integer id) {
		
		return offertaRepo.findById(id).get();
	}
}
