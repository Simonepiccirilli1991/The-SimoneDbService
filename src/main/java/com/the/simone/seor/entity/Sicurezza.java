package com.the.simone.seor.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(schema="dbthesimone", name = "sicurezza")
public class Sicurezza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String lastPswRegistered;
	private String domandaSegreta;
	private boolean emailConfermata;
	private String rispostaSegreta;
	

	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utente_username", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Utente utente;
	
	public long getId() {
		return id;
	}
	
	public String getLastPswRegistered() {
		return lastPswRegistered;
	}

	public void setLastPswRegistered(String lastPswRegistered) {
		this.lastPswRegistered = lastPswRegistered;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDomandaSegreta() {
		return domandaSegreta;
	}
	public void setDomandaSegreta(String domandaSegreta) {
		this.domandaSegreta = domandaSegreta;
	}
	public boolean isEmailConfermata() {
		return emailConfermata;
	}
	public void setEmailConfermata(boolean emailConfermata) {
		this.emailConfermata = emailConfermata;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String getRispostaSegreta() {
		return rispostaSegreta;
	}

	public void setRispostaSegreta(String rispostaSegreta) {
		this.rispostaSegreta = rispostaSegreta;
	}
	
	
	
	

}
