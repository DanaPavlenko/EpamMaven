package ua.epam.dana.model;

import ua.epam.dana.model.annotation.Column;
import ua.epam.dana.model.annotation.PrimaryKey;
import ua.epam.dana.model.annotation.Table;

@Table (name = "breed")
public class BreedEntity {

	@PrimaryKey
	@Column (name = "id")
	private Integer id;
	
	@Column(name = "breed")
	private String breed;
	

	public BreedEntity() {
	}


	public BreedEntity(Integer id, String breed) {
		this.id = id;
		this.breed = breed;
	}


	public BreedEntity(String breed) {
		this.breed = breed;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}


	@Override
	public String toString() {
		return "BreedEntity [id=" + id + ", breed=" + breed + "]";
	}

}
