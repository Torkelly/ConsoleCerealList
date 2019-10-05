package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumer")

public class Consumer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONSUMER_ID")
	private int consumerID;
	@Column(name="CONSUMER_NAME")
	private String consumerName;
	
	public Consumer() {
		super();
	}
	
	public Consumer(int id, String consumerName) {
		super();
		this.consumerID = id;
		this.consumerName = consumerName;
	}
	
	public Consumer(String consumerName) {
		super();
		this.consumerName = consumerName;
	}

	public int getId() {
		return consumerID;
	}

	public void setId(int id) {
		this.consumerID = id;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	
	@Override
	public String toString() {
	    return "Consumer [id=" + consumerID + ", consumerName=" + consumerName + "]";
	}
}