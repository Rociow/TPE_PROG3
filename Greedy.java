import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*La solución está planteada en base a ordenar las máquinas que pueden producir
* mayor cantidad de piezas a menor cantidad, de esta manera los candidatos que se tienen
* en cuenta en primer lugar son aquellos que pueden producir más, para de esta manera
* utilizar la menor cantidad de máquinas posible.
* También se busca la eficiencia a partir del cálculo de cuántas piezas del total
* puede producir el candidato seleccionado, para de esta manera evitar considerar
* el mismo candidato muchas veces*/

public class Greedy {
    private List<Maquina> maquinas;
    private List<Maquina> solucion;

    public Greedy(List<Maquina> maquinas) {
        solucion = new ArrayList<>();
        this.maquinas = maquinas;
    }

    public List<Maquina> GreedyMaquina(Integer piezas) {
        maquinas.sort(new MaquinaPorPiezasDesc());

        solucion = new ArrayList<>();
        int piezasProducidas = 0;

        int i = 0;
        while (piezasProducidas < piezas && i < maquinas.size()) {
            Maquina m = maquinas.get(i);

            int piezasRestantes = piezas - piezasProducidas;
            int cantidadUsos = piezasRestantes / m.getPiezas();

            for (int j = 0; j < cantidadUsos; j++) {
                solucion.add(m);
                piezasProducidas += m.getPiezas();
            }

            i++;
        }
        if (piezasProducidas == piezas) {
            return solucion;
        } else {
            return null;
        }
    }
}
