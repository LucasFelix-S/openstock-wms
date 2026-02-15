package io.opensotck.wms.api.controller;

import io.opensotck.wms.domain.model.Produto;
import io.opensotck.wms.domain.service.ProdutoService;
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
        return produtoService.listarPorId(produtoId);
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

    @PutMapping("/atualizar/{produtoId}")
    public ResponseEntity<Produto> atualizarProduto(@Valid @PathVariable Long produtoId,
                                                    @RequestBody Produto produto) {

        return produtoService.atualizar(produtoId, produto);
    }
}