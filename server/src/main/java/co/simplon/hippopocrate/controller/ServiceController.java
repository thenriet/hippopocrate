package co.simplon.hippopocrate.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.model.Room;
import co.simplon.hippopocrate.model.ServiceHippo;
import co.simplon.hippopocrate.service.ServiceServImpl;

/**
 * @author Caroline
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping("api/")
public class ServiceController {
	
	@Autowired
	private ServiceServImpl ssi;
	
	/**
	 * Method to get the Hopital Services list 
	 * @return the Hopital services 
	 */
    @GetMapping("services")
	public List<ServiceHippo> fetchServicesList() {
		return ssi.fetchServiceList();
	}
    
    /**
     * Method to display one service thank to it's id
     * @param id
     * @param model
     * @return the service 
     */
    @GetMapping("services/{id}")
   	public ServiceHippo fetchOneService(@PathVariable("id") long id, Model model) {
   		return ssi.findServiceById(id);
   	}
    
    /**
     * Method to display the room thank to the service's id  
     * @param id
     * @param model
     * @return the associate room
     */
    @GetMapping("services/{id}/rooms")
   	public  Set<Room> fetchRoomsByService(@PathVariable("id") long id, Model model) {
   		return ssi.findRooms(id);
   	}
    
    /**
     * Method to display the bed thank to the room's id 
     * @param id
     * @param model
     * @return bed
     */
    @GetMapping("rooms/{id}/beds")
   	public  Set<Bed> fetchBedsByRoom(@PathVariable("id") long id, Model model) {
   		return ssi.findBeds(id);
   	}
    
    
}
