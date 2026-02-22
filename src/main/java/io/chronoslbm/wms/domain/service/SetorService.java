package io.chronoslbm.wms.domain.service;

import io.chronoslbm.wms.domain.model.Setor;
import io.chronoslbm.wms.domain.repository.SetorRepository;
import io.chronoslbm.wms.exception.StatusInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    private SetorRepository setorRepository;

    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

    public ResponseEntity<Setor> listarPorId(Long setorId) {
        Optional<Setor> setorOptional = setorRepository.findById(setorId);

        if(setorOptional.isPresent()) {
           return ResponseEntity.ok(setorOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @Transactional
    public Setor criar(Setor setor) {
        return setorRepository.save(setor);
    }

    @Transactional
    public ResponseEntity<Setor> atualizar(Long setorId, Setor setor) {

        if(!setorRepository.existsById(setorId)) {
            return ResponseEntity.notFound().build();
        }

        if((setor.getIdStatus() != 1 && setor.getIdStatus() != 2)) {
            throw new StatusInvalidoException("Status inválido!");
        }

        setor.setId(setorId);
        Setor setorAtualizado = setorRepository.save(setor);

        return ResponseEntity.ok(setorAtualizado);
    }

}
