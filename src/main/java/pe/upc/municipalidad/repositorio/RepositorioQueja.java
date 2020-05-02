package pe.upc.municipalidad.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.upc.municipalidad.entidades.Queja;



public interface RepositorioQueja extends JpaRepository<Queja,Long> {

}
