import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*La solución está planteada en base a ordenar las máquinas que pueden producir
* mayor cantidad de piezas a menor cantidad, de esta manera los candidatos que se tienen
* en cuenta en primer lugar son aquellas maquinas que pueden producir más piezas,
* para utilizar la menor cantidad de máquinas posible.
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

    public void greedyMaquina(Integer piezas) {
        maquinas.sort(new MaquinaPorPiezasDesc());

        solucion = new ArrayList<>();
        int piezasProducidas = 0;
        int candidatosConsiderados = 0;

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
        System.out.println("Greedy");
        if (piezasProducidas == piezas) {
            System.out.print("Solución obtenida: ");
            for (Maquina m : solucion) {
                System.out.print(m.getNombre() + " ");
            }
            System.out.println();
            System.out.println("Piezas producidas: " + piezasProducidas);
            System.out.println("Puestas en funcionamiento: " + solucion.size());
            System.out.println("Candidatos considerados: " + candidatosConsiderados);
        } else {
            System.out.println("No se pudo alcanzar el objetivo con las máquinas disponibles.");
            System.out.println("Piezas producidas: " + piezasProducidas);
            System.out.println("Candidatos considerados: " + candidatosConsiderados);
        }
    }
}
