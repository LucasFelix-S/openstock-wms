package io.chronoslbm.wms.domain.repository;

import io.chronoslbm.wms.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByDescricaoContaining(String descricao);

}