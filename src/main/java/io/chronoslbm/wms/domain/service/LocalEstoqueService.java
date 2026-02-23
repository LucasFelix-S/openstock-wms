package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.LocalEstoque;
import io.chronoslbm.wms.domain.repository.LocalEstoqueRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalEstoqueService {
    private final LocalEstoqueRepository localEstoqueRepository;

    public LocalEstoqueService(LocalEstoqueRepository localEstoqueRepository) {
        this.localEstoqueRepository = localEstoqueRepository;
    }

    public List<LocalEstoque> listarTodos() {
        return localEstoqueRepository.findAll();
    }

}