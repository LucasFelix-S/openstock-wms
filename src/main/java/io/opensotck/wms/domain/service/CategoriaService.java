package io.opensotck.wms.domain.service;

import io.opensotck.wms.domain.model.Categoria;
import io.opensotck.wms.domain.repository.CategoriaRepository;
import io.opensotck.wms.exception.StatusInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public ResponseEntity<Categoria> listarPorId(Long categoriaId) {

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);

        if(categoriaOptional.isPresent()) {
            return ResponseEntity.ok(categoriaOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    public List<Categoria> listarPorDescricao(String categoriaDescricao) {
        return categoriaRepository.findByDescricaoContaining(categoriaDescricao);
    }

    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public ResponseEntity<Categoria> atualizar(Long categoriaId, Categoria categoria) {

        if(!categoriaRepository.existsById(categoriaId)) {
            return ResponseEntity.notFound().build();
        }

        if((categoria.getIdStatus() != 1 && categoria.getIdStatus() != 2)) {
            throw new StatusInvalidoException("Status inválido!");
        }

        categoria.setId(categoriaId);

        Categoria categoriaAtualizada = categoriaRepository.save(categoria);
        return ResponseEntity.ok(categoriaAtualizada);
    }



}