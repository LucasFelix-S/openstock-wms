package io.opensotck.wms.domain.model;

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

    @Column(name = "categoria_id")
    @NotNull
    @NotBlank
    private String idCategoria;

    @Column(name = "status_id")
    @NotNull
    @NotBlank
    @Min(1) //<- regra para o usuário escolher ativo (1)
    @Max(2) //<- regra para o usuário escolher inativo (2)
    private String idStatus;

    @Column(name = "unidade_medida_id")
    @NotNull
    @NotBlank
    private String idUnidadeMedida;


}