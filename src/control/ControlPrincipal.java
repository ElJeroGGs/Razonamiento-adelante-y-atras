package control;

import modelo.Regla;
import vista.VistaPrincipal;

public class ControlPrincipal {

    Regla[] reglas;
    VistaPrincipal vista;
    ControlAdelante ctrlAdelante;
    ControlAtras ctrlAtras;

    public ControlPrincipal() {

    }

    public void setReglas(Regla[] reglas) {
        this.reglas = reglas;
    }

    public void iniciar() {

        vista = new VistaPrincipal(reglas);
        vista.setCtrl(this);
        

    }

    public void IniciarProcesos(String[] hechos, String Objetivo) {

        //Instanciamos Razonamiento hacia adelante

        ctrlAdelante = new ControlAdelante();
        ctrlAdelante.setReglas(reglas);
        ctrlAdelante.setHechos(hechos);
        ctrlAdelante.setObjetivo(Objetivo);
        //Instanciamos Razonamiento hacia atras
        ctrlAtras = new ControlAtras();
        ctrlAtras.setReglas(reglas);
        ctrlAtras.setHechos(hechos);
        ctrlAtras.setObjetivo(Objetivo);

        //Inyección de dependencias

        ctrlAdelante.setCtrl(this);
        ctrlAtras.setCtrl(this);

        //Corremos Razonamiento Hacia adelante

        ctrlAdelante.start();
        ctrlAtras.start();
    }

    public void PintaRazonamiento(String texto, String lado, String Objetivo){

        switch (lado) {
            case "Adelante":
            this.vista.PintaMarco(texto, "Adelante", Objetivo);
            
                break;
        
            case "Atras":
            this.vista.PintaMarco(texto, "Atras", Objetivo);
                
                break;
        }

    }

    
}
