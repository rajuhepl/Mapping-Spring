package com.example.demo.Dto;



public class clientdto {
	private int clientid;
   
    private String Clientname;
    
    private String Clientinst;
    
    private String clientoriginalname;
    
    private byte[] ClientPhoto;

	public int getClientid() {
		return clientid;
	}

	public byte[] getClientPhoto() {
		return ClientPhoto;
	}

	public void setClientPhoto(byte[] clientPhoto) {
		ClientPhoto = clientPhoto;
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

	public String getClientoriginalname() {
		return clientoriginalname;
	}

	public void setClientoriginalname(String clientoriginalname) {
		this.clientoriginalname = clientoriginalname;
	}
    
    
}
