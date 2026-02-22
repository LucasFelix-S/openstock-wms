package io.chronoslbm.wms.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "lote_produto")
public class Lote {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produto_id")
    @NotNull
    private Long produtoId;

    @Column(name = "lote")
    @NotNull
    @NotBlank
    private String lote;

    @Column(name = "validade")
    @NotNull
    @NotBlank
    private LocalDateTime validade;
}