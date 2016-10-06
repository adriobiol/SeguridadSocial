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
    public void altaPersona(Persona persona1) {
        if (!personaMapDni.containsKey(persona1.getDNI()) && !personaMapNumeroSS.containsKey(persona1.getNumSeguridadSocial())){
            personaMapDni.put(persona1.getDNI(), persona1);
            personaMapNumeroSS.put(persona1.getNumSeguridadSocial(), persona1);
        }
        
        boolean result=false;
        for (int i=0; i<personasList.size(); i++){
            if(persona1.getDNI().equals(personasList.get(i).getDNI()) || persona1.getNumSeguridadSocial().equals(personasList.get(i).getNumSeguridadSocial())){
                System.out.println("DNI o numero de la seguridad social ya existente");
                result=true;
            }
        }
        if(result==false)
            personasList.add(persona1);
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

    public Persona obtenerPersonaPorNumSS(String numseg) {
        int posicion=0;
        for (int i=0; i<personasList.size(); i++){
            if (personasList.get(i).getNumSeguridadSocial().equals(numseg)){
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
