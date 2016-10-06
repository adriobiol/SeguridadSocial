package seguridad.social;

import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocial2{

    private Map <String, Persona> personaMapDNI= new HashMap();
    private Map <String, Persona> personaMapSS= new HashMap();

    public void altaPersona(Persona persona) {
        if(!personaMapDNI.containsKey(persona.getDNI()) && !personaMapSS.containsKey(persona.getNumSeguridadSocial())){
            personaMapDNI.put(persona.getDNI(), persona);
            personaMapSS.put(persona.getNumSeguridadSocial(), persona);
        }
    }
    public void bajaPersona(String dni) {
        if(personaMapDNI.containsKey(dni)){
            personaMapSS.remove(personaMapDNI.get(dni).getNumSeguridadSocial());
            personaMapDNI.remove(dni);
        }
    }
    public Persona obtenerPersonaPorDNI(String dni) {
        return personaMapDNI.get(dni);
    }
    public Persona obtenerPersonaPorNumSS(String numSS) {
        return personaMapSS.get(numSS);
    }
    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        return personaMapSS.values().stream().filter(persona -> persona.getSalario()>=min && persona.getSalario()<=max).collect(Collectors.toList());
    }
    public Persona obtenerPersonaSalarioMax(){
        return personaMapDNI.values().stream().max(Comparator.comparing(Persona::getSalario)).get();
    }
    public Persona obtenerPersonaSalarioMin(){
        return personaMapDNI.values().stream().min(Comparator.comparing(Persona::getSalario)).get();
    }
    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return personaMapDNI.values().stream().filter(persona -> persona.getEdad()>edad).collect(Collectors.toList());
    }
    public List<Persona> obtenerTodas(){
        return new ArrayList<>(personaMapDNI.values());
    }
}