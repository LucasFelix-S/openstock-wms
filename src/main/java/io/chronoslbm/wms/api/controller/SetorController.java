package io.chronoslbm.wms.api.controller;

import io.chronoslbm.wms.domain.model.Setor;
import io.chronoslbm.wms.domain.service.SetorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setor")
public class SetorController {

    private SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @GetMapping
    public List<Setor> listarSetor() {
        return setorService.listarTodos();
    }

    @GetMapping("/id/{setorId}")
    public ResponseEntity<Setor> listarSetorPorId(@PathVariable Long setorId) {
        return setorService.listarPorId(setorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Setor criarSetor(@Valid @RequestBody Setor setor) {
        return setorService.criar(setor);
    }

    @PutMapping("/{setorId}")
    public ResponseEntity<Setor> atualizarSetor(@Valid @PathVariable Long setorId,
                                                @RequestBody Setor setor) {
        return setorService.atualizar(setorId, setor);
    }

}