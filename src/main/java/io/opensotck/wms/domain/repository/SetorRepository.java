package io.opensotck.wms.domain.repository;

import io.opensotck.wms.domain.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> { }