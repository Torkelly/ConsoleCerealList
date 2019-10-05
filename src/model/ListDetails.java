package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="LIST_ID")
private int id;
@Column(name="LIST_NAME")
private String listName;
@Column(name="STOCK_DATE")
private LocalDate stockDate;
@ManyToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="CONSUMER_ID")
private Consumer consumer;

@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
@JoinTable
 (
		 name="BOXES_ON_LIST",
		 joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
		 inverseJoinColumns={ @JoinColumn(name="LISTBOX_ID", referencedColumnName="BOX_ID", unique=true) }
 )
 	private List<CerealBox> listOfBoxes;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;	
	}
	public LocalDate getStockDate() {
		return stockDate;
	}
	public void setStockDate(LocalDate stockDate) {
		this.stockDate = stockDate;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public List<CerealBox> getListOfBoxes() {
		return listOfBoxes;
	}
	public void setListOfBoxes(List<CerealBox> listOfBoxes) {
		this.listOfBoxes = listOfBoxes;
	}
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate stockDate, Consumer consumer, List<CerealBox> listOfBoxes) {
		super();
		this.id = id;
		this.listName = listName;
		this.stockDate = stockDate;
		this.consumer = consumer;
		this.listOfBoxes = listOfBoxes;
	}
	
	public ListDetails(String listName, LocalDate stockDate, Consumer consumer, List<CerealBox> listOfBoxes) {
		super();
		this.listName = listName;
		this.stockDate = stockDate;
		this.consumer = consumer;
		this.listOfBoxes = listOfBoxes;
	}
	
	public ListDetails(String listName, LocalDate stockDate, Consumer consumer) {
		super();
		this.listName = listName;
		this.stockDate = stockDate;
		this.consumer = consumer;
	}
	
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + stockDate + ", consumer=" + consumer + ", listOfBoxes=" + listOfBoxes + "]";
	}
}
