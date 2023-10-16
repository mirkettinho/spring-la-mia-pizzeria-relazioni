package org.java.app;



import java.time.LocalDate;

import org.java.app.pizzeria.pojo.Offerte;
import org.java.app.pizzeria.pojo.Pizza;
import org.java.app.pizzeria.serv.OffertaServ;
import org.java.app.pizzeria.serv.PizzaServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{

	@Autowired
	private PizzaServ pizzaServ;
	
	@Autowired
	private OffertaServ offertaServ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza pizza1 = new Pizza("Margherita", "descrizione", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 5);
		Pizza pizza2 = new Pizza("Margherita2", "descrizione", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 5);
		Pizza pizza3 = new Pizza("Margherita3", "descrizione", "https://images.prismic.io/eataly-us/ed3fcec7-7994-426d-a5e4-a24be5a95afd_pizza-recipe-main.jpg?auto=compress,format", 5);
		
		pizzaServ.save(pizza1);
		pizzaServ.save(pizza2);
		pizzaServ.save(pizza3);
		
		
		Offerte offerta1 = new Offerte("-1%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza1 );
		Offerte offerta2 = new Offerte("-2%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza1 );
		Offerte offerta3 = new Offerte("-3%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza2 );
		Offerte offerta4 = new Offerte("-4%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza2 );
		Offerte offerta5 = new Offerte("-5%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza3 );
		Offerte offerta6 = new Offerte("-5%", LocalDate.now(), LocalDate.parse("2023-01-01"), pizza3 );
		
		offertaServ.save(offerta1 );
		offertaServ.save(offerta2 );
		offertaServ.save(offerta3 );
		offertaServ.save(offerta4 );
		offertaServ.save(offerta5 );
		offertaServ.save(offerta6 );
	}

}
