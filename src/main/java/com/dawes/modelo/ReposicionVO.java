package com.dawes.modelo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reposiciones")
public class ReposicionVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idreposicion;
	private String comentario;
	private Date fechareposicion;
	
	@ManyToOne
	@JoinColumn(name = "idarbol")
	private ArbolVO arbol;

}
