package org.imobiliaria.imobiliaria.services;

import org.imobiliaria.imobiliaria.entities.Vendedor;
import org.imobiliaria.imobiliaria.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImobiliariaService {
    @Autowired
    VendedorRepository vendedorRepository;

    public Vendedor findById(Integer ra) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(ra);
        return vendedor.orElse(null);
    }


    public List<Vendedor> listarTodosAbertos() {
        List<Vendedor> vendedores = vendedorRepository.listarTodosAbertos();
        return vendedores;
    }

    public List<Vendedor> listarTodosFechados() {
        List<Vendedor> vendedores = vendedorRepository.listarTodosFechados();
        return vendedores;
    }

    public List<Vendedor> listarTodos() {
        List<Vendedor> vendedores = vendedorRepository.findAll();
        return vendedores;
    }

    public Vendedor findByNome(String nome) {
        Optional<Vendedor> vendedor = vendedorRepository.findByNome(nome);
        return vendedor.orElse(null);
    }

    public Vendedor findByCpf(String cpf) {
        Optional<Vendedor> vendedor = vendedorRepository.findByCpf(cpf);
        return vendedor.orElse(null);
    }

    public Vendedor findByArea(String area) {
        Optional<Vendedor> vendedor = vendedorRepository.findByArea(area);
        return vendedor.orElse(null);
    }

    public Vendedor gravarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public void deletarVendedor(Integer ra) {
        vendedorRepository.deleteById(ra);
    }

    public Vendedor atualizarVendedor(Integer id, Vendedor vendedor) {
        Vendedor alterado = findById(id);
        if (alterado != null) {
            alterado.setNome(vendedor.getNome());
            alterado.setDataAdmissao(vendedor.getDataAdmissao());
            alterado.setAtivo(vendedor.isAtivo());
            alterado.setCpf(vendedor.getCpf());
            alterado.setArea(vendedor.getArea());
            return vendedorRepository.save(alterado);
        }
        return null;
    }
}
