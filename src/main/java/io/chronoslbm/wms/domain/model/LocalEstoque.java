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
public class LocalEstoque {

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

    @Column(name = "rua")
    @NotNull
    @NotBlank
    private String rua;

    @Column(name = "modulo")
    @NotNull
    @NotBlank
    private String modulo;

    @Column(name = "nivel")
    @NotNull
    @NotBlank
    private String nivel;

    @Column(name = "container")
    @NotNull
    @NotBlank
    private String container;

    @JoinColumn(name = "zona_estoque_id")
    @ManyToOne
    private ZonaEstoque zonaEstoque;

    @JoinColumn(name = "setor_id")
    @ManyToOne
    private Setor setor;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private Status status;
}