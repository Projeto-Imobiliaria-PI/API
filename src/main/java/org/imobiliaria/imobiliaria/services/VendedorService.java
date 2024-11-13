package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.models.VendedorModel;
import org.imobiliaria.imobiliaria.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;

    public VendedorModel findById(Integer ra) {
        Optional<VendedorModel> vendedor = vendedorRepository.findById(ra);
        return vendedor.orElse(null);
    }

    public List<VendedorModel> listarTodosAbertos() {
        List<VendedorModel> vendedores = vendedorRepository.listarTodosAtivos();
        return vendedores;
    }

    public List<VendedorModel> listarTodosFechados() {
        List<VendedorModel> vendedores = vendedorRepository.listarTodosInativos();
        return vendedores;
    }

    public VendedorModel findByNome(String nome) {
        Optional<VendedorModel> vendedor = vendedorRepository.findByNome(nome);
        return vendedor.orElse(null);
    }

    public VendedorModel findByCpf(String cpf) {
        Optional<VendedorModel> vendedor = vendedorRepository.findByCpf(cpf);
        return vendedor.orElse(null);
    }

    public VendedorModel findByArea(String area) {
        Optional<VendedorModel> vendedor = vendedorRepository.findByArea(area);
        return vendedor.orElse(null);
    }

    public VendedorModel gravarVendedor(VendedorModel vendedorModel) {
        return vendedorRepository.save(vendedorModel);
    }

    public void deletarVendedor(Integer ra) {
        vendedorRepository.deleteById(ra);
    }

    public VendedorModel atualizarVendedor(Integer id, VendedorModel vendedorModel) {
        VendedorModel alterado = findById(id);
        if (alterado != null) {
            alterado.setNome(vendedorModel.getNome());
            alterado.setDataAdmissao(vendedorModel.getDataAdmissao());
            alterado.setAtivo(vendedorModel.isAtivo());
            alterado.setCpf(vendedorModel.getCpf());
            alterado.setArea(vendedorModel.getArea());
            return vendedorRepository.save(alterado);
        }
        return null;
    }
}
