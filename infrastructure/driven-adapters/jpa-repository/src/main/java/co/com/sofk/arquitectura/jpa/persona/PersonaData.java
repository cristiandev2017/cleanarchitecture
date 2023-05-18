package co.com.sofk.arquitectura.jpa.persona;

import co.com.sofk.arquitectura.jpa.viaje.ViajeData;
import co.com.sofk.arquitectura.model.viaje.Viaje;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "PERSONA")
public class PersonaData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_persona")
  private Integer idPersona;

  private String nombre;

  @Column(name="fecha_nacimiento")
  private Date fechaNacimiento;

  @Column(name="tipo_sangre")
  private String tipoSangre;

  @OneToMany(fetch= FetchType.EAGER)
  @JoinColumn(name = "id_persona")
  private List<ViajeData> viajes;

}
