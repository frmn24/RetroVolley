package com.example.logindanregistervolleymysql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.text.InputType;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private EditText etUsername, etPassword, etAlamat, etTgllahir, etEmail, etNama, etNohp;
    private Spinner etGender, etAgama;
    private Button btnRegister, btnPickDate;

    private DatePickerDialog datePickerDialog;
    private EditText editTextDateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etAlamat = findViewById(R.id.etAlamat);
        etNohp = findViewById(R.id.etNohp);
        etEmail = findViewById(R.id.etEmail);
        etNama = findViewById(R.id.etFullname);
        etTgllahir = findViewById(R.id.etTgllahir);
        btnRegister = findViewById(R.id.btnRegister);

        etGender = findViewById(R.id.etGender);
        etAgama = findViewById(R.id.etAgama);

        editTextDateOfBirth = findViewById(R.id.etTgllahir);

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etGender.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> agamaAdapter = ArrayAdapter.createFromResource(this, R.array.agama_array, android.R.layout.simple_spinner_item);
        agamaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etAgama.setAdapter(agamaAdapter);

        // Set up input type for the date picker EditText
        editTextDateOfBirth.setInputType(InputType.TYPE_NULL);

        // Initialize the date picker dialog
        editTextDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int year = cldr.get(Calendar.YEAR);
                int month = cldr.get(Calendar.MONTH);
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Set the selected date in the EditText
                        editTextDateOfBirth.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
//volley
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String alamat = etAlamat.getText().toString();
                String nohp = etNohp.getText().toString();
                String tgllahir = etTgllahir.getText().toString();
                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                String gender = etGender.getSelectedItem().toString();
                String agama = etAgama.getSelectedItem().toString();

                if (!(username.isEmpty() || password.isEmpty() || alamat.isEmpty())) {
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Db_Contract.urlRegister, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Login.class));
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "Terjadi kesalahan: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("name", nama);
                            params.put("username", username);
                            params.put("password", password);
                            params.put("nohp", nohp);
                            params.put("email", email);
                            params.put("alamat", alamat);
                            params.put("tgllahir", tgllahir);
                            params.put("gender", gender);
                            params.put("agama", agama);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(getApplicationContext(), "Ada data yang masih kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
