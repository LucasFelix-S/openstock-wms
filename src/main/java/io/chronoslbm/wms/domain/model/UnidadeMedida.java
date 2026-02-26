package io.chronoslbm.wms.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@Setter
@Table(name = "unidade_medida")
public class UnidadeMedida {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;
}