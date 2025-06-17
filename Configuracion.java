import java.util.*;

public class Configuracion {
    public int totalPiezasObjetivo;
    public List<Maquina> maquinas;

    public Configuracion(int totalPiezasObjetivo, List<Maquina> maquinas) {
        this.totalPiezasObjetivo = totalPiezasObjetivo;
        this.maquinas = maquinas;
    }
}
