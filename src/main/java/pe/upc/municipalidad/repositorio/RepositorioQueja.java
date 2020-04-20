package pe.upc.municipalidad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.municipalidad.entidades.Queja;

import java.util.List;

public interface RepositorioQueja extends JpaRepository<Queja,Long> {
    @Query("select a from Queja a where a.dni=:dni")
    public List<Queja> obtenerQueja(@Param("dni") int dni);
}
