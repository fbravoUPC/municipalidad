package pe.upc.municipalidad.controladorrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.municipalidad.entidades.Queja;
import pe.upc.municipalidad.servicios.ServiciosSmartQueja;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioSMARTRest {
    @Autowired
    private ServiciosSmartQueja serviciosSmartQueja;
    @PostMapping("muni/queja/registrar")
    public Queja registrar(@RequestBody Queja queja)
    {
        Queja q;
        try{
            q=serviciosSmartQueja.registrar(queja);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar ",e);
        }
        return q;
    }
    @GetMapping("muni/queja/{dni}")
    public List<Queja> obtenerQueja(@PathVariable("dni")int dni) {
        try {
            return serviciosSmartQueja.obtenerQueja(dni);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe producto", e);
        }
    }
}
