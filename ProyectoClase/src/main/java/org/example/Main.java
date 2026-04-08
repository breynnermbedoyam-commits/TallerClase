package org.example;

import javax.swing.JOptionPane;
public class Main {

    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        int opcion;

        do {
            String menu = """
                    ===== MENÚ =====
                    1. Agregar empleado planta
                    2. Agregar empleado ventas
                    3. Agregar empleado temporal
                    4. Mostrar empleados
                    5. Buscar empleado
                    6. Mayor salario
                    7. Nómina total
                    8. Resumen pagos
                    9. Salir
                    """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            try {

                switch (opcion) {

                    case 1 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String doc = JOptionPane.showInputDialog("Documento:");

                        Empleado e = new EmpleadoPlanta(
                                nombre, doc, 25, 1000,
                                CategoriaEmpleado.JUNIOR,
                                4, 4,
                                "Auxiliar", 5, 10, 100
                        );

                        empresa.agregarEmpleado(e);
                        JOptionPane.showMessageDialog(null, "Empleado agregado");
                    }

                    case 2 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String doc = JOptionPane.showInputDialog("Documento:");

                        Empleado e = new EmpleadoVentas(
                                nombre, doc, 25, 1000,
                                CategoriaEmpleado.SEMI_SENIOR,
                                4, 4,
                                5000, 10
                        );

                        empresa.agregarEmpleado(e);
                        JOptionPane.showMessageDialog(null, "Empleado agregado");
                    }

                    case 3 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String doc = JOptionPane.showInputDialog("Documento:");

                        Empleado e = new EmpleadoTemporal(
                                nombre, doc, 25,
                                CategoriaEmpleado.JUNIOR,
                                4, 4,
                                20, 50
                        );

                        empresa.agregarEmpleado(e);
                        JOptionPane.showMessageDialog(null, "Empleado agregado");
                    }

                    case 4 -> {
                        StringBuilder lista = new StringBuilder();

                        for (String emp : empresa.mostrarEmpleados()) {
                            lista.append(emp).append("\n");
                        }

                        JOptionPane.showMessageDialog(null, lista.toString());
                    }

                    case 5 -> {
                        String doc = JOptionPane.showInputDialog("Documento:");

                        Empleado e = empresa.buscarEmpleado(doc);

                        if (e != null)
                            JOptionPane.showMessageDialog(null, e.mostrarInformacion());
                        else
                            JOptionPane.showMessageDialog(null, "No encontrado");
                    }

                    case 6 -> {
                        Empleado e = empresa.empleadoMayorSalario();

                        if (e != null)
                            JOptionPane.showMessageDialog(null,
                                    "Mayor salario:\n" + e.mostrarInformacion());
                    }

                    case 7 -> {
                        JOptionPane.showMessageDialog(null,
                                "Nómina total: " + empresa.nominaTotal());
                    }

                    case 8 -> {
                        StringBuilder resumen = new StringBuilder();

                        for (ResumenPago r : empresa.generarResumenes()) {
                            resumen.append(r.nombre())
                                    .append(" | Neto: ")
                                    .append(r.salarioNeto())
                                    .append("\n");
                        }

                        JOptionPane.showMessageDialog(null, resumen.toString());
                    }

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en los datos");
            }

        } while (opcion != 9);
    }
}