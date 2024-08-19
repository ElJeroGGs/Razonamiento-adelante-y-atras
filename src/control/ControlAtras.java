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
            BaseDeConocimientos.add(h);
        }

        String ObjetivoActual = new String();
        int contador = 1;
        String text = null;

        try {
            while (!ObjetivoActual.equals(Objet)) {

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

                for (int i = 0; i < rules.size(); i++) {

                    int subindice = rules.get(i).getSubindice();
                    String[] condiciones = rules.get(i).getCondiciones();
                    String conclusion = rules.get(i).getConclusion();

                    text += "R" + subindice + ": ";

                    for (int j = 0; j < condiciones.length; j++) {
                        if (j == condiciones.length - 1) {
                            text += condiciones[j];
                        } else {
                            text += condiciones[j] + " y ";
                        }
                    }
                    text += " entonces " + conclusion + "\n";

                }

                text += "Los antecedentes de R" + rules.getFirst().getSubindice() + ":\n";
                String[] condiciones = rules.getFirst().getCondiciones();
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
                indices.add(Integer.parseInt(c.substring(1)));

                        }

                for(int ind : indices){
                    if(ind<menorindice){
                        menorindice=ind;
                    }
                    
                }
                
                for (String ant : condiciones){
                    String a = ant.substring(1);
                    int valor = Integer.parseInt(a);
                    if(valor == menorindice){
                        text += "\nVamos primero con " + ant + "\n";
                        if (BaseDeConocimientos.contains(ant)) {
    
                            text += ant + " se encuentra en la base de Conocimientos, por lo tanto "
                                    + rules.getFirst().getConclusion()
                                    + " es verdadero y se agrega a la Base de Conocimientos";
                            if (!BaseDeConocimientos.contains(rules.getFirst().getConclusion())) {
                                BaseDeConocimientos.add(rules.getFirst().getConclusion());
                                break;
                            }
    
                        } else {
                            text += ant + " no se encuentra en la Base de Conocimientos\n";
                            text += ant + " se convierte en subobjetivo";
                            Razonamiento(ant);
                        }
                     break;   
                    }
                    
                }
                

                    text += "\nVamos primero con " + condiciones[i] + "\n";
                    if (BaseDeConocimientos.contains(condiciones[i])) {

                        text += condiciones[i] + " se encuentra en la base de Conocimientos, por lo tanto "
                                + rules.getFirst().getConclusion()
                                + " es verdadero y se agrega a la Base de Conocimientos";
                        if (!BaseDeConocimientos.contains(rules.getFirst().getConclusion())) {
                            BaseDeConocimientos.add(rules.getFirst().getConclusion());
                            break;
                        }

                    } else {
                        text += condiciones[i] + " no se encuentra en la Base de Conocimientos\n";
                        text += condiciones[i] + " se convierte en subobjetivo";
                        Razonamiento(condiciones[i]);
                    }
                }

                this.texto = text;
                break;
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

    public void run() {

        String Obj = this.Razonamiento(this.Objetivo);

        ctrl.PintaRazonamiento(this.texto, "Atras", Obj);

    }

}
