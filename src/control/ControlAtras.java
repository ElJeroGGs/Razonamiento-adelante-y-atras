package control;

import modelo.Regla;

public class ControlAtras extends Thread {

 private String[] BaseDeConocimientos;
    private String[] hechos;
    private Regla[] reglas;
    private String Objetivo;
    private ControlPrincipal ctrl;
    private String texto;

    public void setReglas(Regla[] reglas){

        this.reglas = reglas;
    }

    public void setCtrl(ControlPrincipal ctrl){

        this.ctrl = ctrl;
    }

    public void setHechos(String[] hechos){

        this.hechos= hechos;
    }

    public void setObjetivo(String Objetivo){

        this.Objetivo = Objetivo;
    }

    public void Razonamiento(){
        this.texto = "PASO 1\r\n" + //
                "BASE DE CONOCIMIENTO\r\n" + //
                "{H7, H8}\r\n" + //
                "Buscamos regla o conjunto de reglas donde H2 (Objetivo) está como conclusión\r\n" + //
                "R6\r\n" + //
                "Antecedentes de R6\r\n" + //
                "H9\r\n" + //
                "H1\r\n" + //
                "Vamos con H9 primero\r\n" + //
                "H9 no se encuentra en la base de conocimiento, no se agrega a la bc\r\n" + //
                "H9 Se convierte en subobjetivo \r\n" + //
                "Buscamos regla o conjunto de reglas donde H9 (Objetivo) está como conclusión\r\n" + //
                "R2\r\n" + //
                "R3\r\n" + //
                "R8\r\n" + //
                "Antecedentes de R2\r\n" + //
                "H6\r\n" + //
                "H3\r\n" + //
                "Vamos con H6 primero\r\n" + //
                "H6 no se encuentra en la base de conocimiento, no se agrega a la bc\r\n" + //
                "H6 Se convierte en subobjetivo\r\n" + //
                "Buscamos regla o conjunto de reglas donde H6 (Objetivo) está como conclusión\r\n" + //
                "R7\r\n" + //
                "Antecedentes de R7\r\n" + //
                "H7\r\n" + //
                "H7  Si se encuentra en la BC, por lo tanto el subobjetivo H6 es verdadero y se agrega a la BC\r\n" + //
                "BASE DE CONOCIMIENTO\r\n" + //
                "{H7, H8, H6}\r\n" + //
                "Regresando a R2\r\n" + //
                "Vamos con H3\r\n" + //
                "H3 no se encuentra en la BC\r\n" + //
                "H3 Se convierte en subobjetivo\r\n" + //
                "Buscamos regla o conjunto de reglas donde H3 (Objetivo) está como conclusión\r\n" + //
                "No hay, por lo que no se llegó al objetivo\r\n" + //
                "Si hay tiempo, podemos regresar a la regla anterior y seguir aplicando y así, hasta quedarnos en cero, pero eso puede ser más complicado\r\n"
                + //
                "";
    }

    public void run(){

        this.Razonamiento();

        ctrl.PintaRazonamiento(this.texto, "Atras", "NO SE CUMPLIÓ EL OBJETIVO");


    }

}
