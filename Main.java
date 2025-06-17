import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Configuracion config = leerArchivo("Configuracion.txt");

        Greedy solucionGr = new Greedy(config.maquinas);

        solucionGr.mostrarResultadosGreedy(config.totalPiezasObjetivo);

        Backtracking solucionBack = new Backtracking(config.maquinas);

        solucionBack.mostrarResultadosBacktracking(config.totalPiezasObjetivo);

    }

    static Configuracion leerArchivo(String nombreArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        int totalPiezasObjetivo = Integer.parseInt(br.readLine().trim());
        List<Maquina> maquinas = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            maquinas.add(new Maquina(partes[0], Integer.parseInt(partes[1])));
        }
        br.close();

        return new Configuracion(totalPiezasObjetivo, maquinas);
    }
}

