package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.ServiceHippo;

/**
* @author Caroline
* Interface that contains the methods use for the service'
*
*/
public interface ServiceServ {
	
	 // read operation
    List<ServiceHippo> fetchServiceList();

}
