package org.imobiliaria.imobiliaria.repositories;

import org.imobiliaria.imobiliaria.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    @Query("SELECT vendedor FROM vendedor vendedor WHERE vendedor.ativo = true")
    List<Vendedor> listarTodosAbertos();

    @Query("SELECT vendedor FROM vendedor vendedor WHERE vendedor.ativo = false")
    List<Vendedor> listarTodosFechados();

    @Query("SELECT vendedor FROM vendedor vendedor WHERE LOWER(vendedor.nome) = LOWER(:nome)")
    Optional<Vendedor> findByNome(String nome);

    @Query("SELECT vendedor FROM vendedor vendedor WHERE REPLACE(vendedor.cpf, '.', '') = :cpf")
    Optional<Vendedor> findByCpf(String cpf);

    @Query("SELECT vendedor FROM vendedor vendedor WHERE LOWER(vendedor.area) = LOWER(:area)")
    Optional<Vendedor> findByArea(String area);


}