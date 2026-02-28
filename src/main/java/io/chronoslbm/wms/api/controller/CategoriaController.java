package io.chronoslbm.wms.api.controller;

import io.chronoslbm.wms.domain.model.Categoria;
import io.chronoslbm.wms.domain.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listarCategoria() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/id/{categoriaId}")
    public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable Long categoriaId) {
        Categoria categoria = categoriaService.listarPorId(categoriaId);
        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/descricao/{categoriaDescricao}")
    public List<Categoria> listarCategoriaPorDescricao(@PathVariable String categoriaDescricao) {
        return categoriaService.listarPorDescricao(categoriaDescricao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criarCategoria(@Valid @RequestBody Categoria categoria) {
        return categoriaService.criar(categoria);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long categoriaId,
                                                        @Valid @RequestBody Categoria categoria) {
        categoriaService.atualizar(categoriaId, categoria);
        return ResponseEntity.ok(categoria);
    }
}