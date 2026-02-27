package io.chronoslbm.wms.api.controller;

import io.chronoslbm.wms.domain.model.Produto;
import io.chronoslbm.wms.domain.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodosProduto() {
        return produtoService.listarTodos();
    }

    @GetMapping("/id/{produtoId}")
    public ResponseEntity<Produto> listarProdutoPorId(@PathVariable Long produtoId) {
        Produto produto = produtoService.listarPorId(produtoId);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/descricao/{produtoDescricao}")
    public List<Produto> listarProdutoPorDescricao(@PathVariable String produtoDescricao) {
        return produtoService.listarPorNome(produtoDescricao);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@Valid @RequestBody Produto produto) {
        return produtoService.criar(produto);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long produtoId, @Valid
    @RequestBody Produto produto) {
        produtoService.atualizar(produtoId, produto);
        return ResponseEntity.ok(produto);
    }
}