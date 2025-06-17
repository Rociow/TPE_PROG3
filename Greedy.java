import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Los candidatos son las máquinas ordenadas de mayor a menor según la cantidad de piezas que pueden producir.
* También se intenta producir la mayor cantidad posible de piezas con la máquina más eficiente.
*/

public class Greedy {
    private List<Maquina> maquinas;
    private List<Maquina> solucion;

    private int candidatosConsiderados = 0;

    public Greedy(List<Maquina> maquinas) {
        solucion = new ArrayList<>();
        this.maquinas = maquinas;
    }

    public List<Maquina> GreedyMaquina(Integer piezas) {
        maquinas.sort(new MaquinaPorPiezasDesc());

        solucion = new ArrayList<>();
        int piezasProducidas = 0;
        candidatosConsiderados = 0;

        int i = 0;
        while (piezasProducidas < piezas && i < maquinas.size()) {
            Maquina m = maquinas.get(i);
            candidatosConsiderados++;

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

    public void mostrarResultadosGreedy(int piezas) {
        List<Maquina> solucion = GreedyMaquina(piezas);
        int totalPiezas = solucion != null ? solucion.stream().mapToInt(Maquina::getPiezas).sum() : 0;

        System.out.println("Greedy");
        System.out.println("Solución obtenida: " + solucion);
        System.out.println("Cantidad de piezas producidas: " + totalPiezas);
        System.out.println("Cantidad de puestas en funcionamiento: " + (solucion != null ? solucion.size() : 0));
        System.out.println("Costo (candidatos considerados): " + candidatosConsiderados);
    }

}

