package br.com.jkavdev.persistence.test;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.id.Book;
import br.com.jkavdev.persistence.model.id.Country;
import br.com.jkavdev.persistence.model.id.Guest;
import br.com.jkavdev.persistence.model.id.Hotel;
import br.com.jkavdev.persistence.model.id.HotelRooms;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class TestHibernateUtil {

	// private EntityManagerFactory factory =
	// Persistence.createEntityManagerFactory("jpaPostgresPU");
	private EntityManager manager;

	@Before
	public void setUp() {
		this.manager = JpaUtil.geEntityManager();
	}

	@After
	public void tearDown() {
		JpaUtil.close();
	}

	@Test
	public void testInsertEntityManager() {

		// Estacionamento estacionamento = new Estacionamento();

		this.manager.getTransaction().begin();
		// this.manager.persist(estacionamento);
		this.manager.getTransaction().commit();
	}

	@Test
	public void testInsertEntityManagerTry() {

		// Estacionamento estacionamento = new Estacionamento();
		try {
			this.manager.getTransaction().begin();
			// this.manager.persist(estacionamento);
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			if (this.manager.isOpen()) {
				this.manager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (this.manager.isOpen()) {
				this.manager.close();
			}
		}
	}

	@Test
	public void testEntityDetais() {
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
	}

	@Test
	public void testIdentityId() {
		Guest guest = new Guest();
		guest.setAddress("Qr 12 Casa 15");
		guest.setCity("Panaltina");
		guest.setName("Jhonatan");

		this.manager.getTransaction().begin();
		this.manager.persist(guest);
		this.manager.getTransaction().commit();
	}

	@Test
	public void testSequenceId() {
		Hotel hotel = new Hotel();
		hotel.setAddress("Qr 12 Casa 15");
		hotel.setName("Plaza Hotel");
		hotel.setPostCode("73734012");

		this.manager.getTransaction().begin();
		this.manager.persist(hotel);
		this.manager.getTransaction().commit();
	}

	@Test
	public void testTableId() {
		Country country = new Country();
		country.setName("Brazil");
		country.setCurrency("REAL");

		HotelRooms rooms = new HotelRooms();
		rooms.setRoomFloor("4th floor");
		rooms.setRoomNumber(1554);
		rooms.setRoomFloorCount("55");

		HotelRooms rooms1 = new HotelRooms();
		rooms1.setRoomFloor("3th floor");
		rooms1.setRoomNumber(1254);
		rooms1.setRoomFloorCount("44");

		this.manager.getTransaction().begin();
		this.manager.persist(country);
		this.manager.persist(rooms);
		this.manager.persist(rooms1);
		this.manager.getTransaction().commit();
	}

	@Test
	public void testAutoId() {
		Book book = new Book();
		book.setDateFrom(Calendar.getInstance());
		book.setDateTo(Calendar.getInstance());
		
		Book book1 = new Book();
		book1.setDateFrom(Calendar.getInstance());
		book1.setDateTo(Calendar.getInstance());

		this.manager.getTransaction().begin();
		this.manager.persist(book);
		this.manager.persist(book1);
		this.manager.getTransaction().commit();
	}

}
