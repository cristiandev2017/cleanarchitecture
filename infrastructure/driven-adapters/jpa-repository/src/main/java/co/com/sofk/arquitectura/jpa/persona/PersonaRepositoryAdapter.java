package co.com.sofk.arquitectura.jpa.persona;

import co.com.sofk.arquitectura.jpa.convertidor.Convertidor;
import co.com.sofk.arquitectura.jpa.helper.AdapterOperations;
import co.com.sofk.arquitectura.model.persona.Persona;
import co.com.sofk.arquitectura.model.persona.gateways.PersonaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaRepositoryAdapter extends AdapterOperations<Persona,PersonaData, Integer, PersonaDataRepository> implements PersonaRepository {

    public PersonaRepositoryAdapter(PersonaDataRepository repository, ObjectMapper mapper){
        super(repository, mapper, d -> mapper.mapBuilder(d, Persona.PersonaBuilder.class).build());
    }

    @Override
    public Flux <Persona> buscarPersonas() {
        List <PersonaData> personas = (List <PersonaData>) repository.findAll();

        if (!personas.isEmpty()){
            return Flux.fromIterable(Convertidor.convertirPersonasDataAPersonas(personas));
        }else{
            return Flux.empty();
        }
    }

    @Override
    public Mono <Persona> crearPersona(Persona persona) {
        if(persona != null){
            PersonaData nuevaPersonaData = Convertidor.convertirPersonaAPersonaData(persona);
            repository.save(nuevaPersonaData);
            return Mono.just(persona);
        }else{
            return Mono.empty();
        }
    }

    @Override
    public Mono <Persona> buscarPersonaPorId(Integer id) {
        Optional <PersonaData> personaData = repository.findById(id);
        return personaData
                .map(personaData1 ->
                        Mono.just(Convertidor.convertirPersonaDataAPersona(personaData1)))
                .orElse(Mono.empty());
    }
}
