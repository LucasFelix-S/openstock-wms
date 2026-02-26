package io.chronoslbm.wms.domain.repository;

import io.chronoslbm.wms.domain.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> { }