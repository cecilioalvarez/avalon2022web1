package es.avalon.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    private String dni;
    private String nombre;
    private int edad;
    public Persona(String dni) {
        this.dni = dni;
    }
    
    
  
}
