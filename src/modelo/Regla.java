package modelo;

public class Regla {

    private int subindice;
    private String[] condiciones;
    private String conclusion;

    public Regla(int subindice, String[] condiciones, String conclusion) {
        this.subindice = subindice;
        this.condiciones = condiciones;
        this.conclusion = conclusion;
    }

    public int getSubindice() {
        return subindice;
    }

    public String[] getCondiciones() {
        return condiciones;
    }
    public String getConclusion(){

        return conclusion;
    }
}
