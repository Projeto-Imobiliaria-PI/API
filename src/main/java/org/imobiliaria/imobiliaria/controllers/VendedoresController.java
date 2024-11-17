package org.imobiliaria.imobiliaria.controllers;


import org.imobiliaria.imobiliaria.models.VendedorModel;
import org.imobiliaria.imobiliaria.repositories.VendedorRepository;
import org.imobiliaria.imobiliaria.services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 33600)
@RestController
@RequestMapping("/vendedores")
public class VendedoresController {

    private final VendedorService vendedorService;
    private final VendedorRepository vendedorRepository;

    public VendedoresController(VendedorService vendedorService, VendedorRepository vendedorRepository) {
        this.vendedorService = vendedorService;
        this.vendedorRepository = vendedorRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendedorModel> findById(@PathVariable Integer id) {
        VendedorModel vendedorModel = vendedorService.findById(id);
        return ResponseEntity.ok().body(vendedorModel);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<VendedorModel> listarPorNome(@PathVariable String nome) {
        VendedorModel vendedorModel = vendedorService.findByNome(nome);
        return ResponseEntity.ok().body(vendedorModel);
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<VendedorModel> listarPorCpf(@PathVariable String cpf) {
        VendedorModel vendedorModel = vendedorService.findByCpf(cpf);
        return ResponseEntity.ok().body(vendedorModel);
    }

    @GetMapping(value = "/area/{area}")
    public ResponseEntity<VendedorModel> listarPorArea(@PathVariable String area) {
        VendedorModel vendedorModel = vendedorService.findByArea(area);
        return ResponseEntity.ok().body(vendedorModel);
    }

    @GetMapping(value = "/abertos")
    public ResponseEntity<List<VendedorModel>> listarAbertos() {
        List<VendedorModel> vendedorModel = vendedorService.listarTodosAbertos();
        return ResponseEntity.ok().body(vendedorModel);
    }

    @GetMapping(value = "/fechados")
    public ResponseEntity<List<VendedorModel>> listarFechados() {
        List<VendedorModel> vendedorModel = vendedorService.listarTodosFechados();
        return ResponseEntity.ok().body(vendedorModel);
    }

    @GetMapping
    public ResponseEntity<List<VendedorModel>> listarTodos() {
        List<VendedorModel> vendedorModel = vendedorRepository.findAll();
        return ResponseEntity.ok().body(vendedorModel);
    }


    @PostMapping
    public ResponseEntity<VendedorModel> gravarVendedor(@RequestBody VendedorModel vendedorModel) {
        vendedorModel = vendedorService.gravarVendedor(vendedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedorModel.getRA()).toUri();
        return ResponseEntity.created(uri).body(vendedorModel);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Integer id) {
        vendedorService.deletarVendedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendedorModel> atualizarVendedor(@PathVariable Integer id, @RequestBody VendedorModel vendedorModel) {
        VendedorModel alterado = vendedorService.atualizarVendedor(id, vendedorModel);
        return ResponseEntity.ok().body(alterado);
    }

}
