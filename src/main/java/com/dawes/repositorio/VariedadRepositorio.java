package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.VariedadVO;

@Repository
public interface VariedadRepositorio extends CrudRepository<VariedadVO, Integer> {
	
	Optional<VariedadVO> findByNombre(String nombre);

}
