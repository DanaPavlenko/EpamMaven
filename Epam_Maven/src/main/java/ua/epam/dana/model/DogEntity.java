package ua.epam.dana.model;

import ua.epam.dana.model.annotation.Column;
import ua.epam.dana.model.annotation.PrimaryKey;
import ua.epam.dana.model.annotation.Table;

@Table(name = "dog")
public class DogEntity {

	@PrimaryKey
	@Column (name = "id")
	private Integer id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "age")
	private Integer age;
	
	@Column (name = "breedId")
	private Integer breedId;

	public DogEntity() {
	}

	public DogEntity(Integer id, String name, Integer age, Integer breedId) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.breedId = breedId;
	}
	
	

	public DogEntity(String name, Integer age, Integer breedId) {
		this.name = name;
		this.age = age;
		this.breedId = breedId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getBreedId() {
		return breedId;
	}

	public void setBreed(Integer breed) {
		this.breedId = breed;
	}

	@Override
	public String toString() {
		return "DogEntity [id=" + id + ", name=" + name + ", age=" + age + ", breed=" + breedId + "]";
	}
	
	
	
	
}
