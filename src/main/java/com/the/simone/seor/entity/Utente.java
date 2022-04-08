package com.the.simone.seor.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(schema="dbthesimone", name = "utente", uniqueConstraints=
@UniqueConstraint(columnNames={"username"}))
@PrimaryKeyJoinColumn(name="utente_username")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String psw;
	@Column(unique=true)
	private String username;
	private String email;
	@OneToMany(mappedBy = "utente", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Post> post;
	
	@OneToOne(mappedBy = "utente", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Sicurezza sicurezza;
	
	@OneToOne(mappedBy = "utente", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Anagrafica anagrafica;
	
	
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public Set<Post> getPost() {
		return post;
	}
	public void setPost(Set<Post> post) {
		this.post = post;
	}
	public Sicurezza getSicurezza() {
		return sicurezza;
	}
	public void setSicurezza(Sicurezza sicurezza) {
		this.sicurezza = sicurezza;
	}
	public Anagrafica getAnagrafica() {
		return anagrafica;
	}
	public void setAnagrafica(Anagrafica anagrafica) {
		this.anagrafica = anagrafica;
	}
	
	
	
	
	

}
