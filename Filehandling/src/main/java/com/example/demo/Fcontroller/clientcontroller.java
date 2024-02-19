package com.example.demo.Fcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dto.clientdto;
import com.example.demo.Fentity.Client;
import com.example.demo.fService.Storageservice;
import com.google.gson.Gson;



@RestController
public class clientcontroller {
       @Autowired
       Storageservice stg;
       
       
       @PostMapping("/Clientphoto")
       public String saveEmployee(@RequestParam("cli") String client,@RequestPart("file") MultipartFile file) {
          
   		return stg.saveClient(new Gson().fromJson(client, clientdto.class),file);
       }
       
         @GetMapping("/getcontroller/{pageno}/{pagesize}")
         public Page<Client> display(@PathVariable int pageno, @PathVariable int pagesize){
        	 Page<Client> clientpage = stg.disp(pageno,pagesize);
        	 return clientpage;
         }
       
       
       
}
