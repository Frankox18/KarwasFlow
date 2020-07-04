package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.UserBranchoffice;
import pe.edu.upc.Karwas.model.repository.UserBranchOfficeRepository;
import pe.edu.upc.Karwas.service.UserBranchOfficeService;

@Service
public class UserBranchOfficeServiceImpl implements UserBranchOfficeService {
	
	@Autowired
	private UserBranchOfficeRepository userBranchOfficeRepository; 
	
	@Override
	@Transactional
	public UserBranchoffice create(UserBranchoffice entity) throws Exception {
		return userBranchOfficeRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserBranchoffice> readAll() throws Exception {
		return userBranchOfficeRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UserBranchoffice> findById(Integer id) throws Exception {
		return userBranchOfficeRepository.findById(id);
	}

	@Override
	@Transactional
	public UserBranchoffice update(UserBranchoffice entity) throws Exception {
		return userBranchOfficeRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		userBranchOfficeRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		userBranchOfficeRepository.deleteAll();
	}
}
