package com.example.Mappingprojection.service;

import com.example.Mappingprojection.DTO.LaptopDTO;
import com.example.Mappingprojection.DTO.SystemDTO;
import com.example.Mappingprojection.DTO.UserDTO;
import com.example.Mappingprojection.model.Laptop;
import com.example.Mappingprojection.model.User;
import com.example.Mappingprojection.model.System;
import com.example.Mappingprojection.projection.Projection;
import com.example.Mappingprojection.repository.Laptoprepo;
import com.example.Mappingprojection.repository.Systemrepo;
import com.example.Mappingprojection.repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class Userservice {


    @Autowired
    Userrepo userrepo;
    @Autowired
    Laptoprepo laptoprepo;
    @Autowired
    Systemrepo systemrepo;

    public String postdetails(UserDTO edto) {

        User ut = new User();
        ut.setId(edto.getId());
        ut.setName(edto.getName());
        ut.setEmail(edto.getEmail());
        ut.setLocation(edto.getLocation());
        ut.setActive(edto.isActive());
        ut.setDeleteflag(edto.isDeleteflag());

        userrepo.save(ut);
        return "saved";

    }

    public String laptopdetails(LaptopDTO ldto) {

        Laptop lt = new Laptop();
        lt.setLaptop_id(ldto.getLaptop_id());
        lt.setBrandname(ldto.getBrandname());
        lt.setModel(ldto.getModel());
        lt.setActive(ldto.isActive());
        lt.setDeleteflag(ldto.isDeleteflag());
        laptoprepo.save(lt);
        return "saved";
    }

    public String systemdetails(SystemDTO sdto) {

        System st = new System();
        st.setBrandname(sdto.getBrandname());
        st.setModel(sdto.getModel());
        st.setActive(sdto.isActive());
        st.setDeleteflag(sdto.isDeleteflag());
        systemrepo.save(st);

        return "saved";
    }

    public String laptopidmapping(int lapid, int userid) {
        if (lapid > 0 && userid > 0) {
            Optional<Laptop> laptopOptional = laptoprepo.findById(lapid);
            if (laptopOptional.isPresent()) {
                Laptop laptop = laptopOptional.get();
                Optional<User> userOptional = userrepo.findById(userid);
                userOptional.ifPresent(laptop::setUser);
                laptoprepo.save(laptop);
                return "Success";
            }
        }
        return "Fail";
    }

    public String systemidmapping(int sysid, int userid) {
        if (sysid > 0 && userid > 0) {
            Optional<System> systemOptional = systemrepo.findById(sysid);
            if (systemOptional.isPresent()) {
                System system = systemOptional.get();
                Optional<User> userOptional = userrepo.findById(userid);
                userOptional.ifPresent(system::setUser);
                systemrepo.save(system);
                return "Success";
            }
        }
        return "Fail";
    }

    //getmapping
     public List<Projection> gettingdetails() {
            return userrepo.gettingdetails();
    }


    public Page<Projection> userpaging(int pageno, int pagesize) {
        return userrepo.findAllProjections(PageRequest.of(pageno,pagesize));
    }
}
