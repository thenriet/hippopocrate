package co.simplon.hippopocrate.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Room;
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
    
    @GetMapping("services/{id}")
   	public ServiceHippo fetchOneService(@PathVariable("id") long id, Model model) {
   		return ssi.findServiceById(id);
   	}
    
    
    @GetMapping("services/{id}/rooms")
   	public  Set<Room> fetchRoomsByService(@PathVariable("id") long id, Model model) {
   		return ssi.findRooms(id);
   	}
    
    
    
}
