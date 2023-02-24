package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.ServiceHippo;
import co.simplon.hippopocrate.repository.ServiceRepository;

@Service
public class ServiceServImpl implements ServiceServ {
	
	
	
		
		@Autowired
	    private ServiceRepository sr;
		
		public List<ServiceHippo> fetchServiceList() {
			// TODO Auto-generated method stub
			return sr.findAll();
		}
		
		public ServiceHippo findServiceById(long serviceId) {
			return sr.findById(serviceId).get();
		}
		

}
