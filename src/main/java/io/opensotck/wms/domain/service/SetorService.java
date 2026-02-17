package io.opensotck.wms.domain.service;

import io.opensotck.wms.domain.model.Setor;
import io.opensotck.wms.domain.repository.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {
    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

}
