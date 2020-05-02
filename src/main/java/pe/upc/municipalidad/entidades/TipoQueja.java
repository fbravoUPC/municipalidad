package pe.upc.municipalidad.entidades;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TIPOQUEJA_TBL")
public class TipoQueja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipoqueja_id")
    private Long id;
    private String descripcion;


    @OneToMany(mappedBy = "tipoQueja", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
