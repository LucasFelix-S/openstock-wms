package io.chronoslbm.wms.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "zona_estoque")
public class ZonaEstoque {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    @NotNull
    @NotBlank
    private String codigo;

    @Column(name = "descricao")
    @NotNull
    @NotBlank
    private String descricao;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private Status status;
}