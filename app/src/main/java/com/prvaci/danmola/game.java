package com.prvaci.danmola;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class game extends AppCompatActivity {

    int brPitanje, tacni;
    String corAns;
    int[] pitId = new int[10];
    String[][] pitanja = {{"Koji od navedenih iskaza je tacan? Vodonik:","","gradi jednoatomske molekule","je teži od vazduha","je gas","je bele boje","3"},
            {"Formula molekula vodonika je:","","H","H₂","O₂","2H","2"},
            {"Formula ozona je:","","O₂","3O","F₃","O₃","4"},
            {"Binarna jedinjenja kiseonika nazivaju se:","","hidridi","oksidi","sulfidi","halogeni","2"},
            {"Neophodan reaktant svake reakcije sagorevanja je:","","kiseonik","ugljenik","sumpor","vodonik","1"},
            {"Sumpor gradi sledeći oksid:","","SO₄","S₂O₅","SO₂","S₂O₃","3"},
            {"Formula sumporne kiseline je:","","H₂SO₃","H₃SO₄","HSO₃","H₂SO₄","4"},
            {"Koji od navedenih procesa ima veze sa primenom sumpora:","","centriranje trapa automobila","lakiranje","vulkanizacija gume","zavarivanje auspuha","3"},
            {"Koji se od sledecih nemetala nalazi u istoj grupi Periodnog sistemaelemenata sa sumporom:","","azot","kiseonik","hlor","ugljenik","2"},
            {"Odredi koja je od ponudjenih formula, formula nitritne kiseline:","","NH₃","HNO₂","HNO₃","NO₂","2"},
            {"Valenca azota u oksidu N₂O₂ je:","","II","IV","V","III","4"},
            {"Azot se koristi:","","za konzerviranje hrane","kao sredstvo za čišćenje","prečišćavanje metala","za izradu šibica","1"},
            {"Izdvoj tačno tvrđenje:","","grafit i dijamant su jedinjenja ugljenika","Ugljenik(IV)-oksid je lakši od vazduha","Kristalna rešetka dijamanta sačinjena je od molekula ","Potpunim sagorevanjem ugljenika nastaje ukljen(II)-oksid","2"},
            {"Reakcijom CO₂+H₂O dobija se:","","HCO₃","H₂CO₃","CH₃OH","HCHO","3"},
            {"Koje od navedenih svojstava odgovara ugljeniku(II)-oksidu:","","Koriste ga biljke u procesu fotosinteze","Nastaje potpunim sagorevanjem ugljenika","Sa vodom reaguje gradeći kiselinu","Nalazi se u duvanskom dimu","4"},
            {"Koji od navedenih elemenata provodi elektricitet:","","kalijum","hlor","sumpor","fosfor","1"},
            {"Koji iskaz je tacan? Srebro je:","","dobar provodnik","crvene boje","mekano i može se seći nožem","tečnog agregatnog stanja pri normalnim uslovima","1"},
            {"Koji je najzastupljeniji metal u prirodi:","","zlato","bakar","kalijum","aluminijum","4"},
            {"Koju vrstu čestica grade atomi metala pri povezivanju sa atomima nemetala:","","molekule","katjone","elektrone","anjone","2"},
            {"Koji element ne pripada alkalnim metalima:","","natrijum","litijum","aluminijum","kalijum","3"},
            {"Koja od supstanci ne sadrži kalcijum:","","kamena so","gašeni kreč","krečnjak","krečno mleko","1"},
            {"Koja od ponudjenih supstanci ne reaguje sa vodom:","","litijum","kalcijum-oksid","kalcijum","magnezijum-hidroksid","4"},
            {"Koji iskaz nije tačan:","","bakar je metal crvene boje","čelik sadrži gvoždje i bakar","aluminijum je stabilan na vazduhu","plavi kamen je jedinjenje bakra","2"},
            {"Metal koji ima magnetna svojstva je:","","bakar","srebro","gvoždje","aluminijum","4"},
            {"Koji metal ima stalnu valencu:","","bakar","gvoždje","živa","natrijum","4"},
            {"Koji od navedenih metala lako podlaže koroziji:","","srebro","gvoždje","platina","aluminijum","2"},
            {"Legura aluminijuma je:","","silijum","bronza","kalaj","čelik","1"},
            {"Koja od legura u svom osnovnom sadržaju sadrži nemetal:","","mesing","bronza","duraluminijum","čelik","4"},
            {"Mesing je legura:","","bakra i cinka","bakra i kalaja","gvoždja i cinka","gvoždja i kalaja","1"},
            {"Koji oksid gvoždja nastaje dužim stajanjem na vazduhu u vlažnim uslovima:","","Fe₂","FeO","Fe(OH)₂","Fe₂O₃","4"},
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView txtPitanje = (findViewById(R.id.txtPitanje));
        ImageView imgSlika = (findViewById(R.id.imgSlika));
        Button butAnswer1 = (findViewById(R.id.butAnswer1));
        Button butAnswer2 = (findViewById(R.id.butAnswer2));
        Button butAnswer3 = (findViewById(R.id.butAnswer3));
        Button butAnswer4 = (findViewById(R.id.butAnswer4));
        brPitanje = 0;
        tacni = 0;
        Random randy = new Random();
        for (int i = 0; i < pitId.length; i++) {
            int temp;
            boolean isExists;
            do {
                isExists = false;
                temp = ThreadLocalRandom.current().nextInt(1,pitanja.length);

                for (int j = 0; j < i; j++)
                {
                    if (pitId[j] == temp)
                    {
                        isExists = true;
                        break;
                    }
                }
            } while (isExists);
            pitId[i] = temp;
        }
        int rnd = pitId[brPitanje];
        txtPitanje.setText(pitanja[rnd][0]);
        if (pitanja[rnd][1].equals("")) {
            imgSlika.setImageResource(R.drawable.erlen);
        } else {
            imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
        }
        butAnswer1.setText(pitanja[rnd][2]);
        butAnswer2.setText(pitanja[rnd][3]);
        butAnswer3.setText(pitanja[rnd][4]);
        butAnswer4.setText(pitanja[rnd][5]);
        corAns = pitanja[rnd][6];
        brPitanje++;
    }

    public void answer1Click(View view)
    {
        TextView txtPitanje = (findViewById(R.id.txtPitanje));
        ImageView imgSlika = (findViewById(R.id.imgSlika));
        Button butAnswer1 = (findViewById(R.id.butAnswer1));
        Button butAnswer2 = (findViewById(R.id.butAnswer2));
        Button butAnswer3 = (findViewById(R.id.butAnswer3));
        Button butAnswer4 = (findViewById(R.id.butAnswer4));
        if(corAns=="1")
        {
            tacni++;
            MediaPlayer tacan=MediaPlayer.create(this,R.raw.correct_answer);
            tacan.start();
            Toast.makeText(this, "Čestitamo! Tačan odgovor!", Toast.LENGTH_SHORT).show();
            if(brPitanje<10) {
                int rnd = pitId[brPitanje];
                txtPitanje.setText(pitanja[rnd][0]);
                if (pitanja[rnd][1].equals("")) {
                    imgSlika.setImageResource(R.drawable.erlen);
                } else {
                    imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                }
                butAnswer1.setText(pitanja[rnd][2]);
                butAnswer2.setText(pitanja[rnd][3]);
                butAnswer3.setText(pitanja[rnd][4]);
                butAnswer4.setText(pitanja[rnd][5]);
                corAns = pitanja[rnd][6];
                brPitanje++;
            }else{
                Intent intent = new Intent(this,gameend.class);
                intent.putExtra("tacni",tacni);
                startActivity(intent);
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String tacan = "";
            switch (corAns){
                case "1":

                    tacan = butAnswer1.getText().toString();
                    break;
                case "2":
                    tacan = butAnswer2.getText().toString();
                    break;
                case "3":
                    tacan = butAnswer3.getText().toString();
                    break;
                case "4":
                    tacan = butAnswer4.getText().toString();
                    break;
            }
            MediaPlayer netacan=MediaPlayer.create(this,R.raw.incerrect_answer);
            netacan.start();
            builder.setMessage("Netačan odgovor. Tačan odgovor je: " + tacan)
                    .setTitle("Netačno");

            builder.setPositiveButton("U redu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if(brPitanje<10) {
                        TextView txtPitanje = (findViewById(R.id.txtPitanje));
                        ImageView imgSlika = (findViewById(R.id.imgSlika));
                        Button butAnswer1 = (findViewById(R.id.butAnswer1));
                        Button butAnswer2 = (findViewById(R.id.butAnswer2));
                        Button butAnswer3 = (findViewById(R.id.butAnswer3));
                        Button butAnswer4 = (findViewById(R.id.butAnswer4));
                        int rnd = pitId[brPitanje];
                        txtPitanje.setText(pitanja[rnd][0]);
                        if (pitanja[rnd][1].equals("")) {
                            imgSlika.setImageResource(R.drawable.erlen);
                        } else {
                            imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                        }
                        butAnswer1.setText(pitanja[rnd][2]);
                        butAnswer2.setText(pitanja[rnd][3]);
                        butAnswer3.setText(pitanja[rnd][4]);
                        butAnswer4.setText(pitanja[rnd][5]);
                        corAns = pitanja[rnd][6];
                        brPitanje++;
                    }else{
                        Intent intent = new Intent(getApplicationContext(),gameend.class);
                        intent.putExtra("tacni",tacni);
                        startActivity(intent);
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    public void answer2Click(View view)
    {
        TextView txtPitanje = (findViewById(R.id.txtPitanje));
        ImageView imgSlika = (findViewById(R.id.imgSlika));
        Button butAnswer1 = (findViewById(R.id.butAnswer1));
        Button butAnswer2 = (findViewById(R.id.butAnswer2));
        Button butAnswer3 = (findViewById(R.id.butAnswer3));
        Button butAnswer4 = (findViewById(R.id.butAnswer4));
        if(corAns=="2")
        {
            tacni++;
            MediaPlayer tacan=MediaPlayer.create(this,R.raw.correct_answer);
            tacan.start();
            Toast.makeText(this, "Čestitamo! Tačan odgovor!", Toast.LENGTH_SHORT).show();
            if(brPitanje<10) {
                int rnd = pitId[brPitanje];
                txtPitanje.setText(pitanja[rnd][0]);
                if (pitanja[rnd][1].equals("")) {
                    imgSlika.setImageResource(R.drawable.erlen);
                } else {
                    imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                }
                butAnswer1.setText(pitanja[rnd][2]);
                butAnswer2.setText(pitanja[rnd][3]);
                butAnswer3.setText(pitanja[rnd][4]);
                butAnswer4.setText(pitanja[rnd][5]);
                corAns = pitanja[rnd][6];
                brPitanje++;
            }else{
                Intent intent = new Intent(this,gameend.class);
                intent.putExtra("tacni",tacni);
                startActivity(intent);
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String tacan = "";
            switch (corAns){
                case "1":
                    tacan = butAnswer1.getText().toString();
                    break;
                case "2":
                    tacan = butAnswer2.getText().toString();
                    break;
                case "3":
                    tacan = butAnswer3.getText().toString();
                    break;
                case "4":
                    tacan = butAnswer4.getText().toString();
                    break;
            }
            MediaPlayer netacan=MediaPlayer.create(this,R.raw.incerrect_answer);
            netacan.start();
            builder.setMessage("Netačan odgovor. Tačan odgovor je: " + tacan)
                    .setTitle("Netačno");

            builder.setPositiveButton("U redu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if(brPitanje<10) {
                        TextView txtPitanje = (findViewById(R.id.txtPitanje));
                        ImageView imgSlika = (findViewById(R.id.imgSlika));
                        Button butAnswer1 = (findViewById(R.id.butAnswer1));
                        Button butAnswer2 = (findViewById(R.id.butAnswer2));
                        Button butAnswer3 = (findViewById(R.id.butAnswer3));
                        Button butAnswer4 = (findViewById(R.id.butAnswer4));
                        int rnd = pitId[brPitanje];
                        txtPitanje.setText(pitanja[rnd][0]);
                        if (pitanja[rnd][1].equals("")) {
                            imgSlika.setImageResource(R.drawable.erlen);
                        } else {
                            imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                        }
                        butAnswer1.setText(pitanja[rnd][2]);
                        butAnswer2.setText(pitanja[rnd][3]);
                        butAnswer3.setText(pitanja[rnd][4]);
                        butAnswer4.setText(pitanja[rnd][5]);
                        corAns = pitanja[rnd][6];
                        brPitanje++;
                    }else{
                        Intent intent = new Intent(getApplicationContext(),gameend.class);
                        intent.putExtra("tacni",tacni);
                        startActivity(intent);
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    public void answer3Click(View view)
    {
        TextView txtPitanje = (findViewById(R.id.txtPitanje));
        ImageView imgSlika = (findViewById(R.id.imgSlika));
        Button butAnswer1 = (findViewById(R.id.butAnswer1));
        Button butAnswer2 = (findViewById(R.id.butAnswer2));
        Button butAnswer3 = (findViewById(R.id.butAnswer3));
        Button butAnswer4 = (findViewById(R.id.butAnswer4));
        if(corAns=="3")
        {
            tacni++;
            MediaPlayer tacan=MediaPlayer.create(this,R.raw.correct_answer);
            tacan.start();
            Toast.makeText(this, "Čestitamo! Tačan odgovor!", Toast.LENGTH_SHORT).show();
            if(brPitanje<10) {
                int rnd = pitId[brPitanje];
                txtPitanje.setText(pitanja[rnd][0]);
                if (pitanja[rnd][1].equals("")) {
                    imgSlika.setImageResource(R.drawable.erlen);
                } else {
                    imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                }
                butAnswer1.setText(pitanja[rnd][2]);
                butAnswer2.setText(pitanja[rnd][3]);
                butAnswer3.setText(pitanja[rnd][4]);
                butAnswer4.setText(pitanja[rnd][5]);
                corAns = pitanja[rnd][6];
                brPitanje++;
            }else{
                Intent intent = new Intent(this,gameend.class);
                intent.putExtra("tacni",tacni);
                startActivity(intent);
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String tacan = "";
            switch (corAns){
                case "1":
                    tacan = butAnswer1.getText().toString();
                    break;
                case "2":
                    tacan = butAnswer2.getText().toString();
                    break;
                case "3":
                    tacan = butAnswer3.getText().toString();
                    break;
                case "4":
                    tacan = butAnswer4.getText().toString();
                    break;
            }
            MediaPlayer netacan=MediaPlayer.create(this,R.raw.incerrect_answer);
            netacan.start();
            builder.setMessage("Netačan odgovor. Tačan odgovor je: " + tacan)
                    .setTitle("Netačno");

            builder.setPositiveButton("U redu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if(brPitanje<10) {
                        TextView txtPitanje = (findViewById(R.id.txtPitanje));
                        ImageView imgSlika = (findViewById(R.id.imgSlika));
                        Button butAnswer1 = (findViewById(R.id.butAnswer1));
                        Button butAnswer2 = (findViewById(R.id.butAnswer2));
                        Button butAnswer3 = (findViewById(R.id.butAnswer3));
                        Button butAnswer4 = (findViewById(R.id.butAnswer4));
                        int rnd = pitId[brPitanje];
                        txtPitanje.setText(pitanja[rnd][0]);
                        if (pitanja[rnd][1].equals("")) {
                            imgSlika.setImageResource(R.drawable.erlen);
                        } else {
                            imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                        }
                        butAnswer1.setText(pitanja[rnd][2]);
                        butAnswer2.setText(pitanja[rnd][3]);
                        butAnswer3.setText(pitanja[rnd][4]);
                        butAnswer4.setText(pitanja[rnd][5]);
                        corAns = pitanja[rnd][6];
                        brPitanje++;
                    }else{
                        Intent intent = new Intent(getApplicationContext(),gameend.class);
                        intent.putExtra("tacni",tacni);
                        startActivity(intent);
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    public void answer4Click(View view)
    {
        TextView txtPitanje = (findViewById(R.id.txtPitanje));
        ImageView imgSlika = (findViewById(R.id.imgSlika));
        Button butAnswer1 = (findViewById(R.id.butAnswer1));
        Button butAnswer2 = (findViewById(R.id.butAnswer2));
        Button butAnswer3 = (findViewById(R.id.butAnswer3));
        Button butAnswer4 = (findViewById(R.id.butAnswer4));
        if(corAns=="4")
        {
            tacni++;
            MediaPlayer tacan=MediaPlayer.create(this,R.raw.correct_answer);
            tacan.start();
            Toast.makeText(this, "Čestitamo! Tačan odgovor!", Toast.LENGTH_SHORT).show();
            if(brPitanje<10) {
                int rnd = pitId[brPitanje];
                txtPitanje.setText(pitanja[rnd][0]);
                if (pitanja[rnd][1].equals("")) {
                    imgSlika.setImageResource(R.drawable.erlen);
                } else {
                    imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                }
                butAnswer1.setText(pitanja[rnd][2]);
                butAnswer2.setText(pitanja[rnd][3]);
                butAnswer3.setText(pitanja[rnd][4]);
                butAnswer4.setText(pitanja[rnd][5]);
                corAns = pitanja[rnd][6];
                brPitanje++;
            }else{
                Intent intent = new Intent(this,gameend.class);
                intent.putExtra("tacni",tacni);
                startActivity(intent);
            }
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String tacan = "";
            switch (corAns){
                case "1":
                    tacan = butAnswer1.getText().toString();
                    break;
                case "2":
                    tacan = butAnswer2.getText().toString();
                    break;
                case "3":
                    tacan = butAnswer3.getText().toString();
                    break;
                case "4":
                    tacan = butAnswer4.getText().toString();
                    break;
            }
            MediaPlayer netacan=MediaPlayer.create(this,R.raw.incerrect_answer);
            netacan.start();
            builder.setMessage("Netačan odgovor. Tačan odgovor je: " + tacan)
                    .setTitle("Netačno");

            builder.setPositiveButton("U redu", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if(brPitanje<10) {
                        TextView txtPitanje = (findViewById(R.id.txtPitanje));
                        ImageView imgSlika = (findViewById(R.id.imgSlika));
                        Button butAnswer1 = (findViewById(R.id.butAnswer1));
                        Button butAnswer2 = (findViewById(R.id.butAnswer2));
                        Button butAnswer3 = (findViewById(R.id.butAnswer3));
                        Button butAnswer4 = (findViewById(R.id.butAnswer4));
                        int rnd = pitId[brPitanje];
                        txtPitanje.setText(pitanja[rnd][0]);
                        if (pitanja[rnd][1].equals("")) {
                            imgSlika.setImageResource(R.drawable.erlen);
                        } else {
                            imgSlika.setImageResource(Integer.parseInt(pitanja[rnd][1]));
                        }
                        butAnswer1.setText(pitanja[rnd][2]);
                        butAnswer2.setText(pitanja[rnd][3]);
                        butAnswer3.setText(pitanja[rnd][4]);
                        butAnswer4.setText(pitanja[rnd][5]);
                        corAns = pitanja[rnd][6];
                        brPitanje++;
                    }else{
                        Intent intent = new Intent(getApplicationContext(),gameend.class);
                        intent.putExtra("tacni",tacni);
                        startActivity(intent);
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
public int backpress=0;
    @Override
    public void onBackPressed() {
        backpress+=1;
        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();
        if(backpress>1)
        {
            super.onBackPressed();
        }
    }
}
