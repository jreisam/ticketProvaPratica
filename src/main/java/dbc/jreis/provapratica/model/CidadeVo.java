package dbc.jreis.provapratica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CIDADE")
public class CidadeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_cidade", nullable = false)
    private Integer codigo;

    @Column(name = "cd_uf", nullable = false)
    private UFVo uf;

    @Column(name = "ds_nome_cidade", length = 50, nullable = false)
    private String nomeCidade;

    @Column(name = "ds_codigo_ibge", length = 10)
    private String codigoIBGE;

    @Enumerated
    @Column(name = "fl_faixa_populacional", length = 1, nullable = false)
    private EnumFaixaPopulacional faixaPopulacional;

    @Column(name = "fl_capital", length = 1, nullable = false)
    private EnumBoolean capital;


    private boolean visivelNoMapa;

    @JsonIgnore
    public boolean isVisivelNoMapa() {
        if (faixaPopulacional == EnumFaixaPopulacional.BAIXA)
            return true;
        else
            return false;
    }

    enum EnumFaixaPopulacional {
        BAIXA('B'), MEDIA('M'), ALTA('A');
        private Character abrev;

        public Character getAbrev() {
            return this.abrev;
        }

        EnumFaixaPopulacional(Character abrev) {
            this.abrev = abrev;
        }
    }

    enum EnumBoolean {
        SIM('S'), NAO('N');
        private Character abrev;

        public Character getAbrev() {
            return this.abrev;
        }

        EnumBoolean(Character abrev) {
            this.abrev = abrev;
        }
    }
}