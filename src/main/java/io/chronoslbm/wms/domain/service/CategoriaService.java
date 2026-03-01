package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.Categoria;
import io.chronoslbm.wms.domain.repository.CategoriaRepository;
import io.chronoslbm.wms.domain.repository.StatusRepository;
import io.chronoslbm.wms.domain.exception.EntityNotFoundException;
import io.chronoslbm.wms.domain.exception.StatusInvalidoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final StatusRepository statusRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, StatusRepository statusRepository) {
        this.categoriaRepository = categoriaRepository;
        this.statusRepository = statusRepository;
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria listarPorId(Long categoriaId) {

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);

        if(categoriaOptional.isEmpty()) {
            throw new EntityNotFoundException("Categoria não encontrada. ID Categoria= " + categoriaId);
        }

        return categoriaOptional.get();
    }

    public List<Categoria> listarPorDescricao(String categoriaDescricao) {
        return categoriaRepository.findByDescricaoContaining(categoriaDescricao);
    }

    @Transactional
    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria atualizar(Long categoriaId, Categoria categoria) {

        if(!categoriaRepository.existsById(categoriaId)) {
            throw new EntityNotFoundException("Categoria não encontrada. ID Categoria= " + categoriaId);
        }

        if(categoria.getStatus() == null || categoria.getStatus().getId() == null) {
            throw new StatusInvalidoException("Status não pode ser nulo!");
        }

        if(!statusRepository.existsById(categoria.getStatus().getId())) {
            throw new StatusInvalidoException("Status inválido!");
        }

        categoria.setId(categoriaId);
        return categoriaRepository.save(categoria);
    }
}