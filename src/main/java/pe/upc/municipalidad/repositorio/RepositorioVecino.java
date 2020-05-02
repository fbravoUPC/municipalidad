package pe.upc.municipalidad.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pe.upc.municipalidad.entidades.Vecino;

public interface RepositorioVecino extends CrudRepository<Vecino,Long> {
    @Query("SELECT c FROM Vecino c WHERE c.dni=:dni")
    Vecino buscarVecino(@Param("dni") String dni);

}
