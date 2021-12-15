package za.co.nico.testapp.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nicos_thing")
public class NicosThing {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nicos_thing_id")
	private Long nicosThingId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "name", length=256)
	private String name; 

	@Column(name = "description", length=256)
	private String description; 
	
	
	@Column(name = "email_address", length=128)
	private String emailAddress;
	
	@Column(name = "cell_phone", length=128)
	private String cellPhone;

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public Long getNicosThingId() {
		return nicosThingId;
	}

	@Override
	public String toString() {
		return "NicosThings [nicosThingsId=" + nicosThingId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", description=" + description + ", emailAddress=" + emailAddress + ", cellPhone=" + cellPhone + "]";
	}
	
	
	




	
	
	
}
