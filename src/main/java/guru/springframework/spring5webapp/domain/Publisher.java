package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
	private String fname;
	private String Adress;
	private String City;
	private int zip;
	
	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set <Books> books = new HashSet<>();
	
	
	public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
	}

	public Publisher() {
		
	}
	
	public Publisher(String fname, String adress, String city, int zip) {
		super();
		this.fname = fname;
		this.Adress = adress;
		this.City = city;
		this.zip = zip;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	@Override
	public int hashCode() {
		return Id != null ? Id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (Id != other.Id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publisher [Id=" + Id + ", fname=" + fname + ", Adress=" + Adress + ", City=" + City + ", zip=" + zip
				+ "]";
	}
	
}
