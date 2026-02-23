package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.Lote;
import io.chronoslbm.wms.domain.repository.LoteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoteService {
    private final LoteRepository loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    public List<Lote> listarTodos() {
        return loteRepository.findAll();
    }

}