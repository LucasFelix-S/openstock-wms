package io.opensotck.wms.domain.repository;

import io.opensotck.wms.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> { }