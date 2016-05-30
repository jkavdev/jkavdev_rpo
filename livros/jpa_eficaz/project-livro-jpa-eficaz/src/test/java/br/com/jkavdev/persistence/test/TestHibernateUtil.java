package br.com.jkavdev.persistence.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.persistence.model.Employee;
import br.com.jkavdev.persistence.model.id.Book;
import br.com.jkavdev.persistence.model.id.Country;
import br.com.jkavdev.persistence.model.id.Guest;
import br.com.jkavdev.persistence.model.id.Hotel;
import br.com.jkavdev.persistence.model.id.HotelRooms;
import br.com.jkavdev.persistence.model.id.composite.Album;
import br.com.jkavdev.persistence.model.id.composite.AlbumIdClass;
import br.com.jkavdev.persistence.model.id.composite.Department;
import br.com.jkavdev.persistence.model.id.composite.DepartmentId;
import br.com.jkavdev.persistence.model.id.composite.Project;
import br.com.jkavdev.persistence.model.id.composite.UniquePk;
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
	
	@Test
	public void testIdClass() {
		Album album = new Album();
		album.setPrice(BigDecimal.valueOf(15f));
		
		AlbumIdClass id = new AlbumIdClass("Sucesso ao Terro", 125);
		
		album.setSecTime(id.getSecTime());
		album.setTitle(id.getTitle());

		this.manager.getTransaction().begin();
		this.manager.persist(album);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void testEmbbedId() {
		Employee manager = new Employee();
		manager.setNome("Jhonatan");
		
		Department department = new Department();
		department.setManager(manager);
		
		DepartmentId id = new DepartmentId("UAT", "Unidade Ambiente Teconologico");
		
		department.setId(id);

		this.manager.getTransaction().begin();
		this.manager.persist(department);
		this.manager.getTransaction().commit();
	}
	
	@Test
	public void testComplexEmbbedId() {
		Project project = new Project();
		project.setDescription("Contrução do Maracana");
		project.setEndDate(Calendar.getInstance());
		project.setStartDate(Calendar.getInstance());
		project.setSpent(BigDecimal.valueOf(1566654f));
		
		Employee manager = new Employee();
		manager.setNome("Jhonatan");
		
		UniquePk id = new UniquePk();
		id.setHashCode("12321231564654");
		id.setRegistDate(Calendar.getInstance().getTime());
		
		project.setManager(manager);
		project.setId(id);

		this.manager.getTransaction().begin();
		this.manager.persist(project);
		this.manager.getTransaction().commit();
	}

}
