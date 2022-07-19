package com.baz.examen.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baz.examen.entity.UsuarioEntity;
import com.baz.examen.repository.iface.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public UsuarioEntity findUsuarioWithAmigos(Integer idUsuario) {
		TypedQuery<UsuarioEntity> query = entityManager				
				.createQuery(
						"select u from UsuarioEntity u join AmigoEntity a on u.idUsuario = a.idUsuario"
						+ " where u.idUsuario = :idUsuario and a.stAmigo = :stAmigo",
						UsuarioEntity.class);
		
		return query.setParameter("idUsuario", idUsuario)
					.setParameter("stAmigo", '1')
					.getSingleResult();				
	}

	@Override
	public List<UsuarioEntity> findUsuariosNotInIdUsuario(Integer idUsuario) {
		TypedQuery<UsuarioEntity> query = entityManager
				.createQuery("select u from UsuarioEntity u where u.idUsuario <> :idUsuario",  UsuarioEntity.class);
		
		return query.setParameter("idUsuario", idUsuario).getResultList();		
	}
}
