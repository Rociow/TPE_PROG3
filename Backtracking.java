import java.util.ArrayList;
import java.util.List;

/*
El árbol se genera a partir de la seleccion de la primer máquina en el ArrayList de máquinas.
La poda aplicada consiste en evitar las soluciones duplicadas a partir de aplicar un índice como
parámetro, de esta manera, si ya existe una solución que consta de: (M1,7),(M3,4),(M4,1), no se
genere otra solución que cambie de lugar las máquinas: (M3,4),(M4,1),(M1,7).
 */
public class Backtracking {
    private List<Maquina> maquinas;
    private List<Maquina> mejorSolucion;
    private int contador;

    public Backtracking(List<Maquina> maquinas){
        mejorSolucion = new ArrayList<>();
        this.maquinas = maquinas;
    }

    public List<Maquina> backtrackingMaquina(Integer piezas){

        List<Maquina> posibleSolucion = new ArrayList<>();
        backtrackingMaquina(piezas, posibleSolucion, 0,0);

        return mejorSolucion;
    }

    private void backtrackingMaquina(Integer piezas, List<Maquina> posibleSolucion, int piezasProducidas, int indice){
        contador++; //contador estados

        if (piezasProducidas==piezas){
            if (esMejor(posibleSolucion, mejorSolucion)){
                mejorSolucion = new ArrayList<>(posibleSolucion);
            }
        } else {

            for (int i = indice; i < maquinas.size(); i++) {
                Maquina m = maquinas.get(i);

                if (piezasProducidas + m.getPiezas() <= piezas) {
                    posibleSolucion.add(m);
                    piezasProducidas += m.getPiezas();
                    if (posibleSolucion.size()<mejorSolucion.size() || mejorSolucion.isEmpty()){
                        backtrackingMaquina(piezas, posibleSolucion, piezasProducidas, i);
                    }
                    posibleSolucion.remove(posibleSolucion.size() - 1);
                    piezasProducidas -= m.getPiezas();
                }

            }
        }
    }

    private boolean esMejor(List<Maquina> posibleSolucion,List<Maquina> mejorSolucion){
            return mejorSolucion.isEmpty() || posibleSolucion.size() < mejorSolucion.size();
    }
}
