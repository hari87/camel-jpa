package nl.devoteam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/*import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/

@Entity
@Table(name="users", schema="devoteam")
//@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode -- wanted to use lombok but giving
//compile time dependencies issues. 
public class User {
@Id
@GeneratedValue
@Column(name = "user_id", unique = true, nullable = false)
private int id;
@Column(name = "user_name")
private String user_name;
@Column(name = "client_name")
private String client_name;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getClient_name() {
	return client_name;
}
public void setClient_name(String client_name) {
	this.client_name = client_name;
}

}
