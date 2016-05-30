package br.com.jkavdev.persistence.model.id;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "hotel_rooms")
@TableGenerator(
		name = Country.IDS_TABLE_NAME, 
		table = Country.IDS_TABLE_NAME, 
		pkColumnName = "tabela", 
		pkColumnValue = "hotel_rooms", 
		valueColumnName = "id_atual", 
		initialValue = 1, 
		allocationSize = 1)
public class HotelRooms implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer roomNumber;
	private String roomFloor;
	private String roomFloorCount;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = Country.IDS_TABLE_NAME)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomFloor() {
		return roomFloor;
	}

	public void setRoomFloor(String roomFloor) {
		this.roomFloor = roomFloor;
	}

	public String getRoomFloorCount() {
		return roomFloorCount;
	}

	public void setRoomFloorCount(String roomFloorCount) {
		this.roomFloorCount = roomFloorCount;
	}

}
