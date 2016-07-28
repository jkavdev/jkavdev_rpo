package br.com.jkavdev.k19.jpa_hibernate.test;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Reserva;

public class AttributeConverterTest extends AbstractJUnitConfig{
	
	@Test
	public void adicionaReservaTest(){
		
		Reserva reserva = new Reserva();
		reserva.setInicio(LocalDate.of(2015, Month.AUGUST, 3));
		reserva.setTermino(LocalDate.of(2015, Month.AUGUST, 14));
		
		beginTransaction();
		
		this.getManager().persist(reserva);
		
		commit();
		
	}
	
	@Test
	public void selectReserva(){
		
		Reserva reserva = this.getManager().find(Reserva.class, 4L);
		
		System.out.println(reserva.getInicio());
		System.out.println(reserva.getTermino());
		
	}

}
