import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("****INICIAR JUEGO: (si/no)****");
        String activacion = input.next();

        if (activacion.equals("si")){
            Principal.mostrarMenu();
        }

        input.close();
    }

    public static void mostrarMenu(){
        Scanner in = new Scanner(System.in);
        Tanque.agregarTanques();
        String posicionesTableroJuego = Tanque.posicionesTableroJuego();   
        String tableroJuego = Tanque.mostrarTableroJuego();   
        String menu = ("0: Salir del juego\n"
        + "1: Disparar bala al tanque que desee \n"
        + "2: Activar bomba atomica (mata a un tanque aleatoriamnete) \n"    
        + "3: Activar tanque mutante (duplica la salud del tanque con menos vida) \n"
        + "4: Mostrar frase de la abuela \n"
        + "5: Muestra la cantidad de disparos relizados \n"
        + "6: Leer cantidad de salud  \n"
        + "7: Mostrar tablero de juego \n"
        + "8: Abrir el menu \n ");  

        System.out.println("*****TANKS WARS MINI-JUEGO****");
        System.out.println("*****MENU*****");
        System.out.println(menu);
        System.out.println("Recuerde:\n" + posicionesTableroJuego);
        System.out.println("Notacion usada: tipo de tanque - salud");
        System.out.println("****TABLERO DE JUEG0***");
        System.out.println(tableroJuego);



        while(true){
            System.out.println("\nIngrese el numero:" );          
            int num = in.nextInt();            

            switch(num){
                case 0:
                    System.out.println("****GAME OVER****");
                    break;
                case 1: 
                    System.out.println("\nIngrese la posicion sobre el cual disparar:"); 
                    System.out.println("Fila: ");        
                    int fila = in.nextInt();
                    System.out.println("Columna: ");
                    int columna = in.nextInt();
                    System.out.println(Tanque.dispararBala(fila, columna));
                    break;
                case 2:
                    Tanque.activarBombaAtomica();
                    System.out.println("\nBomba atomica activada" );         
                    break;
                case 3:
                    Tanque.activarTanqueMutante();
                    System.out.println("\nTanque mutante activado");
                    break;
                case 4:
                    System.out.println("\nFrase inspiradora de la abuela");
                    System.out.println(Tanque.fraseAbuela());
                    break;
                case 5:
                    Tanque tanque = new Tanque();
                    int cantidadDisparos = tanque.getCantidadDisparos();
                    System.out.println("\nConteo de disparos: " + cantidadDisparos);
                    break;
                case 6:
                    System.out.println("\nSalud actual tanques");
                    System.out.println("Tipo de tanque - salud");
                    System.out.println(Tanque.leerSalud());
                    break;
                case 7:
                    System.out.println("\n****TABLERO DE JUEG0***");
                    System.out.println(Tanque.mostrarTableroJuego());
                    break;
                case 8:
                    System.out.println("\n*****MENU*****");
                    System.out.println(menu);
                    break;
                default:
                    System.out.println("Numero no valido");
            }  
            if(num == 0){
                break;
            }else if(Tanque.tanquesDestruidos() == 0){
                System.out.println("****GAME OVER****");
                System.out.println(Tanque.mostrarTableroJuego());
                break;
            }
        }
        in.close();
    }
}
