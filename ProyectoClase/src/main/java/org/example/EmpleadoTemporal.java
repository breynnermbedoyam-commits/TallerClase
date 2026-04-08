package org.example;

public class EmpleadoTemporal extends Empleado {

    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad,
                            CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension,
                            int diasTrabajados, float valorDia) {

        super(nombre, documento, edad, 0, categoria, descuentoSalud, descuentoPension);

        if (diasTrabajados < 0 || valorDia < 0)
            throw new IllegalArgumentException();

        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        return (diasTrabajados * valorDia) + calcularBonificacionCategoria();
    }
}