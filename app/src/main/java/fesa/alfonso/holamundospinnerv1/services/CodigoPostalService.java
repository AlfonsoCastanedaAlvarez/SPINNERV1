package fesa.alfonso.holamundospinnerv1.services;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fesa.alfonso.holamundospinnerv1.models.DireccionModel;
import fesa.alfonso.holamundospinnerv1.models.EstadoModel;

public class CodigoPostalService {

    public void obtenerTodosLosEstados(ApiCallback<List<EstadoModel>> callback) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            List<EstadoModel> listaFija = new ArrayList<>();
            listaFija.add(new EstadoModel(1, "Aguascalientes"));
            listaFija.add(new EstadoModel(2, "Baja California"));
            listaFija.add(new EstadoModel(3, "Baja California Sur"));
            listaFija.add(new EstadoModel(4, "Campeche"));
            listaFija.add(new EstadoModel(5, "Chiapas"));
            listaFija.add(new EstadoModel(6, "Chihuahua"));
            listaFija.add(new EstadoModel(7, "Ciudad de México"));
            listaFija.add(new EstadoModel(8, "Coahuila"));
            listaFija.add(new EstadoModel(9, "Colima"));
            listaFija.add(new EstadoModel(10, "Durango"));
            listaFija.add(new EstadoModel(11, "Estado de México"));
            listaFija.add(new EstadoModel(12, "Guanajuato"));
            listaFija.add(new EstadoModel(13, "Guerrero"));
            listaFija.add(new EstadoModel(14, "Hidalgo"));
            listaFija.add(new EstadoModel(15, "Jalisco"));
            listaFija.add(new EstadoModel(16, "Michoacán"));
            listaFija.add(new EstadoModel(17, "Morelos"));
            listaFija.add(new EstadoModel(18, "Nayarit"));
            listaFija.add(new EstadoModel(19, "Nuevo León"));
            listaFija.add(new EstadoModel(20, "Oaxaca"));
            listaFija.add(new EstadoModel(21, "Puebla"));
            listaFija.add(new EstadoModel(22, "Querétaro"));
            listaFija.add(new EstadoModel(23, "Quintana Roo"));
            listaFija.add(new EstadoModel(24, "San Luis Potosí"));
            listaFija.add(new EstadoModel(25, "Sinaloa"));
            listaFija.add(new EstadoModel(26, "Sonora"));
            listaFija.add(new EstadoModel(27, "Tabasco"));
            listaFija.add(new EstadoModel(28, "Tamaulipas"));
            listaFija.add(new EstadoModel(29, "Tlaxcala"));
            listaFija.add(new EstadoModel(30, "Veracruz"));
            listaFija.add(new EstadoModel(31, "Yucatán"));
            listaFija.add(new EstadoModel(32, "Zacatecas"));

            if (callback != null) {
                callback.onSuccess(listaFija);
            }
        }, 2000);
    }

    public void guardarDireccion(DireccionModel direccion, ApiCallback<String> callback) {
        // Simulamos el envío a un servidor
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Log.d("CodigoPostalService", "Guardando: " + direccion.toString());
            if (callback != null) {
                callback.onSuccess("Dirección guardada correctamente");
            }
        }, 1500);
    }
}