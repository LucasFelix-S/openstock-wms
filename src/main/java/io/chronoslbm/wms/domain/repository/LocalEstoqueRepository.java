package io.chronoslbm.wms.domain.repository;

import io.chronoslbm.wms.domain.model.LocalEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalEstoqueRepository extends JpaRepository<LocalEstoque, Long> { }