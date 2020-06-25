package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.Role;
import pe.edu.upc.Karwas.model.repository.RoleRepository;
import pe.edu.upc.Karwas.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Override
	public Role create(Role entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> readAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Role> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role update(Role entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> findByNameRole(String nameRole) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    
	/*@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public Role create(Role entity) throws Exception {
		return roleRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> readAll() throws Exception {
		return roleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Role> findById(Integer id) throws Exception {
		return roleRepository.findById(id);
	}

	@Override
	@Transactional
	public Role update(Role entity) throws Exception {
		return roleRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		roleRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		roleRepository.deleteAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findByNameRole(String nameRole) throws Exception {
		return roleRepository.findByNameRole(nameRole);
	}*/
    
	
}
