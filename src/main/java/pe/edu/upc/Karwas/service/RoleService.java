package pe.edu.upc.Karwas.service;

import java.util.List;

import pe.edu.upc.Karwas.model.entity.Role;


public interface RoleService extends CrudService<Role, Integer>{

	List<Role> findByNameRole( String nameRole ) throws Exception;
	
}
