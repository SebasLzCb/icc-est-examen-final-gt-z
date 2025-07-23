package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public int getSubred() {
        String[] partes = ip.split("\\.");
        return Integer.parseInt(partes[3]);
    }

    public int getRiesgo() {
        int sumaDiv3 = 0;
        for (int codigo : codigos) {
            if (codigo % 3 == 0) {
                sumaDiv3 += codigo;
            }
        }
        String nombreSinEspacios = nombre.replace(" ", "");
        Set<Character> caracteresUnicos = new HashSet<>();
        for (char c : nombreSinEspacios.toCharArray()) {
            caracteresUnicos.add(c);
        }
        return sumaDiv3 * caracteresUnicos.size();
    }

    @Override
    public String toString() {
        return "Maquina{" +
                "nombre='" + nombre + '\'' +
                ", ip='" + ip + '\'' +
                ", subred=" + getSubred() +
                ", riesgo=" + getRiesgo() +
                '}';
    }
}
