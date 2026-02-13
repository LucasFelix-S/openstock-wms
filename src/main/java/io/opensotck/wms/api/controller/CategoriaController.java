package io.opensotck.wms.api.controller;

import io.opensotck.wms.domain.model.Categoria;
import io.opensotck.wms.domain.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return categoriaService.listarPorId(categoriaId);
    }

    @GetMapping("/descricao/{categoriaDescricao}")
    public List<Categoria> listarCategoriaPorDescricao(@PathVariable String categoriaDescricao) {
        return categoriaService.listarPorDescricao(categoriaDescricao);
    }

}
