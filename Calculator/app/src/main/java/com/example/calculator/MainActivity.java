package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> liste = new ArrayList<String>();
    ArrayList<Double> sayilar = new ArrayList<Double>();


    String sayi = "";
    Double sonuc = 0.0;

    TextView solution, result;

    Button button_AC, button_C, button_Dot, button_Result,
            button_plus, button_minus, button_multiple, button_division,
            button_one, button_two, button_three, button_four,
            button_five, button_six, button_seven, button_eight,
            button_nine, button_zero, button_thousand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        solution=findViewById(R.id.solution);

        button_AC= (Button) findViewById(R.id.button_AC);
        button_C=(Button)findViewById(R.id.button_C);
        button_Dot=(Button)findViewById(R.id.button_Dot);
        button_Result=(Button)findViewById(R.id.button_equal);

        button_plus=(Button)findViewById(R.id.button_plus);
        button_minus=(Button)findViewById(R.id.button_minus);
        button_multiple=(Button)findViewById(R.id.button_multi);
        button_division=(Button)findViewById(R.id.button_div);

        button_zero=(Button)findViewById(R.id.buttonZero);
        button_one=(Button)findViewById(R.id.button_one);
        button_two=(Button)findViewById(R.id.button_two);
        button_three=(Button)findViewById(R.id.button_three);
        button_four=(Button)findViewById(R.id.button_four);
        button_five=(Button)findViewById(R.id.button_five);
        button_six=(Button)findViewById(R.id.button_six);
        button_seven=(Button)findViewById(R.id.button_seven);
        button_eight=(Button)findViewById(R.id.button_eight);
        button_nine=(Button)findViewById(R.id.button_nine);
        button_thousand=(Button)findViewById(R.id.button_thousand);

        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "1");
                sayi = sayi + "1";

            }
        });

        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "2");
                sayi = sayi + "2";
            }
        });

        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "3");
                sayi = sayi + "3";
            }
        });

        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "4");
                sayi = sayi + "4";
            }
        });

        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "5");
                sayi = sayi + "5";
            }
        });

        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "6");
                sayi = sayi + "6";
            }
        });

        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "7");
                sayi = sayi + "7";
            }
        });

        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "8");
                sayi = sayi + "8";
            }
        });

        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "9");
                sayi = sayi + "9";
            }
        });

        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "0");
                sayi = sayi + "0";
            }
        });

        button_thousand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "000");
                sayi = sayi + "000";
            }
        });

        button_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("");
                solution.setText("");
                sayi = "";
                sonuc = 0.0;
                liste.clear();
                sayilar.clear();
            }
        });

        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sayi = sayi.substring(0, sayi.length()-1);
                result.setText(result.getText().toString().substring(0, result.getText().toString().length()-1));
            }
        });

        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + ",");
                sayi = sayi + ",";
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "+");
                sayilar.add(Double.valueOf(sayi));
                sayi = "";
                liste.add("+");
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "-");
                sayilar.add(Double.valueOf(sayi));
                sayi = "";
                liste.add("-");
            }
        });

        button_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "*");
                sayilar.add(Double.valueOf(sayi));
                sayi = "";
                liste.add("*");
            }
        });

        button_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "/");
                sayilar.add(Double.valueOf(sayi));
                sayi = "";
                liste.add("/");
            }
        });

        button_Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution.setText(result.getText());
                sayilar.add(Double.valueOf(sayi));
                sayi = "";
                hesaplaCarpmaBolme(liste, sayilar);
                hesaplaToplamaCikarma(liste, sayilar);
                sayilar.clear();
                sayi = String.valueOf(sonuc);
                result.setText(String.valueOf(sonuc));
            }
        });

    }

    private void hesaplaCarpmaBolme(ArrayList<String> liste, ArrayList<Double> sayilar) {
        for (int i = 0; i<liste.size(); ++i) {
            if (liste.get(i).equals("*")) {
                sonuc = sayilar.get(i) * sayilar.get(i+1);
                liste.remove(i);
                sayilar.remove(i);
                sayilar.remove(i);
                sayilar.add(i, sonuc);
                hesaplaCarpmaBolme(liste, sayilar);
            } else if (liste.get(i).equals("/")) {
                sonuc = sayilar.get(i) / sayilar.get(i+1);
                liste.remove(i);
                sayilar.remove(i);
                sayilar.remove(i);
                sayilar.add(i, sonuc);
                hesaplaCarpmaBolme(liste, sayilar);
            }
        }

    }

    private void hesaplaToplamaCikarma(ArrayList<String> liste, ArrayList<Double> sayilar) {
        for (int i = 0; i<liste.size(); ++i) {
            if (liste.get(i).equals("+")) {
                sonuc = sayilar.get(i) + sayilar.get(i+1);
                liste.remove(i);
                sayilar.remove(i);
                sayilar.remove(i);
                sayilar.add(i, sonuc);
                hesaplaToplamaCikarma(liste, sayilar);
            } else if (liste.get(i).equals("-")) {
                sonuc = sayilar.get(i) - sayilar.get(i+1);
                liste.remove(i);
                sayilar.remove(i);
                sayilar.remove(i);
                sayilar.add(i, sonuc);
                hesaplaToplamaCikarma(liste, sayilar);
            }
        }

    }

}