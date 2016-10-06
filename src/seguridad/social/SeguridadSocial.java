package seguridad.social;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeguridadSocial {
    
    private Map<String, Persona> personaMapDni = new HashMap<>();
     private Map<String, Persona> personaMapNumeroSS = new HashMap<>();
    private List<Persona> personasList;
    public SeguridadSocial() {
        personasList = new ArrayList<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {
        if (!personaMapDni.containsKey(persona.getDNI()) && !personaMapNumeroSS.containsKey(persona.getNumSeguridadSocial())){
            personaMapDni.put(persona.getDNI(), persona);
            personaMapNumeroSS.put(persona.getNumSeguridadSocial(), persona);
        }
        
        boolean exist=false;
        for (int i=0; i<personasList.size(); i++){
            if(persona.getDNI().equals(personasList.get(i).getDNI()) || persona.getNumSeguridadSocial().equals(personasList.get(i).getNumSeguridadSocial())){
                System.out.println("DNI o numero de la seguridad social ya existente");
                exist=true;
            }
        }
        if(exist==false)
            personasList.add(persona);
    }

    public void bajaPersona(String dni) {
        personasList.removeIf(persona -> persona.getDNI().equals(dni));
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        int posicion=0;
        for (int i=0; i<personasList.size(); i++){
            if (personasList.get(i).getDNI().equals(dni)){
                posicion=i;
                break;
            }
        }
        return personasList.get(posicion);
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        int posicion=0;
        for (int i=0; i<personasList.size(); i++){
            if (personasList.get(i).getNumSeguridadSocial().equals(numSS)){
                posicion=i;
                break;
            }
        }
        return personasList.get(posicion);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){
        List<Persona> prango = new ArrayList<>();
        for (int i=0; i<personasList.size(); i++){
            if (personasList.get(i).getSalario()>=min && personasList.get(i).getSalario()<=max){
                prango.add(personasList.get(i));
            }
        }
        return prango;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad){

        List<Persona> prango = new ArrayList<>();
        for (int i=0; i<personasList.size(); i++){
            if (personasList.get(i).getEdad()>edad){
                prango.add(personasList.get(i));
            }
        }
        return prango;
    }

    public List<Persona> obtenerTodas(){

        return personasList;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}
