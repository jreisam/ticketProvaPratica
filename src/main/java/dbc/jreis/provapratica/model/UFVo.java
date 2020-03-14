package dbc.jreis.provapratica.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "UF")
public class UFVo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cd_uf", length = 2, nullable = false)
    private String sigla;
    @Column(name = "descricao", length = 30, nullable = false)
    private String descricao;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = CidadeVo.class)
    private Set<CidadeVo> cidadeVos;


}