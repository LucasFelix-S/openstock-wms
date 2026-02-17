package io.opensotck.wms.api.controller;

import io.opensotck.wms.domain.model.Setor;
import io.opensotck.wms.domain.service.SetorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}