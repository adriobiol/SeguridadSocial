package seguridad.social;

import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocial2{

    private Map <String, Persona> personaMapDni= new HashMap();
    private Map <String, Persona> personaMapNumeroSS= new HashMap();

    public void altaPersona(Persona persona1) {
        if(!personaMapDni.containsKey(persona1.getDNI()) && !personaMapNumeroSS.containsKey(persona1.getNumSeguridadSocial())){
            personaMapDni.put(persona1.getDNI(), persona1);
            personaMapNumeroSS.put(persona1.getNumSeguridadSocial(), persona1);
        }
    }
    public void bajaPersona(String dni) {
        if(personaMapDni.containsKey(dni)){
            personaMapNumeroSS.remove(personaMapDni.get(dni).getNumSeguridadSocial());
            personaMapDni.remove(dni);
        }
    }
    public Persona obtenerPersonaPorDNI(String dni) {
        return personaMapDni.get(dni);
    }
    public Persona obtenerPersonaPorNumSS(String numseg) {
        return personaMapNumeroSS.get(numseg);
    }
    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        return personaMapNumeroSS.values().stream().filter(persona -> persona.getSalario()>=min && persona.getSalario()<=max).collect(Collectors.toList());
    }
    public Persona obtenerPersonaSalarioMax(){
        return personaMapDni.values().stream().max(Comparator.comparing(Persona::getSalario)).get();
    }
    public Persona obtenerPersonaSalarioMin(){
        return personaMapDni.values().stream().min(Comparator.comparing(Persona::getSalario)).get();
    }
    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return personaMapDni.values().stream().filter(persona -> persona.getEdad()>edad).collect(Collectors.toList());
    }
    public List<Persona> obtenerTodas(){
        return new ArrayList<>(personaMapDni.values());
    }
}