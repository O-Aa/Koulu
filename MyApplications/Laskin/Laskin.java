package com.example.olli.laskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    // Asetetaan numero- sekä laskutoimitus napeille ID:t
    // Taulukkomuoto nopeuttaa onClickListenerien asettamisessa
    private int[] numeroNapit = {R.id.nappi0, R.id.nappi1, R.id.nappi2, R.id.nappi3, R.id.nappi4,
                                R.id.nappi5, R.id.nappi6, R.id.nappi7, R.id.nappi8, R.id.nappi9};
    private int[] laskuNapit = {R.id.nappiPlus, R.id.nappiMiinus, R.id.nappiKerto, R.id.nappiJako};

    // Naytto, mihin tulostuu laskutoimitukset ja tulos
    private TextView naytto;

    // Apumuuttuja, jonka avulla tarkastetaan onko viimeinen merkki numero vai piste
    private boolean vikaNro;

    // Apumuuttuja virheiden tarkastamiseen laskutoimituksessa
    private boolean onkoVirhe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asetetaan näytölle ID
        this.naytto = (TextView) findViewById(R.id.txtScreen);

        /* Asetetaan kaikille painikkeille Listener, jonka avulla painallukset
           tallentuvat näytölle*/
        numeroListener();
        laskutoimitusListener();
    }


    // Luodaan listener ja asetetaan se numeropainikkeille
    private void numeroListener() {
        View.OnClickListener listeneriNro = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Luodaan painike muuttuja
                Button painike = (Button) v;
                // Työnnetään painallukset näytölle käyttäjän näkyville
                naytto.append(painike.getText());
                vikaNro = true;
            }
        };

        // Asetetaan listeneri numeropainikkeille
        for (int id : numeroNapit) {
            findViewById(id).setOnClickListener(listeneriNro);
        }
    }

    // Luodaan listener ja asetetaan se laskutoimitus-, pyyhi- ja yhtäkuinpainikkeille
    private void laskutoimitusListener() {
        View.OnClickListener listeneriLasku = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Luodaan painike muuttuja, jonka avulla työnnetään painallukset näytölle
                Button painike = (Button) v;
                naytto.append(painike.getText());
                vikaNro = false;
            }
        };

        // Asetetaan listeneri laskutoimituspainikkeille
        for (int id : laskuNapit) {
            findViewById(id).setOnClickListener(listeneriLasku);
        }

        // Pyyhi painike, jolla tyhjennetään näyttö
        findViewById(R.id.nappiC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                naytto.setText("");
                vikaNro = false;
            }
        });

        // = painike, millä tulostetaan tulos näytölle
        findViewById(R.id.nappiTulos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Laske();
            }
        });
    }

    // Käytetään exp4j kirjastoa, jonka avulla tulos lasketaan merkkijonosta
    private void Laske() {

        // Jos virhettä ei ole ja viimeinen merkki on numero, ratkaistaan
        // Muuten annetaan virheilmoitus
        if (vikaNro && !onkoVirhe) {

            // Luetaan ja luodaan expression
            String lasku = naytto.getText().toString();
            Expression testi = new ExpressionBuilder(lasku).build();

            try {
                // Lasketaan lopputulos ja näytetään se näytöllä
                double lopputulos = testi.evaluate();
                naytto.setText(Double.toString(lopputulos));

            }
            // Virheen sattuessa näytetään virheilmoitus näytölle
            catch (ArithmeticException ex) {
                naytto.setText("Tapahtui virhe");
                onkoVirhe = true;
                vikaNro = false;
            }
        }
    }
}

