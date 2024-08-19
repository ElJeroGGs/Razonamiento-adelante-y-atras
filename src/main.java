import control.ControlPrincipal;
import modelo.Regla;
import vista.VistaPrincipal;

public class main {

    public static void main(String[] args) {
        //Instanciamos control
        ControlPrincipal control = new ControlPrincipal();

        //Instanciamos las reglas
        String[] A1 =  new String[3];
        A1[0] = "H8";
        A1[1] = "H6";
        A1[2] = "H5";
        Regla R1 = new Regla(1, A1, "H4");

        String[] A2 =  new String[2];
        A2[0] = "H6";
        A2[1] = "H3";
        Regla R2 = new Regla(2, A2, "H9");

        String[] A3 =  new String[2];
        A3[0] = "H7";
        A3[1] = "H4";
        Regla R3 = new Regla(3, A3, "H9");

        String[] A4 =  new String[1];
        A4[0] = "H8";
        Regla R4 = new Regla(4, A4, "H1");
        
        String[] A5 =  new String[1];
        A5[0] = "H6";
        Regla R5 = new Regla(5, A5, "H5");

        String[] A6 =  new String[2];
        A6[0] = "H9";
        A6[1] = "H1";
        Regla R6 = new Regla(6, A6, "H2");

        String[] A7 =  new String[1];
        A7[0] = "H7";
        Regla R7 = new Regla(7, A7, "H6");

        String[] A8 =  new String[2];
        A8[0] = "H1";
        A8[1] = "H7";
        Regla R8 = new Regla(8, A8, "H9");

        String[] A9 =  new String[2];
        A9[0] = "H1";
        A9[1] = "H8";
        Regla R9 = new Regla(9, A9, "H6");

        //Instanciamos un arreglo de reglas

        Regla[] reglas = new Regla[9];
        reglas[0] = R1;
        reglas[1] = R2;
        reglas[2] = R3;
        reglas[3] = R4;
        reglas[4] = R5;
        reglas[5] = R6;
        reglas[6] = R7;
        reglas[7] = R8;
        reglas[8] = R9;

        //Lo mandamos al control

        control.setReglas(reglas);

        //Iniciamos la vista
        control.iniciar();


    }

}
