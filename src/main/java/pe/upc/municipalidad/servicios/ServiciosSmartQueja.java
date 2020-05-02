package pe.upc.municipalidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.municipalidad.entidades.EstadoQueja;
import pe.upc.municipalidad.entidades.Queja;
import pe.upc.municipalidad.entidades.TipoQueja;
import pe.upc.municipalidad.entidades.Vecino;
import pe.upc.municipalidad.repositorio.RepositorioEstadoQueja;
import pe.upc.municipalidad.repositorio.RepositorioQueja;
import pe.upc.municipalidad.repositorio.RepositorioTipoQueja;
import pe.upc.municipalidad.repositorio.RepositorioVecino;

import java.util.List;

@Service
public class ServiciosSmartQueja {
    @Autowired
    private RepositorioQueja repositorioQueja;

    @Autowired
    private RepositorioVecino repositorioVecino;

    @Autowired
    private RepositorioTipoQueja repositorioTipoQueja;

    @Autowired
    private RepositorioEstadoQueja repositorioEstadoQueja;

    //
    public Vecino registrarVecino(Vecino vecino) throws Exception{
        Vecino q;
        if (vecino.getId() == null) {
            q = repositorioVecino.save(vecino);
        }
        else{
            System.out.println("Error al grabar");
            throw new Exception();
        }
        return q;

    }
    //-------------------------------------------------------------------------------
    //TipoQueja
    public TipoQueja registrarTipoQueja(TipoQueja tipoQueja) throws Exception{
        TipoQueja tq;
        if (tipoQueja.getId() == null) {
            tq = repositorioTipoQueja.save(tipoQueja);
        }
        else{
            System.out.println("Error al grabar");
            throw new Exception();
        }
        return tq;

    }
    //-------------------------------------------------------------------------------
    //Estado Queja
    public EstadoQueja registrarEstadoQueja(EstadoQueja estadoQueja) throws Exception{
        EstadoQueja eq;
        if (estadoQueja.getId() == null) {
            eq = repositorioEstadoQueja.save(estadoQueja);
        }
        else{
            System.out.println("Error al grabar");
            throw new Exception();
        }
        return eq;

    }

    public Queja registrarQueja(String dni,Queja queja){
        Vecino vecino=repositorioVecino.buscarVecino(dni);
        if (queja != null) {
            queja.setVecino(vecino);
            return repositorioQueja.save(queja);
        } else {
            return null;
        }
    }
    //Proceso Queja

    public List<Queja> obtenerQuejasVecinoDNI(String dni) {
        Vecino vecino  = repositorioVecino.buscarVecino(dni);
        return vecino.getQuejas();
    }
    public List<Queja> obtenerQuejas() {

        return repositorioQueja.findAll();
    }

/*
    public List<Queja> obtenerQueja(String dni) {
        return repositorioQueja.obtenerQueja(dni);
    }

 */
}
