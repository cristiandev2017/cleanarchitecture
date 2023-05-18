package co.com.sofk.arquitectura.usecase.persona;

import co.com.sofk.arquitectura.model.persona.Persona;
import co.com.sofk.arquitectura.model.persona.gateways.PersonaPublicador;
import co.com.sofk.arquitectura.model.persona.gateways.PersonaRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonaUseCase {

    private final PersonaRepository personaRepository;
    private final PersonaPublicador personaPublicador;

    public Flux <Persona> buscarPersonas(){
        return personaRepository.buscarPersonas();
    }

    public Mono <Persona> buscarPersonaPorId(Integer id){
        return personaRepository.buscarPersonaPorId(id);
    }

    public Mono<Persona> guardarPersona(Persona persona){
        return personaRepository.crearPersona(persona);
    }

    public Mono<String> buscarPersonasPorComando(){
        return personaPublicador.publicarPersonasViajeras();
    }

}
