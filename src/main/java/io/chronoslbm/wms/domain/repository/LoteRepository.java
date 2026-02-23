package io.chronoslbm.wms.domain.repository;

import io.chronoslbm.wms.domain.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> { }