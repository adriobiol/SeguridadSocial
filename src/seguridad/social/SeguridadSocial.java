package seguridad.social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeguridadSocial {
//Apuntes Hashmap  
//   private Map<String, Persona> personaMapDni = new HashMap<>();
//   private Map<String, Persona> personaMapNumeroSS = new HashMap<>();

    private List<Persona> personasarray;

    public SeguridadSocial() {
        personasarray = new ArrayList<>();
    }

    public void altaPersona(Persona persona1) {
        /*if (!personaMapDni.containsKey(persona1.getDNI()) && !personaMapNumeroSS.containsKey(persona1.getNumSeguridadSocial())){
         personaMapDni.put(persona1.getDNI(), persona1);
         personaMapNumeroSS.put(persona1.getNumSeguridadSocial(), persona1);
         }
         */

        boolean result = false;
        for (int i = 0; i < personasarray.size(); i++) {
            if (persona1.getDNI().equals(personasarray.get(i).getDNI()) || persona1.getNumSeguridadSocial().equals(personasarray.get(i).getNumSeguridadSocial())) {
                System.out.println("El DNI introducido no es válido o ya existe");
                result = true;
            }
        }
        if (result == false) {
            personasarray.add(persona1);
        }
    }

    public void bajaPersona(String dni) {
        personasarray.removeIf(persona1 -> persona1.getDNI().equals(dni));
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        int e = 0;
        for (int i = 0; i < personasarray.size(); i++) {
            if (personasarray.get(i).getDNI().equals(dni)) {
                e = i;
            }
        }
        return personasarray.get(e);
    }

    public Persona obtenerPersonaPorNumSS(String numseg) {
        int posicion = 0;
        for (int i = 0; i < personasarray.size(); i++) {
            if (personasarray.get(i).getNumSeguridadSocial().equals(numseg)) {
                posicion = i;
                break;
            }
        }
        return personasarray.get(posicion);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        List<Persona> persona1 = new ArrayList<>();
        for (int i = 0; i < personasarray.size(); i++) {
            if (personasarray.get(i).getSalario() >= min && personasarray.get(i).getSalario() <= max) {
                persona1.add(personasarray.get(i));
            }
        }
        return persona1;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad) {

        List<Persona> persona1 = new ArrayList<>();
        for (int i = 0; i < personasarray.size(); i++) {
            if (personasarray.get(i).getEdad() > edad) {
                persona1.add(personasarray.get(i));
            }
        }
        return persona1;
    }

    public List<Persona> obtenerTodas() {

        return personasarray;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{"
                + "Personasarray=" + personasarray
                + '}';
    }
}
