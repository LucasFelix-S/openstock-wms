package io.opensotck.wms.api.controller;

import io.opensotck.wms.domain.model.Produto;
import io.opensotck.wms.domain.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodosProdutos() {
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

}