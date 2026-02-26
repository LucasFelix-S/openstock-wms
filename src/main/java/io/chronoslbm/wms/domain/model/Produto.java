package io.chronoslbm.wms.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "produto")
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    @NotNull
    @NotBlank
    @Size(min= 3, max=255)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "unidade_medida_id")
    private UnidadeMedida unidadeMedida;

}