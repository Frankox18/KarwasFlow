package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.TypeWashed;

public interface TypeWashedService extends CrudService<TypeWashed, Integer>{

	List<TypeWashed> findByServiceName(String serviceName) throws Exception;
}
