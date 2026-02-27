package fesa.alfonso.holamundospinnerv1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fesa.alfonso.holamundospinnerv1.models.EstadoModel;
import fesa.alfonso.holamundospinnerv1.services.ApiCallback;
import fesa.alfonso.holamundospinnerv1.services.CodigoPostalService;

public class MainActivity extends AppCompatActivity {

    // 1.- Declarar el control

    ProgressBar progressBar;
    Spinner spinner;
    CodigoPostalService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2.- Enlazar con la vista
        spinner = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        // Instanciar servicio
        service = new CodigoPostalService();

        // Obtener estados
        cargarEstados();


    }

    public void cargarEstados(){
        service.obtenerTodosLosEstados(new ApiCallback<List<EstadoModel>>() {

            @Override
            public void onSuccess(List<EstadoModel> estados) {
                runOnUiThread(()-> {
                    // Llenar spinner
                    llenarSpinner(estados);
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                });
            }

            @Override
            public void onError(String error) {

            }
        });

    };

    public void llenarSpinner(List<EstadoModel> estados) {
        estados.add(0, new EstadoModel(0, "Seleccione"));
        ArrayAdapter<EstadoModel> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                estados
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }
}