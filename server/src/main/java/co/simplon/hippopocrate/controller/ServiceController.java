package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.ServiceHippo;
import co.simplon.hippopocrate.service.ServiceServImpl;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping("api/")
public class ServiceController {
	
	@Autowired
	private ServiceServImpl ssi;
	
    @GetMapping("services")
	public List<ServiceHippo> fetchServicesList() {
		return ssi.fetchServiceList();
	}
    
}
