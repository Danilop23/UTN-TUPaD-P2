package edu.utn.tp8;

import edu.utn.tp8.contratos.Notificable;

public class Cliente implements Notificable {
    private final String nombre;
    private final String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public String getEmail()  { return email; }

    @Override
    public void notificar(String mensaje) {
        // Simulación de notificación (podría ser email, push, etc.)
        System.out.println("[Notificación a " + nombre + " <" + email + ">] " + mensaje);
    }
}
