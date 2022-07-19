package com.baz.examen.repository.iface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baz.examen.entity.AmigoEntity;

public interface AmigoRepository extends JpaRepository<AmigoEntity, Integer> {

}
