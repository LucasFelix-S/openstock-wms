package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.ZonaEstoque;
import io.chronoslbm.wms.domain.repository.ZonaEstoqueRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZonaEstoqueService {
    private final ZonaEstoqueRepository zonaEstoqueRepository;

    public ZonaEstoqueService(ZonaEstoqueRepository zonaEstoqueRepository) {
        this.zonaEstoqueRepository = zonaEstoqueRepository;
    }

    public List<ZonaEstoque> listarTodos() {
        return zonaEstoqueRepository.findAll();
    }

}