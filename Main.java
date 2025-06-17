import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Maquina> maquinas = new ArrayList<>();
        maquinas.add(new Maquina("M1",7));
        maquinas.add(new Maquina("M2",3));
        maquinas.add(new Maquina("M3",4));
        maquinas.add(new Maquina("M4",1));

        Greedy solucionGr = new Greedy(maquinas);

        System.out.println(solucionGr.GreedyMaquina(12));

        Backtracking solucionBack = new Backtracking(maquinas);

        System.out.println(solucionBack.backtrackingMaquina(12));
    }
}
