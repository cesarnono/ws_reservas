package org.solver.app.reservaVuelo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Calendar;
import org.solver.app.reservaVuelo.Repository.TarifaVueloRepository;
import org.solver.app.reservaVuelo.Repository.UserRepository;
import org.solver.app.reservaVuelo.Repository.VueloRepository;
import org.solver.app.reservaVuelo.entity.TarifaVuelo;
import org.solver.app.reservaVuelo.entity.Usuario;
import org.solver.app.reservaVuelo.entity.Vuelo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@SpringBootApplication
public class ReservaVueloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservaVueloApplication.class, args);
    }

    /*@Bean
        InitializingBean   enviaBaseDatos(){
            return () ->{
                Usuario user = new Usuario();
                user.setIdentificacion("88254455");
                user.setNombreCompleto("César Aguirre Vega");
                user.setEdad(36);
                userRepository.save(user);
            };
        }*/
    @Bean
    public CommandLineRunner cargarDatos(VueloRepository vueloRepository, TarifaVueloRepository tarifaVueloRepository) {
        return (args) -> {
            TarifaVuelo tarifaViVuelo;

            tarifaViVuelo = tarifaVueloRepository.findByCiudadOrigenAndCiudadDestino("Bogota", "Cucuta");
            if (tarifaViVuelo == null) {
                tarifaViVuelo = new TarifaVuelo();
                tarifaViVuelo.setCiudadOrigen("Bogota");
                tarifaViVuelo.setCiudadDestino("Cúcuta");
                tarifaViVuelo.setPrecio(120000);
                tarifaViVuelo.setPorcentajeRecargoFinSemana(15);
                tarifaViVuelo.setPorcentajeRecargoManana(10);
                tarifaViVuelo.setPorcentajeRecargoTarde(7);
                tarifaViVuelo = tarifaVueloRepository.save(tarifaViVuelo);
            }
            if (tarifaViVuelo != null) {
                Vuelo vuelo = new Vuelo();
                vuelo.setNumeroAvion("AX125-u65");
                vuelo.setTarifaVuelo(tarifaViVuelo);
                vuelo.setFecha(Calendar.getInstance());
                vuelo.setHora(1100);
                vuelo.setTiempoDuracionMinutos(50);
                vueloRepository.save(vuelo);
                
                Vuelo vuelo2 = new Vuelo();
                vuelo2.setNumeroAvion("AX125-207yu");
                vuelo2.setTarifaVuelo(tarifaViVuelo);
                vuelo2.setFecha(Calendar.getInstance());
                vuelo2.setHora(1700);
                vuelo2.setTiempoDuracionMinutos(50);
                vueloRepository.save(vuelo2);
                
                Vuelo vuelo3 = new Vuelo();
                vuelo3.setNumeroAvion("AX125-lllp");
                vuelo3.setTarifaVuelo(tarifaViVuelo);
                vuelo3.setFecha(Calendar.getInstance());
                vuelo3.getFecha().add(Calendar.DAY_OF_YEAR, 1);
                vuelo3.setHora(800);
                vuelo3.setTiempoDuracionMinutos(50);
                vueloRepository.save(vuelo3);
            }
        };
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter converter
                = new MappingJackson2HttpMessageConverter(mapper);
        return converter;
    }

}
