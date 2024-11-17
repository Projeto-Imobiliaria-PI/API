package org.imobiliaria.imobiliaria.controllers;


import org.imobiliaria.imobiliaria.models.ImovelModel;
import org.imobiliaria.imobiliaria.repositories.ImovelRepository;
import org.imobiliaria.imobiliaria.services.ImovelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 33600)
@RestController
@RequestMapping("/imoveis")
public class ImovelController {

    private final ImovelService imovelService;

    private final ImovelRepository imovelRepository;

    public ImovelController(ImovelService imovelService, ImovelRepository imovelRepository) {
        this.imovelService = imovelService;
        this.imovelRepository = imovelRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImovelModel> findById(@PathVariable Integer id) {
        ImovelModel imovelModel = imovelService.findById(id);
        return ResponseEntity.ok().body(imovelModel);
    }

    @GetMapping(value = "/cep/{cep}")
    public ResponseEntity<List<ImovelModel>> listarPorCep(@PathVariable String cep) {
        List<ImovelModel> imovelModel = imovelService.findByCep(cep);
        return ResponseEntity.ok().body(imovelModel);
    }

    @GetMapping(value = "/disponiveis")
    public ResponseEntity<List<ImovelModel>> listarDisponiveis() {
        List<ImovelModel> imovelModel = imovelService.listarTodosDisponiveis();
        return ResponseEntity.ok().body(imovelModel);
    }

    @GetMapping(value = "/indisponiveis")
    public ResponseEntity<List<ImovelModel>> listarVendidos() {
        List<ImovelModel> imovelModel = imovelService.listarTodosIndisponiveis();
        return ResponseEntity.ok().body(imovelModel);
    }

    @GetMapping(value = "/endereco/{endereco}")
    public ResponseEntity<List<ImovelModel>> listarPorEndereco(@PathVariable String endereco) {
        List<ImovelModel> imovelModel = imovelService.findByEndereco(endereco);
        return ResponseEntity.ok().body(imovelModel);
    }

    @GetMapping(value = "/tipo/{tipo}")
    public ResponseEntity<List<ImovelModel>> listarPorTipo(@PathVariable String tipo) {
        List<ImovelModel> imovelModel = imovelService.findByTipo(tipo);
        return ResponseEntity.ok().body(imovelModel);
    }


    @GetMapping
    public ResponseEntity<List<ImovelModel>> listarTodos() {
        List<ImovelModel> imovelModel = imovelRepository.findAll();
        return ResponseEntity.ok().body(imovelModel);
    }

    @PostMapping
    public ResponseEntity<ImovelModel> gravarImovel(@RequestBody ImovelModel imovelModel) {
        ImovelModel imovel = imovelService.gravarImovel(imovelModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imovel.getId()).toUri();
        return ResponseEntity.created(uri).body(imovel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarImovel(@PathVariable Integer id) {
        imovelService.deletarImovel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ImovelModel> atualizarImovel(@PathVariable Integer id, @RequestBody ImovelModel imovelModel) {
        ImovelModel imovel = imovelService.atualizarImovel(id, imovelModel);
        return ResponseEntity.ok().body(imovel);
    }


}
