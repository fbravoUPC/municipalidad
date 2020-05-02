package pe.upc.municipalidad.controladorrest;

import jdk.nashorn.internal.ir.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.municipalidad.entidades.EstadoQueja;
import pe.upc.municipalidad.entidades.Queja;
import pe.upc.municipalidad.entidades.TipoQueja;
import pe.upc.municipalidad.entidades.Vecino;
import pe.upc.municipalidad.jms.JmsProducerConsumer;
import pe.upc.municipalidad.servicios.ServiciosSmartQueja;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioSMARTRest {
    @Autowired
    private ServiciosSmartQueja serviciosSmartQueja;
    @Autowired
    private JmsProducerConsumer jmsProducer;
    //-------------------------------------------------------------------------------
    //Vecino
    @PostMapping("registrar/vecino")
    public Vecino registrar(@RequestBody Vecino vecino)
    {
        Vecino v;
        try{
            v=serviciosSmartQueja.registrarVecino(vecino);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar ",e);
        }
        return v;
    }

    //-------------------------------------------------------------------------------
    //TipoQueja
    @PostMapping("registrar/tipoqueja")
    public TipoQueja registrar(@RequestBody TipoQueja tipoQueja)
    {
        TipoQueja tq;
        try{
            tq=serviciosSmartQueja.registrarTipoQueja(tipoQueja);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar ",e);
        }
        return tq;
    }

    //-------------------------------------------------------------------------------
    //EstadoQueja
    @PostMapping("registrar/estadoqueja")
    public EstadoQueja registrar(@RequestBody EstadoQueja estadoQueja)
    {
        EstadoQueja eq;
        try{
            eq=serviciosSmartQueja.registrarEstadoQueja(estadoQueja);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar ",e);
        }
        return eq;
    }


    //-------------------------------------------------------------------------------
    //Queja
    @PostMapping("registrar/estado/{estadoid}/tipo/{tipoid}/vecino/{dni}/queja")
    public Queja registrar(@PathVariable(value = "estadoid") Long estadoid,
                           @PathVariable(value = "tipoid") Long tipoid,
                           @PathVariable(value = "dni") String dni,
                           @RequestBody Queja queja)
    {
        return serviciosSmartQueja.registrarQueja(estadoid,tipoid,dni,queja);
    }

    @GetMapping("obtenerQueja/{dni}")
    public List<Queja> obtenerQueja(@PathVariable("dni")String dni) {
        try {
            return serviciosSmartQueja.obtenerQuejasVecinoDNI(dni);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe producto", e);
        }

    }

    @GetMapping("/quejas")
    public List<Queja> getAllUsers() {
        return serviciosSmartQueja.obtenerQuejas();
    }

    @GetMapping("/quejas/{dni}")
    public String enviar(@PathVariable(value = "dni") String dni) {
        jmsProducer.enviarRecibir(dni);
        return "OK!";
    }

}
