package pe.upc.municipalidad.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ESTADOQUEJA_TBL")
public class EstadoQueja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="estadoqueja_id")
    private Long id;
    private String descripcion;

    @OneToMany(mappedBy = "estadoQueja", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Queja> quejas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }
}
