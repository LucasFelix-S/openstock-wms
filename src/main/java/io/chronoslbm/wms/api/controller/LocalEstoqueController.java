package io.chronoslbm.wms.api.controller;

import io.chronoslbm.wms.domain.model.LocalEstoque;
import io.chronoslbm.wms.domain.service.LocalEstoqueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/localestoque")
public class LocalEstoqueController {
    private final LocalEstoqueService localEstoqueService;

    public LocalEstoqueController(LocalEstoqueService localEstoqueService) {
        this.localEstoqueService = localEstoqueService;
    }

    @GetMapping
    public List<LocalEstoque> listarLocalEstoque() {
        return localEstoqueService.listarTodos();
    }
}