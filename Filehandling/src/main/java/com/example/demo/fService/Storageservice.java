package com.example.demo.fService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dto.clientdto;
import com.example.demo.Fentity.Client;
import com.example.demo.Frepository.clientrepo;



@Service
public class Storageservice {
    
	@Autowired
	clientrepo repo;
	public String saveClient (clientdto clientdto, MultipartFile multipartFile) {
		Client client = new Client();
		try {
			client.setClientPhoto(multipartFile.getBytes());
			client.setClientname(clientdto.getClientname());
			client.setClientinst(clientdto.getClientinst());
			client.setClientoriginalname(multipartFile.getOriginalFilename());
			repo.save(client);
			return "uploaded";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
		
		}
	    public Page<Client> disp(int pageno, int pagesize){
	    	return repo.findAll(PageRequest.of(pageno, pagesize));
	
	}
	
	
}
