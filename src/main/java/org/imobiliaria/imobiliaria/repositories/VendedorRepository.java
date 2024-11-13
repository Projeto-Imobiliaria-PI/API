package org.imobiliaria.imobiliaria.repositories;

import org.imobiliaria.imobiliaria.models.VendedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {

    @Query("SELECT vendedor FROM vendedor vendedor WHERE vendedor.ativo = true")
    List<VendedorModel> listarTodosAtivos();

    @Query("SELECT vendedor FROM vendedor vendedor WHERE vendedor.ativo = false")
    List<VendedorModel> listarTodosInativos();

    @Query("SELECT vendedor FROM vendedor vendedor WHERE LOWER(vendedor.nome) = LOWER(:nome)")
    Optional<VendedorModel> findByNome(String nome);

    @Query("SELECT vendedor FROM vendedor vendedor WHERE REPLACE(vendedor.cpf, '.', '') = :cpf")
    Optional<VendedorModel> findByCpf(String cpf);

    @Query("SELECT vendedor FROM vendedor vendedor WHERE LOWER(vendedor.area) = LOWER(:area)")
    Optional<VendedorModel> findByArea(String area);


}