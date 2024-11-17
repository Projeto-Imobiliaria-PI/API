package org.imobiliaria.imobiliaria.repositories;

import org.imobiliaria.imobiliaria.models.ImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelModel, Integer> {

    @Query("SELECT imovel FROM imovel imovel WHERE imovel.disponivel = true")
    public List<ImovelModel> listarTodosDisponiveis();

    @Query("SELECT imovel FROM imovel imovel WHERE imovel.disponivel = false")
    public List<ImovelModel> listarTodosIndisponiveis();


    @Query("SELECT imovel FROM imovel imovel WHERE imovel.tipo = :tipo")
    public List<ImovelModel> findByTipo(String tipo);

    @Query("SELECT imovel FROM imovel imovel WHERE imovel.cidade = :cidade")
    public List<ImovelModel> findByCidade(String cidade);

    @Query("SELECT imovel FROM imovel imovel WHERE imovel.uf = :uf")
    public List<ImovelModel> findByEstado(String uf);

    @Query("SELECT imovel FROM imovel imovel WHERE imovel.cep = :cep")
    public List<ImovelModel> findByCep(String cep);

    @Query("SELECT imovel FROM imovel imovel WHERE imovel.logradouro = :logradouro")
    public List<ImovelModel> findByLogradouro(String logradouro);


}
