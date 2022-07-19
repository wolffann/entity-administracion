package com.baz.examen.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baz.examen.entity.AmigoEntity;
import com.baz.examen.entity.SolicitudAmigoEntity;
import com.baz.examen.entity.UsuarioEntity;
import com.baz.examen.exception.custom.NotFoundException;
import com.baz.examen.exception.custom.ServiceException;
import com.baz.examen.exception.enums.ErrorCode;
import com.baz.examen.model.AmigoDTO;
import com.baz.examen.model.SolicitudAmigoDTO;
import com.baz.examen.model.UsuarioDTO;
import com.baz.examen.repository.iface.AmigoRepository;
import com.baz.examen.repository.iface.SolicitudAmigoRepository;
import com.baz.examen.repository.iface.UsuarioJpaRepository;
import com.baz.examen.repository.iface.UsuarioRepository;
import com.baz.examen.service.iface.AdministracionService;
import com.baz.examen.utils.DateTimeUtils;

@Service
public class AdministracionServiceImpl implements AdministracionService {

	@Autowired
	private AmigoRepository amigoRepository;
	
	@Autowired
	private SolicitudAmigoRepository solicitudAmigoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;
	
	public UsuarioDTO guardarUsuario(UsuarioDTO usuario) {
		try {
			UsuarioEntity usuarioEntity = new UsuarioEntity();
			BeanUtils.copyProperties(usuario, usuarioEntity);
			
			Date fechaComun = new Date();
			usuarioEntity.setFhCreacion(fechaComun);
			usuarioEntity.setFhModificacion(fechaComun);
			usuarioEntity.setFhNacimiento(
					DateTimeUtils.getDateFromString(usuario.getFhNacimiento(), DateTimeUtils.PATTERN_2));
			usuarioEntity.setStUsuario("1");
			
			usuarioEntity = usuarioJpaRepository.save(usuarioEntity);
			
			UsuarioDTO usuarioRespuesta = new UsuarioDTO();
			usuarioRespuesta.setIdUsuario(usuarioEntity.getIdUsuario());
			usuarioRespuesta.setStUsuario(usuarioEntity.getStUsuario());
			usuarioRespuesta.setFhCreacion(fechaComun);
			return usuarioRespuesta;
			
		} catch (ParseException e) {
			throw new ServiceException(ErrorCode.COMPONENTE_FALLIDO.codigo(),
					"Ocurrio un error al interpretar la fecha de nacimiento: " + usuario.getFhNacimiento()
							+ " la cual debe de venir en formato dd-mm-yyyy",
					"", e);
		
		} catch (Exception e) {
			throw new ServiceException(ErrorCode.ERROR_INTERNO.codigo(), ErrorCode.ERROR_INTERNO.detalle(), "", e);
		}
	}
	
	/**
	 * Encuentra todos los usuarios, excepto al correspondiente con el id 
	 */
	public List<UsuarioDTO> consultarUsuariosNotInIdUsuario(Integer idUsuario) {
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		List<UsuarioEntity> usuariosEntity = usuarioRepository.findUsuariosNotInIdUsuario(idUsuario);
		
		usuariosEntity.stream().forEach(usuarioEntity -> usuariosDTO.add(copiarProperties(usuarioEntity)));							
		return usuariosDTO;
	}
	
	public SolicitudAmigoDTO guardarSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo) {
		Date fechaComun = new Date();
		SolicitudAmigoEntity entity = new SolicitudAmigoEntity();
		entity.setIdUsuario(solicitudAmigo.getIdUsuario());
		entity.setIdAmigo(solicitudAmigo.getIdAmigo());
		entity.setFhCreacion(fechaComun);
		entity.setFhModificacion(fechaComun);
		entity.setStSolicitud('0');
		entity = solicitudAmigoRepository.save(entity);
		
		SolicitudAmigoDTO solicitudAmigoRespuesta = new SolicitudAmigoDTO();
		solicitudAmigoRespuesta.setIdSolicitud(entity.getIdSolicitud());
		solicitudAmigoRespuesta.setStSolicitud(entity.getStSolicitud());
		solicitudAmigoRespuesta.setFhCreacion(fechaComun);
		
		return solicitudAmigoRespuesta;
	}
		
	public List<SolicitudAmigoDTO> consultarSolicitudesFromOthersToIdUsuario(Integer idUsuario) {
		List<SolicitudAmigoDTO> solicitudesDTO = new ArrayList<>();		
		List<SolicitudAmigoEntity> solicitudesEntity = solicitudAmigoRepository.findByIdUsuarioAndStSolicitud(idUsuario, '0');
		
		solicitudesEntity.stream().forEach(solicitudEntity -> solicitudesDTO.add(copiarPropiedades(solicitudEntity)));		
		return solicitudesDTO;
	}

	/**
	 * Estatus de solicitudes: 0=Nueva, 1=Aceptada, 2=Rechazada
	 */
	public SolicitudAmigoDTO actualizarStatusSolicitudAmigo(SolicitudAmigoDTO solicitudAmigo) {							
		Optional<SolicitudAmigoEntity> entity = solicitudAmigoRepository.findById(solicitudAmigo.getIdSolicitud());				
		
		if(entity.isPresent()) {
			entity.get().setFhModificacion(new Date());
			entity.get().setStSolicitud(solicitudAmigo.getStSolicitud());
			solicitudAmigoRepository.save(entity.get());
			
			solicitudAmigo.setIdAmigo(entity.get().getIdAmigo());
			solicitudAmigo.setIdUsuario(entity.get().getIdUsuario());
			solicitudAmigo.setFhModificacion(entity.get().getFhModificacion());			
		} else {
			throw new NotFoundException(ErrorCode.RECURSO_NO_ENCONTRADO.codigo(), "No se encontró la solicitud con el id = " + solicitudAmigo.getIdSolicitud());
		}										
					
		return solicitudAmigo;
	}

	@Override
	public AmigoDTO guardarAmigo(AmigoDTO amigo) {
		Date fechaComun = new Date();
		AmigoEntity amigoEntity = new AmigoEntity();		
		amigoEntity.setFhCreacion(fechaComun);
		amigoEntity.setFhModificacion(fechaComun);
		amigoEntity.setIdAmigo(amigo.getIdAmigo());
		amigoEntity.setIdUsuario(amigo.getIdUsuario());
		amigoEntity.setStAmigo('1');		
		amigoEntity = amigoRepository.save(amigoEntity);
		
		AmigoDTO amigoDTOResultado = new AmigoDTO();
		BeanUtils.copyProperties(amigoEntity, amigoDTOResultado);		
		return amigoDTOResultado;
	}
	
	public List<AmigoDTO> consultarAmigosByIdUsuario(Integer idUsuario) {
		try {
			List<AmigoDTO> amigosDTO = new ArrayList<>();
			
			UsuarioEntity usuarioEntity = usuarioRepository.findUsuarioWithAmigos(idUsuario);
			
			if(usuarioEntity != null) {
				List<AmigoEntity> amigosEntity = usuarioEntity.getAmigosList();			
				amigosEntity.stream().forEach(amigoEntity -> amigosDTO.add(copiarPropiedades(amigoEntity)));		
				return amigosDTO;
				
			} else {
				return new ArrayList<>();
			}
		} catch (Exception e) {			
			e.printStackTrace();
			return new ArrayList<AmigoDTO>();
		}
	}
	
	private AmigoDTO copiarPropiedades(AmigoEntity amigoEntity) {
		AmigoDTO amigoDTO = new AmigoDTO();
		BeanUtils.copyProperties(amigoEntity, amigoDTO);
		return amigoDTO;
	}

	private UsuarioDTO copiarProperties(UsuarioEntity entity) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		BeanUtils.copyProperties(entity, usuarioDTO);
		return usuarioDTO;
	}
	
	private SolicitudAmigoDTO copiarPropiedades(SolicitudAmigoEntity solicitudEntity) {
		SolicitudAmigoDTO solicitudAmigoDTO = new SolicitudAmigoDTO();
		BeanUtils.copyProperties(solicitudEntity, solicitudAmigoDTO);
		return solicitudAmigoDTO;
	}
	
}
