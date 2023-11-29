package com.dawes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fincas", uniqueConstraints = @UniqueConstraint(columnNames = "denominacion"))
public class FincaVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfinca;
	private String denominacion;
	private String direccion;
	private String referenciacatastral;
	private double superficie;
	private String localizacion;
	
	
	public FincaVO(String denominacion, String direccion, String referenciacatastral, double superficie,
			String localizacion) {
		super();
		this.denominacion = denominacion;
		this.direccion = direccion;
		this.referenciacatastral = referenciacatastral;
		this.superficie = superficie;
		this.localizacion = localizacion;
	}
	
	

}
