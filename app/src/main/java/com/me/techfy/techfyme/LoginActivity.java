package com.me.techfy.techfyme;

import android.content.Intent;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.me.techfy.techfyme.CadastroActivity;
import com.me.techfy.techfyme.HomeActivity;
import com.me.techfy.techfyme.R;

public class LoginActivity extends AppCompatActivity {

    public static final String CHAVE_EMAIL = "chave_email";
    Button botaoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


         botaoLogin = findViewById(R.id.button_login);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClicado();
            }
        });



    }

    public void loginClicado (){

        Intent intent = new Intent(this, MenuHomeActivity.class);

        Bundle bundle = new Bundle();

        final TextInputEditText emailDigitado = findViewById(R.id.edit_text_email_id);
        final TextInputEditText passwordDigitado = findViewById(R.id.edit_text_password_id);


        if((emailDigitado.getText().toString().equals("GuiSartori") || emailDigitado.getText().toString().equals(""))  && (passwordDigitado.getText().toString().equals("2018") || passwordDigitado.getText().toString().equals(""))){
            bundle.putString(CHAVE_EMAIL, emailDigitado.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }   else {
            emailDigitado.setTextColor(getResources().getColor(R.color.colorErro));
            passwordDigitado.setTextColor(getResources().getColor(R.color.colorErro));

            Snackbar.make(botaoLogin, "Email e/ou senha incorreto(s)", BaseTransientBottomBar.LENGTH_LONG)

                    .setAction("Ok, entendi", new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            emailDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
                            passwordDigitado.setTextColor(getResources().getColor(R.color.colorPrimary));
                        }
                    }).show();
        }

    }
}






