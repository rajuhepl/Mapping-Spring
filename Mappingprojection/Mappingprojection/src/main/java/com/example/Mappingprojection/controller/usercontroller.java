package com.example.Mappingprojection.controller;

import com.example.Mappingprojection.DTO.LaptopDTO;
import com.example.Mappingprojection.DTO.SystemDTO;
import com.example.Mappingprojection.DTO.UserDTO;
import com.example.Mappingprojection.projection.Projection;
import com.example.Mappingprojection.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class usercontroller {


    @Autowired
    private Userservice us;

    @PostMapping("/userdeatils")
    public String getdetails(@RequestBody UserDTO edto) {
        return us.postdetails(edto);
    }

    @PostMapping("/laptopdeatils")
    public String laptopdetails(@RequestBody LaptopDTO ldto) {
        return us.laptopdetails(ldto);
    }


    @PostMapping("/systemdeatils")
    public String systemdetails(@RequestBody SystemDTO sdto) {
        return us.systemdetails(sdto);
    }


    @PostMapping("/idmapping/{lapid}/{userid}")
    public String laptopidmapping(@PathVariable("lapid") int lapid, @PathVariable("userid") int userid) {
        return us.laptopidmapping(lapid, userid);
    }


    @PostMapping("/Idmapping/{sysid}/{userid}")
    public String systemidmapping(@PathVariable("sysid") int sysid, @PathVariable("userid") int userid) {

        return us.systemidmapping(sysid, userid);
    }


    @GetMapping("/getingdetails")
    public List<Projection> gettingdetails() {
        return us.gettingdetails();
    }

    @GetMapping("/pagination/{pageno}/{pagesize}")
    public Page<Projection> userpaging(@PathVariable int pageno,@PathVariable int pagesize){
        Page<Projection> page=us.userpaging(pageno,pagesize);
        return page;
    }


}
