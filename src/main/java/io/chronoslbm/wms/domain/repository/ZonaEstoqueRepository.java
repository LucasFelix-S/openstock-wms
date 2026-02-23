package io.chronoslbm.wms.domain.repository;

import io.chronoslbm.wms.domain.model.ZonaEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaEstoqueRepository extends JpaRepository<ZonaEstoque, Long> { }