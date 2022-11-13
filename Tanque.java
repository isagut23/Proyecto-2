public class Tanque{
    int salud;
    static Tanque [][]tanques = new Tanque[2][2];
    static int cantidadTanques = (int) (Math.random()* 4 + 1);
    static int cantidadDisparos = 0;

    public Tanque(){
    }

    public Tanque(int salud){
        this.salud = salud;
    }

    public int getSalud(){
        return salud;
    }

    public int getNumTanques(){
        return cantidadTanques;
    }

    public int getCantidadDisparos(){
        return cantidadDisparos;
    }

    public void setSalud(int salud){
        this.salud = salud;
    }

    public String tanqueNombre(){
        if(this.salud == 0){
            return "B-" + getSalud() + 0;
        }else if(this.salud > 0 && this.salud < 10){
            return "B-" + 0 + this.salud;
        }else{
            return "B-" + this.salud;
        }
    }

    public static void agregarTanques(){
        int aux = 0;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                if(aux < cantidadTanques){
                    int numTipo = (int) (Math.random() * 2 + 1);
                    if(numTipo == 1){
                        TanqueNormal BN = new TanqueNormal();
                        tanques [i][j] = BN;
                    }else{
                        TanqueAlien BA= new TanqueAlien();
                        tanques [i][j] = BA;
                    }
                }
                aux++;
            }
        }
    }

    public static String mostrarTableroJuego(){
        if (cantidadTanques == 4){
            String tablero = "-------------\n|" + tanques[0][0].tanqueNombre() + "|" 
            + tanques[0][1].tanqueNombre() + "|\n-------------\n|" + tanques[1][0].tanqueNombre() + "|"
            + tanques[1][1].tanqueNombre() + "|\n-------------";
            return tablero;
        }else if (cantidadTanques == 3){
            String tablero = "-------------\n|" + tanques[0][0].tanqueNombre() 
            + "|" + tanques[0][1].tanqueNombre() + "|\n-------------\n|" + tanques[1][0].tanqueNombre() 
            + "|     |\n-------------";
            return tablero;
        }else if (cantidadTanques == 2){
            String tablero = "-------------\n|" + tanques[0][0].tanqueNombre() + "|" 
                + tanques[0][1].tanqueNombre() + "|\n-------------\n|     |     |\n-------------";
            return tablero;
        }else{
            String tablero = "-------------\n|" + tanques[0][0].tanqueNombre() + "|     |\n-------------\n|     |     |\n-------------";
            return tablero;
        }   
    }

    public static String posicionesTableroJuego(){
        String tablero = "---------------\n|" + "[0][0]" + "|" + "[0][1]" + "|\n---------------\n|" + "[1][0]" + "|" + "[1][1]" + "|\n---------------";     
        return tablero;
    }

    public static String dispararBala(int fila, int columna){
        Tanque tanque = tanques[fila][columna];
        int salud = tanque.getSalud();
        if(salud != 0){
            tanque.setSalud(salud-5);
            cantidadDisparos++;
            return "Se le ha disparado al tanque seleccionado, actual: " + tanques[fila][columna].tanqueNombre();
        }else{
            return "El tanque ya se encuentra destruido";
        }
    }

    public static void activarBombaAtomica(){
        while(true){
            int fila = (int) (Math.random()*2);
            int columna = (int) (Math.random()*2);
            
            if(tanques[fila][columna] != null && tanques[fila][columna].getSalud() != 0){
                Tanque tanque = tanques[fila][columna];
                int salud = tanque.getSalud();
                tanque.setSalud(salud-salud);
                break;
            }      
        }
    }

    public static String fraseAbuela(){
        String frase = "Ave maria, ruega por nosotros";
        return frase;
    }

    public static void activarTanqueMutante(){
        int num = tanques[0][0].getSalud();
        Tanque tanqueAux = tanques[0][0]; 

        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if(tanques[i][j] != null){
                    if ( tanques[i][j].getSalud() < num && tanques[i][j].getSalud() != 0 || num == 0) {
                        num = tanques[i][j].getSalud();
                        tanqueAux = tanques[i][j];
                    }
                }
            }
        }
        tanqueAux.setSalud(tanqueAux.getSalud()*2);
    }


    public static int tanquesDestruidos(){
        int aux = 0;
        int salud = 0;

        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if(aux < cantidadTanques){
                    salud += tanques[i][j].getSalud();
                }
                aux++;
            }
        }
        return salud;
    }

    public static int tanquesVivos(){
        int vivos = 0;

        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if(tanques[i][j].getSalud() > 0){
                    vivos++;
                }
            }
        }
        return vivos;
    }

    public static String leerSalud(){
        String saludTanques = "";
        
        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if(tanques[i][j] != null){
                    saludTanques += "posicion[" + i + "][" + j + "]: "+ tanques[i][j].tanqueNombre() + "\n";
                }
            }
        }

        String saludWithout = saludTanques.substring(0, saludTanques.length()-1);
        return saludWithout;
    }
}