package pe.edu.upc.Karwas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.Karwas.model.entity.TypeWashed;
import pe.edu.upc.Karwas.model.repository.TypeWashedRepository;
import pe.edu.upc.Karwas.service.TypeWashedService;

@Service
public class TypeWashedServiceImpl implements TypeWashedService {
	
	@Autowired
	private TypeWashedRepository typewashedRepository;

	@Override
	public TypeWashed create(TypeWashed entity) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.save(entity);
	}

	@Override
	public List<TypeWashed> readAll() throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.findAll();
	}

	@Override
	public Optional<TypeWashed> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.findById(id);
	}

	@Override
	public TypeWashed update(TypeWashed entity) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		typewashedRepository.deleteById(id);
	}

	@Override
	public void deleteByAll() throws Exception {
		// TODO Auto-generated method stub
		typewashedRepository.deleteAll();
	}

	@Override
	public List<TypeWashed> findByServiceName(String serviceName) throws Exception {
		// TODO Auto-generated method stub
		return typewashedRepository.findByServiceName(serviceName);
	}
}
