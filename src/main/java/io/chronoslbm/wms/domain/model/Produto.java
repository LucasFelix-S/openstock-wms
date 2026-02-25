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

    @Column(name = "categoria_id")
    @NotNull
    private int idCategoria;

//    @Column(name = "status_id")
//    @NotNull
//    @Min(1) //<- regra que eu criei para o usuário escolher ativo (1)
//    @Max(2) //<- regra que eu criei para o usuário escolher inativo (2)
//    private int idStatus;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;


    @Column(name = "unidade_medida_id")
    @NotNull
    private int idUnidadeMedida;
}