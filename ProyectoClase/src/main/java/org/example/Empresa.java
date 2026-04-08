package org.example;

import java.util.ArrayList;

public class Empresa {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public ArrayList<String> mostrarEmpleados() {
        ArrayList<String> lista = new ArrayList<>();
        for (Empleado e : empleados) {
            lista.add(e.mostrarInformacion());
        }
        return lista;
    }

    public Empleado buscarEmpleado(String doc) {
        return empleados.stream()
                .filter(e -> e.getDocumento().equals(doc))
                .findFirst().orElse(null);
    }

    public Empleado empleadoMayorSalario() {
        return empleados.stream()
                .max((a, b) -> Float.compare(a.calcularSalarioNeto(), b.calcularSalarioNeto()))
                .orElse(null);
    }

    public float nominaTotal() {
        return (float) empleados.stream()
                .mapToDouble(Empleado::calcularSalarioNeto)
                .sum();
    }

    public ArrayList<ResumenPago> generarResumenes() {
        ArrayList<ResumenPago> lista = new ArrayList<>();
        for (Empleado e : empleados) {
            lista.add(e.generarResumenPago());
        }
        return lista;
    }
}