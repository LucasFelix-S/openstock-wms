package io.opensotck.wms.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Column(name = "categoria_id")
    private String idCategoria;

    @Column(name = "status_id")
    @NotNull
    @NotBlank
    private String idStatus;

    @Column(name = "unidade_medida_id")
    @NotNull
    @NotBlank
    private String idUnidadeMedida;
}