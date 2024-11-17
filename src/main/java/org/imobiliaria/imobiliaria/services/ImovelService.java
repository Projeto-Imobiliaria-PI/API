package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.models.ImovelModel;
import org.imobiliaria.imobiliaria.repositories.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {

    @Autowired
    ImovelRepository imovelRepository;

    public ImovelModel findById(Integer id) {
        Optional<ImovelModel> imovel = imovelRepository.findById(id);
        return imovel.orElse(null);
    }

    public List<ImovelModel> listarTodosDisponiveis() {
        List<ImovelModel> imoveis = imovelRepository.listarTodosDisponiveis();
        return imoveis;
    }

    public List<ImovelModel> listarTodosIndisponiveis() {
        List<ImovelModel> imoveis = imovelRepository.listarTodosIndisponiveis();
        return imoveis;
    }

    public List<ImovelModel> findByTipo(String tipo) {
        List<ImovelModel> imoveis = imovelRepository.findByTipo(tipo);
        return imoveis;
    }

    public List<ImovelModel> findByCidade(String cidade) {
        List<ImovelModel> imoveis = imovelRepository.findByCidade(cidade);
        return imoveis;
    }

    public List<ImovelModel> findByEstado(String estado) {
        List<ImovelModel> imoveis = imovelRepository.findByEstado(estado);
        return imoveis;
    }

    public List<ImovelModel> findByCep(String cep) {
        List<ImovelModel> imoveis = imovelRepository.findByCep(cep);
        return imoveis;
    }

    public List<ImovelModel> findByEndereco(String endereco) {
        List<ImovelModel> imoveis = imovelRepository.findByLogradouro(endereco);
        return imoveis;
    }

    public ImovelModel gravarImovel(ImovelModel imovelModel) {
        return imovelRepository.save(imovelModel);
    }

    public void deletarImovel(Integer id) {
        imovelRepository.deleteById(id);
    }

    public ImovelModel atualizarImovel(Integer id, ImovelModel imovelModel) {
        ImovelModel alterado = findById(id);
        if (alterado != null) {
            alterado.setLogradouro(imovelModel.getLogradouro());
            alterado.setNumero(imovelModel.getNumero());
            alterado.setBairro(imovelModel.getBairro());
            alterado.setCidade(imovelModel.getCidade());
            alterado.setUf(imovelModel.getUf());
            alterado.setCep(imovelModel.getCep());
            alterado.setTipo(imovelModel.getTipo());
            alterado.setDescricao(imovelModel.getDescricao());
            alterado.setValor(imovelModel.getValor());
            alterado.setDisponivel(imovelModel.isDisponivel());
            return imovelRepository.save(alterado);
        }
        return null;
    }
}
