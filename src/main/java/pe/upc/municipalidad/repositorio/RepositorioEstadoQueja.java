package pe.upc.municipalidad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.municipalidad.entidades.EstadoQueja;

public interface RepositorioEstadoQueja extends JpaRepository<EstadoQueja,Long> {
}
