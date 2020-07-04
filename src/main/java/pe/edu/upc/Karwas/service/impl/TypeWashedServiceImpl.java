package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.Karwas.model.entity.TypeWashed;
import pe.edu.upc.Karwas.model.repository.TypeWashedRepository;
import pe.edu.upc.Karwas.service.TypeWashedService;

@Service
public class TypeWashedServiceImpl implements TypeWashedService {
	
	@Autowired
	private TypeWashedRepository typewashedRepository;

	@Override
	@Transactional
	public TypeWashed create(TypeWashed entity) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TypeWashed> readAll() throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TypeWashed> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.findById(id);
	}

	@Override
	@Transactional
	public TypeWashed update(TypeWashed entity) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		typewashedRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		typewashedRepository.deleteAll();
	}

	@Override
	@Transactional
	public List<TypeWashed> findByServiceName(String serviceName) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.findByServiceName(serviceName);
	}
}
