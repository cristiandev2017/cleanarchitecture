package co.com.sofk.arquitectura.jpa.persona;

import co.com.sofk.arquitectura.jpa.helper.AdapterOperations;
import co.com.sofk.arquitectura.model.persona.Persona;
import co.com.sofk.arquitectura.model.persona.gateways.PersonaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonaRepositoryAdapter extends AdapterOperations<Persona,PersonaData, Integer, PersonaDataRepository> implements PersonaRepository {

    public PersonaRepositoryAdapter(PersonaDataRepository repository, ObjectMapper mapper){
        super(repository, mapper, d -> mapper.mapBuilder(d, Persona.PersonaBuilder.class).build());
    }

    @Override
    public Flux <Persona> buscarPersonas() {
        return null;
    }

    @Override
    public Mono <Persona> crearPersona(Persona persona) {
        return null;
    }

    @Override
    public Mono <Persona> buscarPersona(Integer id) {
        return null;
    }
}
