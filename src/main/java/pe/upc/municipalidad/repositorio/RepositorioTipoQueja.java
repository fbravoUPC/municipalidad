package pe.upc.municipalidad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.municipalidad.entidades.TipoQueja;

public interface RepositorioTipoQueja extends JpaRepository<TipoQueja,Long> {
}
