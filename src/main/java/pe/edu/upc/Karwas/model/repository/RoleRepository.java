package pe.edu.upc.Karwas.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.Karwas.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByNameRole( String nameRole ) throws Exception;
}
