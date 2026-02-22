package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.Produto;
import io.chronoslbm.wms.domain.repository.ProdutoRepository;
import io.chronoslbm.wms.exception.StatusInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public ResponseEntity<Produto> atualizar(Long produtoId, Produto produto) {
        if(!produtoRepository.existsById(produtoId)) {
            ResponseEntity.notFound().build();
        }

        if((produto.getIdStatus() != 1 && produto.getIdStatus() != 2)) {
            throw new StatusInvalidoException("Status inválido!");
        }

        produto.setId(produtoId);
        Produto produtoAtualizado = produtoRepository.save(produto);
        return ResponseEntity.ok(produtoAtualizado);
    }

}