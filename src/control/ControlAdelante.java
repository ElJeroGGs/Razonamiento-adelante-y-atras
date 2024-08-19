package control;

import modelo.Regla;
import java.util.ArrayList;
import java.util.List;

public class ControlAdelante extends Thread {

    private List<String> BaseDeConocimientos = new ArrayList<>();
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

    public String Razonamiento(){
        for(String h : hechos){
        BaseDeConocimientos.add(h);
    }

        String ObjetivoActual = new String();
        int contador = 1;
        String text = null;

        try{
            while(!ObjetivoActual.equals(this.Objetivo)){
            
            if(text==null){
            text = "PASO "+contador;}
            else{
                text += "PASO "+contador;
            }
            text+="\nBASE DE CONOCIMIENTO \n";

            String BC = "[";
            int contar = 1;
            for(String Conocimiento : BaseDeConocimientos){
                if(BaseDeConocimientos.size()>contar){
                    BC+=Conocimiento+",";
                }else{
                    BC+=Conocimiento;
                }
                contar++;
            }
            
            BC += "]";

            text+=BC+"\n";

            text+="Tomamos "+BaseDeConocimientos.get(contador-1)+" de la Base de Conocimientos y buscamos en que reglas "+BaseDeConocimientos.get(contador-1)+" se encuentra como condición\n";

        
            List<Regla> rules = new ArrayList<>();
            for(Regla rul : reglas){

            String[] cond = rul.getCondiciones();

            for(String condicion : cond){

                if(condicion.equals(BaseDeConocimientos.get(contador-1))){

                    rules.add(rul);
                }

            }
        }

        for (int i = 0; i < rules.size(); i++) {

            int subindice = rules.get(i).getSubindice();
            String[] condiciones = rules.get(i).getCondiciones();
            String conclusion = rules.get(i).getConclusion();

            text+="R" + subindice + ": ";

            for (int j = 0; j < condiciones.length; j++) {
                if(j==condiciones.length-1){
                    text+=condiciones[j];
                }else{
                    text+=condiciones[j] + " y ";
                }
            }
            text+= " entonces " + conclusion + "\n";



        }
        List<Regla> ruList = new ArrayList<>();
        if (contador ==5);
        for(Regla rul : rules){
            //Evaluamos cada regla (Que se cumplan todas las condiciones)

            String[] cond = rul.getCondiciones();
        

            int condiciones = cond.length;
            int conditions = 0;

            for(String condicion : cond){
                for(String con : BaseDeConocimientos){
                    if(condicion.equals(con)){
                        conditions++;
                    }
                    
                }
            }

            
            if(conditions==condiciones){

                ruList.add(rul);

            }
            
            }

        

            text+="Las reglas que cumplen todas las condiciones son:\n";

            for(Regla ruul : ruList){

                int subindice = ruul.getSubindice();
                String[] condi = ruul.getCondiciones();
                String conclusion = ruul.getConclusion();
    
                text+="R" + subindice + ": ";
    
                for (int j = 0; j < condi.length; j++) {
                    if(j==condi.length-1){
                        text+=condi[j];
                    }else{
                        text+=condi[j] + " y ";
                    }
                }
                text+= " entonces " + conclusion + "\n";
                
        }
        boolean bandera = false;
        int imenor = 10;
        int condicionesmax = 0;

        for(Regla rulee : ruList){
            String conclusion = rulee.getConclusion();

           
    //Resolucion de conflictos por mayor cantidad de reglas conocidas
    int prueba = 0;
    if(ruList.size()>1 && bandera == false){
        for(Regla unidad : ruList){
            if(rulee.getCondiciones().length>condicionesmax){
                    
                condicionesmax = rulee.getCondiciones().length;
    
                
                prueba++;
    
                if(prueba>1){
                ruList.removeFirst();
                }
                rulee = unidad;
                bandera = true;
                }
    
                text+="por resolución de conflictos (mayor cantidad de hechos conocidos), se toma la regla R"+rulee.getSubindice()+" y ";
            }
    }
        
            

            //Resolucion de conflictos por subindice menor
                if(ruList.size()>1 && bandera == false){
                for(Regla unidad : ruList){

                    if(imenor > unidad.getSubindice()){
                        imenor = unidad.getSubindice();
                        rulee = unidad;
                        bandera = true;

                    }


                }
                
                text+="por resolución de conflictos (subindice menor), se toma la regla R"+rulee.getSubindice()+" y se agrega "+rulee.getConclusion()+ " a la base de Conocimientos\n";
                if(!BaseDeConocimientos.contains(conclusion)){
                    this.BaseDeConocimientos.add(conclusion);
                }

                ObjetivoActual = conclusion;

                }else{
                text+="por lo tanto, se agrega "+rulee.getConclusion()+ " a la base de Conocimientos\n\n";

                if(!BaseDeConocimientos.contains(conclusion)){
                    this.BaseDeConocimientos.add(conclusion);
                }
                

                ObjetivoActual = conclusion;
                }
        }

    



        this.texto = text;
        contador++;

        
        
        
        }

            return "SE CUMPLIÓ EL OBJETIVO";
        }catch(Exception e){

            return "NO SE CUMPLIÓ EL OBJETIVO";
        }

        
    
    }

    public void run(){

        String Objeto = this.Razonamiento();

        ctrl.PintaRazonamiento(this.texto, "Adelante", Objeto);


    }

}
