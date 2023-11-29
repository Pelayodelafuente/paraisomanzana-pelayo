package com.dawes.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.FincaVO;

@Repository
public interface FincaRepositorio extends CrudRepository<FincaVO, Integer>{
	
	//Aqui la query no haría falta
	//@Query("SELECT f FROM FincaVO f WHERE f.denominacion=?1")
	Optional<FincaVO> findByDenominacion(String denominacion);

}
