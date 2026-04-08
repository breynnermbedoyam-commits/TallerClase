package org.example;

public abstract class Empleado {

    protected String nombre, documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoria;
    protected float descuentoSalud, descuentoPension;

    public Empleado(String nombre, String documento, int edad, float salarioBase,
                    CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension) {

        if (salarioBase < 0) throw new IllegalArgumentException("Salario inválido");

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }

    public abstract float calcularSalarioBruto();

    public float calcularBonificacionCategoria() {
        return switch (categoria) {
            case JUNIOR -> salarioBase * 0.05f;
            case SEMI_SENIOR -> salarioBase * 0.10f;
            case SENIOR -> salarioBase * 0.15f;
        };
    }

    public float calcularDescuentos() {
        return calcularSalarioBruto() * (descuentoSalud + descuentoPension) / 100;
    }

    public float calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public ResumenPago generarResumenPago() {
        return new ResumenPago(
                documento,
                nombre,
                this.getClass().getSimpleName(),
                calcularSalarioBruto(),
                calcularDescuentos(),
                calcularSalarioNeto()
        );
    }

    public String mostrarInformacion() {
        return nombre + " - " + documento + " - Neto: " + calcularSalarioNeto();
    }

    public String getDocumento() {
        return documento;
    }
}