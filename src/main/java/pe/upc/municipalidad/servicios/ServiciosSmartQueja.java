package pe.upc.municipalidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.municipalidad.entidades.Queja;
import pe.upc.municipalidad.repositorio.RepositorioQueja;

import java.util.List;

@Service
public class ServiciosSmartQueja {
    @Autowired
    private RepositorioQueja repositorioQueja;

    public Queja registrar(Queja queja) throws Exception{
        Queja q;
        if (queja.getId() == null) {
            q = repositorioQueja.save(queja);
        }
        else{
            System.out.println("Error al grabar");
            throw new Exception();
        }
        return q;

    }

    public List<Queja> obtenerQueja(int dni) {
        return repositorioQueja.obtenerQueja(dni);
    }
}
