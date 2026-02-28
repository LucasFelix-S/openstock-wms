package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.Produto;
import io.chronoslbm.wms.domain.repository.CategoriaRepository;
import io.chronoslbm.wms.domain.repository.ProdutoRepository;
import io.chronoslbm.wms.domain.repository.StatusRepository;
import io.chronoslbm.wms.domain.repository.UnidadeMedidaRepository;
import io.chronoslbm.wms.domain.exception.DomainException;
import io.chronoslbm.wms.domain.exception.EntityNotFoundException;
import io.chronoslbm.wms.domain.exception.StatusInvalidoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final StatusRepository statusRepository;
    private final UnidadeMedidaRepository unidadeMedidaRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository,
                          StatusRepository statusRepository,
                          UnidadeMedidaRepository unidadeMedidaRepository,
                          CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.statusRepository = statusRepository;
        this.unidadeMedidaRepository = unidadeMedidaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto listarPorId(Long produtoId) {
        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if(produtoOptional.isEmpty()) {
            throw new EntityNotFoundException("ID do produto não encontrado! ID= " + produtoId);
        }

        return produtoOptional.get();
    }

    public List<Produto> listarPorNome(String produtoDescricao) {
        return produtoRepository.findByDescricaoContaining(produtoDescricao);
    }

    @Transactional
    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto atualizar(Long produtoId, Produto produto) {

        if(!produtoRepository.existsById(produtoId)) {
            throw new EntityNotFoundException("ID do produto não encontrado! ID= " + produtoId);
        }

        validarProduto(produto);

        produto.setId(produtoId);
        Produto produtoAtualizado = produtoRepository.save(produto);
        return produtoAtualizado;
    }

    private void validarProduto(Produto produto) {
        if((produto.getStatus() == null || produto.getStatus().getId() == null)) {
            throw new StatusInvalidoException("Status não pode ser nulo!");
        }

        if(produto.getUnidadeMedida() == null || produto.getUnidadeMedida().getId() == null) {
            throw new DomainException("Unidade de medida não pode ser nulo!");
        }

        if(produto.getCategoria() == null || produto.getCategoria().getId() == null) {
            throw new DomainException("Categoria não pode ser nulo!");
        }

        Long statusId = produto.getStatus().getId();
        if(!statusRepository.existsById(statusId)) {
            throw new StatusInvalidoException("Status inválido!");
        }

        Long unidadeMedidaId = produto.getUnidadeMedida().getId();
        if(!unidadeMedidaRepository.existsById(unidadeMedidaId)) {
            throw new DomainException("Unidade de medida inválida!");
        }

        Long categoriaId = produto.getCategoria().getId();
        if(!categoriaRepository.existsById(categoriaId)) {
            throw new DomainException("Categoria inválida!");
        }
    }

}