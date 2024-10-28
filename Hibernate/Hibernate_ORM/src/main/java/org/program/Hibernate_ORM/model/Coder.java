package org.program.Hibernate_ORM.model;
import jakarta.persistence.*;

@Entity
@Table
public class Coder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int rating;
	@OneToOne
	private Cohort cohort;

	public Coder() {
	}

	public Coder(int id, String name, int rating, Cohort cohort) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.cohort = cohort;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	@Override
	public String toString() {
		return "Coder{" +
				"id=" + id +
				", name='" + name + '\'' +
				", rating=" + rating +
				", cohort=" + cohort +
				'}';
	}
}
