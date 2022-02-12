package com.example.musing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.musing.db.DbUsuarios;

public class SignUp extends AppCompatActivity {

    EditText etUsuario,etCorreo,etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etUsuario = findViewById(R.id.etUsuario);
        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);
    }

    public void Registrarse(View view) {
        String usuario = etUsuario.getText().toString();
        String correo = etCorreo.getText().toString();
        String password = etPassword.getText().toString();
        if(!usuario.isEmpty() && !correo.isEmpty() && !password.isEmpty() ){
            DbUsuarios dbUsuarios = new DbUsuarios(SignUp.this);
            long id = dbUsuarios.insertarUsuario(usuario,correo,password);
            if(id > 0){
                Toast.makeText(SignUp.this, "SE HA REGISTRADO CORRECTAMENTE",Toast.LENGTH_LONG).show();
                limpiar();
                Intent intent = new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(SignUp.this, "DEBE DE RELLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();
        }
    }
    public void limpiar(){
        etUsuario.setText("");
        etCorreo.setText("");
        etPassword.setText("");
    }
}
