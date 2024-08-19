package control;

import java.util.ArrayList;
import java.util.List;

import modelo.Regla;

public class ControlAtras extends Thread {

    private List<String> BaseDeConocimientos = new ArrayList<>();
    private String[] hechos;
    private Regla[] reglas;
    private String Objetivo;
    private ControlPrincipal ctrl;
    private String texto;
    private String text = null;

    public void setReglas(Regla[] reglas) {

        this.reglas = reglas;
    }

    public void setCtrl(ControlPrincipal ctrl) {

        this.ctrl = ctrl;
    }

    public void setHechos(String[] hechos) {

        this.hechos = hechos;
    }

    public void setObjetivo(String Objetivo) {

        this.Objetivo = Objetivo;
    }

    public String Razonamiento(String Objet) {

        for (String h : hechos) {
            if(!BaseDeConocimientos.contains(h)){
                BaseDeConocimientos.add(h);
            }
            
        }

        
        
        

        try {
            while (!BaseDeConocimientos.contains(Objet)) {

                if (text == null) {
                    text = "BASE DE CONOCIMIENTO \n";
                } else {
                    text += "\nBASE DE CONOCIMIENTO \n";
                }

                String BC = "[";
                int contar = 1;
                for (String Conocimiento : BaseDeConocimientos) {
                    if (BaseDeConocimientos.size() > contar) {
                        BC += Conocimiento + ",";
                    } else {
                        BC += Conocimiento;
                    }
                    contar++;
                }

                BC += "]";

                text += BC + "\n";

                text += "Tomamos " + Objet + " (Objetivo) y buscamos en que regla o conjunto de reglas " + Objet
                        + " se encuentra como conclusión\n";

                List<Regla> rules = new ArrayList<>();
                for (Regla rul : reglas) {

                    String conc = rul.getConclusion();

                    if (conc.equals(Objet)) {

                        rules.add(rul);
                    }

                }

                for (Regla rel : rules){
                    int subindice = rel.getSubindice();
                            String[] condi = rel.getCondiciones();
                            String conclusion = rel.getConclusion();
        
                            text += "R" + subindice + ": ";
        
                            for (int j = 0; j < condi.length; j++) {
                                if (j == condi.length - 1) {
                                    text += condi[j];
                                } else {
                                    text += condi[j] + " y ";
                                }
                            }
                            text += " entonces " + conclusion + "\n";
                }

                if(rules.size()!=0){
                    for(Regla r: rules){
                       

                        
                        text+="Tomamos la siguiente regla:\n";
                            int subindice = r.getSubindice();
                            String[] condi = r.getCondiciones();
                            String conclusion = r.getConclusion();
        
                            text += "R" + subindice + ": ";
        
                            for (int j = 0; j < condi.length; j++) {
                                if (j == condi.length - 1) {
                                    text += condi[j];
                                } else {
                                    text += condi[j] + " y ";
                                }
                            }
                            text += " entonces " + conclusion + "\n";
        
                        
                    if(rules.size()==0){
                        text+="No hay reglas que cumplan eso, por lo tanto, pasamos a la otra condición";
                        break;
                    }
                        boolean bandera = false;
        
                        text += "Los antecedentes de R" + r.getSubindice() + ":\n";
                        String[] condiciones = r.getCondiciones();
                        for (int j = 0; j < condiciones.length; j++) {
                            if (j == condiciones.length - 1) {
                                text += condiciones[j];
                            } else {
                                text += condiciones[j] + " y ";
                            }
                        }
                            for (int i = 0; i < condiciones.length; i++) {
        
                        int menorindice=10;
        
        
                        List<Integer> indices = new ArrayList<>();
                        for(String c : condiciones){
                            if(c!=null){
                                indices.add(Integer.parseInt(c.substring(1)));
                            }
                        
        
                                }
                        int indice = -1;
                        for(int ind : indices){
                            if(ind<menorindice){
                                menorindice=ind;
                            }
                            indice++;
                            
                        }
        
                        for (String ant : condiciones){
                            String a = ant.substring(1);
                            int valor = Integer.parseInt(a);
                            if(valor == menorindice){
                                text += "\nVamos con " + ant + "\n";
                                if (BaseDeConocimientos.contains(ant)) {
            
                                    text += ant + " se encuentra en la base de Conocimientos, por lo tanto "
                                            + r.getConclusion()
                                            + " es verdadero y se agrega a la Base de Conocimientos\n";
                                            
                                    if (!BaseDeConocimientos.contains(r.getConclusion())) {
                                        BaseDeConocimientos.add(r.getConclusion());
                                        
                                        break;
                                    }
                                    break;
            
                                } else {
                                    text += ant + " no se encuentra en la Base de Conocimientos\n";
                                    text += ant + " se convierte en subObjetivo";
                                    Razonamiento(ant);
                                    condiciones[indice] = null;
                                    bandera=true;
                                }
                           
                             
                            }
                            
                        }
                        
                        if(bandera==true && condiciones[i] != null){
                            text += "\nVamos con " + condiciones[i] + "\n";
                            if (BaseDeConocimientos.contains(condiciones[i])) {
        
                                text += condiciones[i] + " se encuentra en la base de Conocimientos, por lo tanto "
                                        + r.getConclusion()
                                        + " es verdadero y se agrega a la Base de Conocimientos";
        
                                if (!BaseDeConocimientos.contains(r.getConclusion())) {
                                    BaseDeConocimientos.add(r.getConclusion());
                                    break;
                                }
                                break;
        
                            } else {
                                text += condiciones[i] + " no se encuentra en la Base de Conocimientos\n";
                                text += condiciones[i] + " se convierte en subObjetivo";
                                Razonamiento(condiciones[i]);
                                bandera=true;
                                break;
                                
                            }
                        }
    
                    }
                    }

                }else{
                    text+="No hay reglas que cumplan eso, por lo tanto, pasamos a la otra condición";
                    return null;
                }
                

                

                this.texto = text;
            
            }

            if (BaseDeConocimientos.contains(this.Objetivo)) {
                return "SE CUMPLIÓ EL OBJETIVO";
            } else {
                
                return null;
            }

        } catch (Exception e) {
            return "NO SE CUMPLIÓ EL OBJETIVO";
        }
    }

    public synchronized void run() {

        String Obj = this.Razonamiento(this.Objetivo);

        ctrl.PintaRazonamiento(this.texto, "Atras", Obj);

    }

}
