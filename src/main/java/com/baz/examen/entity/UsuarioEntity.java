package com.baz.examen.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSUARIO")
	private Integer idUsuario;
	
	@Column(name = "TXNOMBRE")
	private String txNombre;
	
	@Column(name = "TXNOMBRE2")
	private String txNombre2;
	
	@Column(name = "TXAPELLIDO")
	private String txApellido;
	
	@Column(name = "TXAPELLIDO2")
	private String txApellido2;
	
	@Column(name = "FHNACIMIENTO")
	private Date fhNacimiento;
	
	@Column(name = "IDSEXO")
	private Character idSexo;
	
	@Column(name = "TXNACIONALIDAD")
	private String txNacionalidad;
	
	@Column(name = "TXDIRECCION")
	private String txDireccion;
	
	@Column(name = "TXTELEFONO")
	private String txTelefono;
	
	@Column(name = "TXEMAIL")
	private String txEmail;
	
	@Column(name = "STUSUARIO")
	private String stUsuario;
	
	@Column(name = "FHCREACION")
	private Date fhCreacion;
	
	@Column(name = "FHMODIFICACION")
	private Date fhModificacion;	
	
	@OneToMany
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(
		name = "IDUSUARIO",
		referencedColumnName = "IDUSUARIO", 
		insertable = false, 
		updatable = false, 
		foreignKey = @javax.persistence
        	.ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private List<AmigoEntity> amigosList;

}
