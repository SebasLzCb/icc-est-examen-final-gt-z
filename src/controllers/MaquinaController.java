package controllers;
import models.Maquina;
import java.util.*;

public class MaquinaController {

    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral) {
        Stack<Maquina> resultado = new Stack<>();
        for (Maquina m : maquinas) {
            if (m.getSubred() < umbral) {
                resultado.push(m);
            }
        }
        Collections.reverse(resultado);
        return resultado;
    }

    public TreeSet<Maquina> ordenarPorSubred(Stack<Maquina> pila) {
        TreeSet<Maquina> conjuntoOrdenado = new TreeSet<>(new Comparator<Maquina>() {
            @Override
            public int compare(Maquina m1, Maquina m2) {
                int cmpSubred = Integer.compare(m2.getSubred(), m1.getSubred());
                if (cmpSubred != 0) {
                    return cmpSubred;
                }
                int cmpNombre = m1.getNombre().compareTo(m2.getNombre());
                if (cmpNombre != 0) {
                    return cmpNombre;
                }
                return 0;
            }
        });
        conjuntoOrdenado.addAll(pila);
        return conjuntoOrdenado;
    }

    public TreeMap<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas) {
        TreeMap<Integer, Queue<Maquina>> mapa = new TreeMap<>();
        for (Maquina m : maquinas) {
            int riesgo = m.getRiesgo();
            mapa.putIfAbsent(riesgo, new LinkedList<>());
            mapa.get(riesgo).add(m);
        }
        return mapa;
    }

    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa) {
        int maxCantidad = -1;
        int riesgoSeleccionado = -1;
        for (Map.Entry<Integer , Queue<Maquina>> entry : mapa.entrySet()){

        }
        return null;
    }
}

