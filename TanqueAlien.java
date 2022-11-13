public class TanqueAlien extends Tanque {

    public TanqueAlien() {
        super(20);
    }

    public String tanqueNombre(){
        if(getSalud() == 0){
            return "BA-" + getSalud() + 0;
        }else if(getSalud() > 0 && getSalud() < 10){
            return "BA-" + 0 + getSalud();
        }else{
            return "BA-" + getSalud();
        }
    }
    
}
