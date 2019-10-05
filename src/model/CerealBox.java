package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="boxes")
public class CerealBox {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOX_ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="FLAVOR")
    private String flavor;
    
	public CerealBox(String name, String flavor) {
		super();
		this.name = name;
		this.flavor = flavor;
	}
	
	public CerealBox() {
		super();
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

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	
	public String print() {
		return name + ": " + flavor;
	}


}
