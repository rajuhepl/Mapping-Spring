package com.example.demo.Fentity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="ClientTable")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
      private int clientid;
      @Column(name="Clientname")
      private String Clientname;
      @Column(name="Clientinst")
      private String Clientinst;
      @Column(name="clientoriginalname")
      private String clientoriginalname;
      
      public String getClientoriginalname() {
		return clientoriginalname;
	}

	public void setClientoriginalname(String clientoriginalname) {
		this.clientoriginalname = clientoriginalname;
	}

	@Lob
      @Column(name="Clientphoto",columnDefinition = "BLOB")
      private byte[] ClientPhoto;

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return Clientname;
	}

	public void setClientname(String clientname) {
		Clientname = clientname;
	}

	public String getClientinst() {
		return Clientinst;
	}

	public void setClientinst(String clientinst) {
		Clientinst = clientinst;
	}

	public byte[] getClientPhoto() {
		return ClientPhoto;
	}

	public void setClientPhoto(byte[] clientPhoto) {
		ClientPhoto = clientPhoto;
	}

	

	
      
      
      
      
}
