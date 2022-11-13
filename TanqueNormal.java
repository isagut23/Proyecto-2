public class TanqueNormal extends Tanque{

    public TanqueNormal() {
        super(10);
    }
    
    public String tanqueNombre(){
        if(getSalud() == 0){
            return "BN-" + getSalud() + 0;
        }else if(getSalud() > 0 && getSalud() < 10){
            return "BN-" + 0 + getSalud();
        }else{
            return "BN-" + getSalud();
        }
    }
    
}
