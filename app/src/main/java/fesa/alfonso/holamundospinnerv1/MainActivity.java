package fesa.alfonso.holamundospinnerv1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import fesa.alfonso.holamundospinnerv1.models.DireccionModel;
import fesa.alfonso.holamundospinnerv1.models.EstadoModel;
import fesa.alfonso.holamundospinnerv1.services.ApiCallback;
import fesa.alfonso.holamundospinnerv1.services.CodigoPostalService;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Spinner spinner;
    EditText etMunicipio, etColonia, etCalleNumero, etReferencia;
    Button btnGuardar;
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

        spinner = findViewById(R.id.spinner);
        progressBar = findViewById(R.id.progressBar);
        etMunicipio = findViewById(R.id.editTextText);
        etColonia = findViewById(R.id.editTextText2);
        etCalleNumero = findViewById(R.id.editTextText3);
        etReferencia = findViewById(R.id.editTextText4);
        btnGuardar = findViewById(R.id.button);

        service = new CodigoPostalService();

        cargarEstados();

        btnGuardar.setOnClickListener(v -> guardarDireccion());
    }

    public void cargarEstados() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
        service.obtenerTodosLosEstados(new ApiCallback<List<EstadoModel>>() {
            @Override
            public void onSuccess(List<EstadoModel> estados) {
                runOnUiThread(() -> {
                    llenarSpinner(estados);
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    public void llenarSpinner(List<EstadoModel> estados) {
        estados.add(0, new EstadoModel(0, "Seleccione un estado"));
        ArrayAdapter<EstadoModel> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                estados
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void guardarDireccion() {
        EstadoModel estadoSeleccionado = (EstadoModel) spinner.getSelectedItem();

        if (estadoSeleccionado == null || estadoSeleccionado.getId() == 0) {
            Toast.makeText(this, "Por favor seleccione un estado", Toast.LENGTH_SHORT).show();
            return;
        }

        String municipio = etMunicipio.getText().toString().trim();
        String colonia = etColonia.getText().toString().trim();
        String calle = etCalleNumero.getText().toString().trim();
        String referencia = etReferencia.getText().toString().trim();

        if (municipio.isEmpty() || colonia.isEmpty() || calle.isEmpty()) {
            Toast.makeText(this, "Por favor complete los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        DireccionModel direccion = new DireccionModel(
                estadoSeleccionado,
                municipio,
                colonia,
                calle,
                referencia
        );

        progressBar.setVisibility(ProgressBar.VISIBLE);
        service.guardarDireccion(direccion, new ApiCallback<String>() {
            @Override
            public void onSuccess(String resolve) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    Toast.makeText(MainActivity.this, resolve, Toast.LENGTH_LONG).show();
                });
            }

            @Override
            public void onError(String error) {
                runOnUiThread(() -> {
                    progressBar.setVisibility(ProgressBar.INVISIBLE);
                    Toast.makeText(MainActivity.this, "Error al guardar: " + error, Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}