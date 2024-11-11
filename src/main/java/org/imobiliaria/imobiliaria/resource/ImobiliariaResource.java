package org.imobiliaria.imobiliaria.resource;


import org.imobiliaria.imobiliaria.entities.Vendedor;
import org.imobiliaria.imobiliaria.repositories.VendedorRepository;
import org.imobiliaria.imobiliaria.services.ImobiliariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 33600)
@RestController
@RequestMapping("/imobiliaria")
public class ImobiliariaResource {

    private final ImobiliariaService imobiliariaService;
    private final VendedorRepository vendedorRepository;

    public ImobiliariaResource(ImobiliariaService imobiliariaService, VendedorRepository vendedorRepository) {
        this.imobiliariaService = imobiliariaService;
        this.vendedorRepository = vendedorRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vendedor> findById(@PathVariable Integer id) {
        Vendedor vendedor = imobiliariaService.findById(id);
        return ResponseEntity.ok().body(vendedor);
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Vendedor> listarPorNome(@PathVariable String nome) {
        Vendedor vendedor = imobiliariaService.findByNome(nome);
        return ResponseEntity.ok().body(vendedor);
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<Vendedor> listarPorCpf(@PathVariable String cpf) {
        Vendedor vendedor = imobiliariaService.findByCpf(cpf);
        return ResponseEntity.ok().body(vendedor);
    }

    @GetMapping(value = "/area/{area}")
    public ResponseEntity<Vendedor> listarPorArea(@PathVariable String area) {
        Vendedor vendedor = imobiliariaService.findByArea(area);
        return ResponseEntity.ok().body(vendedor);
    }

    @GetMapping(value = "/abertos")
    public ResponseEntity<List<Vendedor>> listarAbertos() {
        List<Vendedor> vendedor = imobiliariaService.listarTodosAbertos();
        return ResponseEntity.ok().body(vendedor);
    }

    @GetMapping(value = "/fechados")
    public ResponseEntity<List<Vendedor>> listarFechados() {
        List<Vendedor> vendedor = imobiliariaService.listarTodosFechados();
        return ResponseEntity.ok().body(vendedor);
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> listarTodos() {
        List<Vendedor> vendedor = vendedorRepository.findAll();
        return ResponseEntity.ok().body(vendedor);
    }


    @PostMapping
    public ResponseEntity<Vendedor> gravarVendedor(@RequestBody Vendedor vendedor) {
        vendedor = imobiliariaService.gravarVendedor(vendedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedor.getRA()).toUri();
        return ResponseEntity.created(uri).body(vendedor);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Integer id) {
        imobiliariaService.deletarVendedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vendedor> atualizarVendedor(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        Vendedor alterado = imobiliariaService.atualizarVendedor(id, vendedor);
        return ResponseEntity.ok().body(alterado);
    }

}
