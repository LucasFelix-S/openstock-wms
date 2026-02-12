package io.opensotck.wms.domain.service;

import io.opensotck.wms.domain.model.Categoria;
import io.opensotck.wms.domain.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }



}