package io.chronoslbm.wms.api.controller;

import io.chronoslbm.wms.domain.model.Lote;
import io.chronoslbm.wms.domain.service.LoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lote")
public class LoteController {
    private final LoteService loteService;

    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    @GetMapping
    public List<Lote> listarLote() {
        return loteService.listarTodos();
    }

}