package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.Setor;
import io.chronoslbm.wms.domain.repository.SetorRepository;
import io.chronoslbm.wms.domain.repository.StatusRepository;
import io.chronoslbm.wms.exception.EntityNotFoundException;
import io.chronoslbm.wms.exception.StatusInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    private SetorRepository setorRepository;
    private StatusRepository statusRepository;

    public SetorService(SetorRepository setorRepository, StatusRepository statusRepository) {
        this.setorRepository = setorRepository;
        this.statusRepository = statusRepository;
    }

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

    public Setor listarPorId(Long setorId) {
        Optional<Setor> setorOptional = setorRepository.findById(setorId);

        if(setorOptional.isEmpty()) {
            throw new EntityNotFoundException("ID do setor não encontrado! ID= " + setorId);
        }

        return setorOptional.get();
    }

    @Transactional
    public Setor criar(Setor setor) {
        return setorRepository.save(setor);
    }

    @Transactional
    public Setor atualizar(Long setorId, Setor setor) {

        if(!setorRepository.existsById(setorId)) {
            throw new EntityNotFoundException("ID do setor não encontrado! ID= " + setorId);
        }

        if(setor.getStatus() == null || setor.getStatus().getId() == null) {
            throw new StatusInvalidoException("Status não pode ser nulo!");
        }

        if(!statusRepository.existsById(setor.getStatus().getId())) {
            throw new StatusInvalidoException("Status inválido!");
        }

        setor.setId(setorId);
        Setor setorAtualizado = setorRepository.save(setor);

        return setorAtualizado;
    }

}
