package co.com.sofk.arquitectura.model.persona.gateways;

import co.com.sofk.arquitectura.model.persona.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository {

    Flux<Persona> buscarPersonas();
    Mono <Persona> crearPersona(Persona persona);
    Mono<Persona> buscarPersona(Integer id);
}
