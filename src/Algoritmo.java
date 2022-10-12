public class Algoritmo {
    public boolean aceptable(int[] damas, int fila, int c){
        boolean correcto = true;
        int i=0;
        while ((correcto) && (i<fila)) {
            correcto = (damas[i] != c) && (Math.abs(damas[i]-c) != Math.abs(i-fila));
            i++;
        }
        return correcto;
    }
    public void reinas(int[] damas, int fila, Booleano exito){
        if (fila==damas.length) {
            exito.setValor(true);
            System.out.println("Solución encontrada");
        }
        else {
            int c = 0;
            while ((c < damas.length) && (!exito.getValor())) {
                if (aceptable(damas, fila, c)){
                    damas[fila] = c;
                    fila = fila + 1;
                    reinas(damas, fila, exito);
                    if (!exito.getValor()){
                        fila = fila -1;
                    }
                }
                c++;
            }
        }
    }
}
