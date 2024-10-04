package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para almacenar registros.
 */
public class AlmacenadoRegistro implements Serializable {
    private static final long serialVersionUID = 1L; // Versión de serialización

    // Lista para almacenar registros
    private List<Registro> lstRegistros;

    // Constructor
    public AlmacenadoRegistro() {
        lstRegistros = new ArrayList<>(); // Inicializa la lista de registros
    }
    
    // Método para agregar un nuevo registro
    public boolean agregarRegistro(Registro registro) {
        return lstRegistros.add(registro);
    }

    // Método para obtener la lista de registros
    public List<Registro> getLstRegistros() {
        return lstRegistros;
    }
    
}

