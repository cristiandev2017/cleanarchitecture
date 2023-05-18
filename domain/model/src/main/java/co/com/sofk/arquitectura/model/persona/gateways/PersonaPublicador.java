package co.com.sofk.arquitectura.model.persona.gateways;

import reactor.core.publisher.Mono;

public interface PersonaPublicador {

    Mono <String> publicarPersonasViajeras();
}
