package com.baz.examen.repository.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.examen.entity.UsuarioEntity;

public interface UsuarioJpaRepository  extends JpaRepository<UsuarioEntity, Integer> {

}
