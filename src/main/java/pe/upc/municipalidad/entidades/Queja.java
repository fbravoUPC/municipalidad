package pe.upc.municipalidad.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QUEJA_TBL")
public class Queja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sustento;

    @ManyToOne
    @JoinColumn(name = "vecino_id")
    @JsonIgnore
    private Vecino vecino  ;

    @ManyToOne
    @JoinColumn(name = "estadoqueja_id")
    @JsonIgnore
    private EstadoQueja estadoQueja  ;

    @ManyToOne
    @JoinColumn(name = "tipoqueja_id")
    @JsonIgnore
    private TipoQueja tipoQueja  ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSustento() {
        return sustento;
    }

    public void setSustento(String sustento) {
        this.sustento = sustento;
    }

    public Vecino getVecino() {
        return vecino;
    }

    public void setVecino(Vecino vecino) {
        this.vecino = vecino;
    }

    public EstadoQueja getEstadoQueja() {
        return estadoQueja;
    }

    public void setEstadoQueja(EstadoQueja estadoQueja) {
        this.estadoQueja = estadoQueja;
    }

    public TipoQueja getTipoQueja() {
        return tipoQueja;
    }

    public void setTipoQueja(TipoQueja tipoQueja) {
        this.tipoQueja = tipoQueja;
    }
}
