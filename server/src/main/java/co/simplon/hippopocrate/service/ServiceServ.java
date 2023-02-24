package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.ServiceHippo;

public interface ServiceServ {
	
	 // read operation
    List<ServiceHippo> fetchServiceList();

}
