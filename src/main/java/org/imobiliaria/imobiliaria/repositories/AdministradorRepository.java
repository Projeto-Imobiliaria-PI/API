package org.imobiliaria.imobiliaria.repositories;

import org.imobiliaria.imobiliaria.models.AdministradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdministradorRepository extends JpaRepository<AdministradorModel, Integer> {

    Optional<AdministradorModel> findByEmail(String email);

}
