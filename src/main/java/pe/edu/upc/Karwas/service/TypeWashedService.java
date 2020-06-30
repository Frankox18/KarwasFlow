package pe.edu.upc.Karwas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.upc.Karwas.model.entity.TypeWashed;

@Service
public interface TypeWashedService extends CrudService<TypeWashed, Integer>{

	List<TypeWashed> findByServiceName(String serviceName) throws Exception;
}
