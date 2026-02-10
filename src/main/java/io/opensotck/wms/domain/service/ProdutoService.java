package io.opensotck.wms.domain.service;

import io.opensotck.wms.domain.model.Produto;
import io.opensotck.wms.domain.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public ResponseEntity<Produto> listarPorId(Long produtoId) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if(produtoOptional.isPresent()) {
            return ResponseEntity.ok(produtoOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    public List<Produto> listarPorNome(String produtoDescricao) {
        return produtoRepository.findByDescricaoContaining(produtoDescricao);
    }

}