package io.opensotck.wms.api.controller;

import io.opensotck.wms.domain.model.Categoria;
import io.opensotck.wms.domain.service.CategoriaService;
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

    @GetMapping("/{categoriaId}")
    public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable Long categoriaId) {
        return categoriaService.listarPorId(categoriaId);
    }

    @GetMapping("/{categoriaDescricao}")
    public List<Categoria> listarCategoriaPorDescricao(@PathVariable String categoriaDescricao) {
        return categoriaService.listarPorDescricao(categoriaDescricao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.criar(categoria);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Categoria> atualizarCategoria(@Valid @PathVariable Long categoriaId,
                                                        @RequestBody Categoria categoria) {

        return categoriaService.atualizar(categoriaId, categoria);
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> deletarCategoria(@Valid @PathVariable Long categoriaId) {
        return categoriaService.deletar(categoriaId);
    }

}