package io.chronoslbm.wms.domain.repository;

import io.chronoslbm.wms.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByDescricaoContaining(String descricao);

}