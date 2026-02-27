package fesa.alfonso.holamundospinnerv1.services;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import fesa.alfonso.holamundospinnerv1.models.EstadoModel;

public class CodigoPostalService {
//    public List<EstadoModel> obtenerTodosLosEstados(){
//        List<EstadoModel> estados = new ArrayList<>();
//
//        estados.add(new EstadoModel(1, "Ciudad de México"));
//        estados.add(new EstadoModel(2, "Estado de México"));
//
//        return estados;
//    }

    public void obtenerTodosLosEstados(ApiCallback<List<EstadoModel>> callback) {

        new Handler(Looper.getMainLooper()).postDelayed(() -> {

            List<EstadoModel> listaFija = new ArrayList<>();
            listaFija.add(new EstadoModel(1, "CDMX"));
            listaFija.add(new EstadoModel(2, "Jalisco"));
            listaFija.add(new EstadoModel(3, "Nuevo León"));

            if (callback != null) {
                callback.onSuccess(listaFija);
            }

        }, 2000); // 2 segundos de delay
    }


}