import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int totalPiezasObjetivo;
    static List<Maquina> maquinas;

    public static void main(String[] args) throws IOException {
        leerArchivo("Configuracion.txt");

        Greedy solucionGr = new Greedy(maquinas);

        System.out.println("Greedy: " + solucionGr.GreedyMaquina(12));

        Backtracking solucionBack = new Backtracking(maquinas);

        System.out.println("Backtracking: " + solucionBack.backtrackingMaquina(12));
    }

    static void leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        totalPiezasObjetivo = Integer.parseInt(br.readLine().trim());
        maquinas = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            maquinas.add(new Maquina(partes[0], Integer.parseInt(partes[1])));
        }
        br.close();
    }
}
