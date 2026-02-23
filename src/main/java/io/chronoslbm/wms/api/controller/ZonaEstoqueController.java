package io.chronoslbm.wms.api.controller;

import io.chronoslbm.wms.domain.model.ZonaEstoque;
import io.chronoslbm.wms.domain.service.ZonaEstoqueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zonaestoque")
public class ZonaEstoqueController {
    private final ZonaEstoqueService zonaEstoqueService;

    public ZonaEstoqueController(ZonaEstoqueService zonaEstoqueService) {
        this.zonaEstoqueService = zonaEstoqueService;
    }

    public List<ZonaEstoque> listarZonaEstoque() {
        return zonaEstoqueService.listarTodos();
    }

}