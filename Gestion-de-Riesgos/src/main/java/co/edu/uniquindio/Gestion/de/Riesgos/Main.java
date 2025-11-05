package co.edu.uniquindio.Gestion.de.Riesgos;

import com.example.proyecto_final.Model.SistemaGestionDesastres;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        SistemaGestionDesastres s = new SistemaGestionDesastres();
        s.inicializarSistema();

        // Configurar Spark
        port(8080);
        staticFiles.location("/static");

        // Rutas de la API
        get("/api/reporte", (req, res) -> {
            res.type("application/json");
            return s.generarReporteGeneral();
        });
    }
}
