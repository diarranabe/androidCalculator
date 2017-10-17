package com.diarranabe.calculator.calculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private TextView textViewHaut;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnce;
    private Button btnc;
    private Button btndel;
    private Button btndiv;
    private Button btnmulti;
    private Button btnminus;
    private Button btnplus;
    private Button btnequal;
    private Button btncomma;
    private Button btnplusminus;
    private Button btn;

    private String lastScreen = "0";
    private boolean afficheResultat = false;
    private  String valeurHaut = "";
    private  String valeurBas ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        initialisation();

//        screen.setOnLongClickListener(new );
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(this.CLIPBOARD_SERVICE);
            clipboard.setText(screen.getText());
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(this.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("", screen.getText());
            clipboard.setPrimaryClip(clip);
        }

        traitement();

        screen.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                ClipboardManager cManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData cData = ClipData.newPlainText("text", screen.getText());
                cManager.setPrimaryClip(cData);
                Toast.makeText(MainActivity.this, "Ecran copié", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("haut", (String) textViewHaut.getText());
        outState.putString("bas", (String) screen.getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textViewHaut.setText(savedInstanceState.getString("haut"));
        screen.setText(savedInstanceState.getString("bas"));
    }

    public void initialisation(){
        screen = (TextView) this.findViewById(R.id.textView);
        textViewHaut = (TextView) this.findViewById(R.id.textViewHaut);
        btn0 = (Button) this.findViewById(R.id.btn0);
        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        btn3 = (Button) this.findViewById(R.id.btn3);
        btn4 = (Button) this.findViewById(R.id.btn4);
        btn5 = (Button) this.findViewById(R.id.btn5);
        btn6 = (Button) this.findViewById(R.id.btn6);
        btn7 = (Button) this.findViewById(R.id.btn7);
        btn8 = (Button) this.findViewById(R.id.btn8);
        btn9 = (Button) this.findViewById(R.id.btn9);
        btnce = (Button) this.findViewById(R.id.btnce);
        btnc = (Button) this.findViewById(R.id.btnc);
        btndel = (Button) this.findViewById(R.id.btndel);
        btndiv = (Button) this.findViewById(R.id.btndiv);
        btnmulti = (Button) this.findViewById(R.id.btnmulti);
        btnminus = (Button) this.findViewById(R.id.btnminus);
        btnplus = (Button) this.findViewById(R.id.btnplus);
        btnequal = (Button) this.findViewById(R.id.btnequal);
        btncomma = (Button) this.findViewById(R.id.btncomma);
        btnplusminus = (Button) this.findViewById(R.id.btnplusminus);
    }

    public void traitement(){
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ecrire("9");
            }
        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeOperateur("/");
            }
        });

        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeOperateur("*");
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeOperateur("-");
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeOperateur("+");
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afficheResultat();
            }
        });

        btnplusminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeMoinsUnaire();
            }
        });



    }


    public void ecrire(String chaine) {
        if (afficheResultat) {
            afficheResultat = false;
//            screen.setText(lastScreen);
            screen.setText("");
        }
        screen.setText(screen.getText() + chaine);
        textViewHaut.setText("");
    }



    public void writeMoinsUnaire() {
        String chaine = (String) screen.getText();
        String newChaine = "";
        if (Operateur.containsOperateur(chaine)) {
            int index = Operateur.lastOperateurIndex(chaine);
            String op = Operateur.lastOperateur(chaine);
            if (op.equals("+")) {
                op = "-";
            } else if (op.equals("-")) {
                if (index != 0) {
                    if (Operateur.isOperateur("" + chaine.charAt(index - 1))) {
                        op = "";
                    } else {
                        op = "+";
                    }
                } else {
                    op = "";
                }

            } else {
                op = op + "-";
            }
            newChaine = chaine.substring(0, index) + op + chaine.substring(index + 1);

        } else {
            newChaine = "-" + chaine;
        }
        screen.setText(newChaine);
        afficheResultat = false;
    }



    public void writeOperateur(String chaine) {
        String newChar = "";
        faireEtat();
        if (screen.getText().length() > 0) {
            switch (chaine) {
                case "+":
                    newChar = "+";
                    break;
                case "-":
                    newChar = "-";
                    break;
                case "*":
                    newChar = "*";
                    break;
                case "/":
                    newChar = "/";
                    break;
                case "%":
                    newChar = "%";
                    break;
            }
            screen.setText(screen.getText() + newChar);
        }
    }


    public void delete() {
        if (screen.getText().length() > 0) {
            String text = (String) screen.getText();
            screen.setText(text.substring(0, screen.getText().length() - 1));
            afficheResultat = false;
        }
    }


    public void reset() {
        screen.setText("");
        lastScreen = "";
        afficheResultat = false;
    }


    public void afficheResultat() {
        if (!afficheResultat && calculPossible()) {
            String result = calcul((String) screen.getText());
//            screen.setText(screen.getText() + " = " + result);
            textViewHaut.setText(screen.getText());
            screen.setText(result);
            afficheResultat = true;
            lastScreen = result;
        } else {

        }
    }

    public boolean calculPossible() {
        int posSigne = detectSigne((String) screen.getText());
        return ((posSigne != -1) && (posSigne < screen.getText().length() - 1));
    }

    public int detectSigne(String chaine) {
        int position = -1;
        for (int i = 0; i < chaine.length(); i++) {
            if ((i > 0) && (Operateur.isOperateur(String.valueOf(chaine.charAt(i))))) {
                position = i;
                break;
            }
        }
        return position;
    }

    public String calcul(String chaine) {
        int posOperateur = detectSigne(chaine);
        Operateur op = new Operateur(String.valueOf(chaine.charAt(posOperateur)), 1);
        return op.operation(chaine.substring(0, posOperateur), chaine.substring(posOperateur + 1));
    }

    public void faireEtat() {
        if (afficheResultat) {
            String first = String.valueOf(lastScreen.charAt(0));
            afficheResultat = false;
            if (first.equals("#")) {
                lastScreen = "";
            }
//            screen.setText(lastScreen);
            screen.setText(lastScreen);
        }
        if (calculPossible()) {
            screen.setText(calcul((String)screen.getText()));
        } else if (screen.getText().length() > 0) {
            if (Operateur.isOperateur(String.valueOf(screen.getText().charAt(screen.getText().length() - 1)))) {
                delete();
            }
        }
    }



}
