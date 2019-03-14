package com.prvaci.danmola;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
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
            {"Formula molekula vodonika je:","","H","H2","O2","2H","2"},
            {"Formula ozona je:","","O2","3O","F3","O3","4"},
            {"Binarna jedinjenja kiseonika nazivaju se:","","hidridi","oksidi","sulfidi","halogeni","2"},
            {"Neophodan reaktant svake reakcije sagorevanja je:","","kiseonik","ugljenik","sumpor","vodonik","1"},
            {"Sumpor gradi sledeći oksid:","","SO4","S2O5","SO2","S2O3","3"},
            {"Formula sumporne kiseline je:","","H2SO3","H3SO4","HSO3","H2SO4","4"},
            {"Koji od navedenih procesa ima veze sa primenom sumpora:","","centriranje trapa automobila","lakiranje","vulkanizacija gume","zavarivanje auspuha","3"},
            {"Koji se od sledecih nemetala nalazi u istoj grupi Periodnog sistemaelemenata sa sumporom:","","azot","kiseonik","hlor","ugljenik","2"},
            {"Odredi koja je od ponudjenih formula, formula nitritne kiseline:","","NH3","HNO2","HNO3","NO2","2"},
            {"","",";","","","","3"},
            {"","","","","","","2"},
            {"Izdvoj tačno tvrđenje:","","grafit i dijamant su jedinjenja ugljenika","Ugljenik(IV)-oksid je lakši od vazduha","Kristalna rešetka dijamanta sačinjena je od molekula ","Potpunim sagorevanjem ugljenika nastaje ukljen(II)-oksid","2"},
            {"Reakcijom CO2+H2O dobija se:","","HCO3","H2CO3","CH3OH","HCHO","3"},
            {"","","","","","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Pokojni Lenski tad je pao...","","Srećni Lenski tad je pao…","Nesrećni Lenski tad je pao...","4"},
            {"Koji od ponuđenih stihova je tačan?","","Od svega što je duši milo","Od svega što je duši gjilo","Od svega što je srcu milo","","3"},
            {"Koji od ponuđenih stihova je tačan?","","Srce sam tada ispunio;","","Srce sam tada otrgao;","Srce sam tada pokidao;","3"},
            {"Koji od ponuđenih stihova je tačan?","","Neometan ničim, ja sam zatim","Nevezan ničim, ja sam zatim","Nesprečiv ničim, ja sam zatim","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Mislio da sloboda može","Mislio da sreća može","Mislio da samoća može","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Da nadoknadi ljubav: Bože!","Da nadoknadi sreću: Bože!","Da nadoknadi tugu: Bože!","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Kako pogreših, kako patim!","Kako pogreših, kako smeh?","Kako pogreših, kako sam glup!","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Ne, da vas gledam, da vas volim.","Ne, da vas vidim, da vas špijuniram.","","Ne, da vas vidjam, da vas pratim.","4"},
            {"Koji od ponuđenih stihova je tačan?","","Da svaki pokret, pogled hvatam","","Da svaki osmeh, pogled hvatam","Da svaki treptaj, pogled hvatam","3"},
            {"Koji od ponuđenih stihova je tačan?","","Na vašem licu i da tugujem,","Na vašem licu i da patim,","Na vašim očima i da patim","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Vaš glas da slušam i da shvatim","Vaš pogled da posmatram i da shvatim","Vaše oči da gledam i da shvatim","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Svom dušom svojom vaše čari","Svim srcem svojim vaše čari","Svim srcem svojim vaše darove","","1"},
            {"Koji od ponuđenih stihova je tačan?","","I savršenstva od svih veća.","I beskrajnosti od svih veća.","I lepote od svih veća.","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Da predahnem kraj vas ustvari,","Da premirem kraj vas u stvari,","Da uživam kraj vas u stvari,","","2"},
            {"Koji od ponuđenih stihova je tačan?","","I da vas ljubim... to je sreća!","I da se gasiram… to je sreća!","","I da se gasim... to je sreća!","4"},
            {"Koji od ponuđenih stihova je tačan?","","A ja sam lišen slobode;","A ja sam olešen od svega toga;","","A ja sam lišen svega toga;","4"},
            {"Koji od ponuđenih stihova je tačan?","","Zbog vas moje srce luta svetom grubim;","","Zbog vas ja lutam svetom grubim;","Zbog vas ja letim svetom dobrodušnim;","3"},
            {"Koji od ponuđenih stihova je tačan?","","Svaki je dan života moga","Svaki je čas života moga","Svaki je sekund života moga","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Večan, a ja zalud gubim","Dragocen, a ja zalud gubim","Mio, a ja zalud gubim","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Već ionako teške dane","Već ionako teške sate","Vec ionako lake dane","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Sudbinom teškom odbrojane.","Sudbinom slatkom odbrojane.","","Sudbinom gorkom odbrojane.","4"},
            {"Koji od ponuđenih stihova je tačan?","","Moj život će skoro da se skrati;","Moja kosa će skoro da se skrati;","Moj vek će skoro da se skrati;","","3"},
            {"Koji od ponuđenih stihova je tačan?","","Al' da bih bio živ, u svesti,","Al' da bih preživeo, u svesti,","Al’ da bih bio mrtav, u svesti,","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Ja svakog dana moram znati","Ja svakog jutra moram znati","Ja svake noći moram znati","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Da ću vas ikada sresti...","Da cu vas tokom sna sresti...","","Da ću vas tokom dana sresti...","4"},
            {"Koji od ponuđenih stihova je tačan?","","Bojim se da se plašim","Razmišljam se da li se plaše","","Bojim se da se plaše","4"},
            {"Koji od ponuđenih stihova je tačan?","","Od moje molbe duša vaša","Od moje molbe oči vaše","Od moje molbe usne vaše","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Ko od planova koje kujem...","Ko od savršenstva koje kujem...","","Ko od lukavstva koje kujem...","4"},
            {"Koji od ponuđenih stihova je tačan?","","I gnevni prekor ja već osećam.","I gnevni prekor ja vec vidim.","I gnevni prekor ja već čujem.","","3"},
            {"Koji od ponuđenih stihova je tačan?","","Da znate kako čudno boli","Da znate kako strašno boli","Da znate kako uopšte ne boli","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Ljubavnom žeđi biti moren,","Duševnom žeđi biti moren","Mučeničkom žeđi biti moren,","","1"},
            {"Koji od ponuđenih stihova je tačan?","","U mojoj duši koja voli","U mom srcu koje voli","U mom mozgu koji mrzi","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Gušiti nemir ljubavlju stvoren!","","Gušiti nemir strašću stvoren!","Gušiti svemir strašću stvoren!","3"},
            {"Koji od ponuđenih stihova je tačan?","","Ja žudim da kraj vaših grudi","Ja žudim da kraj vaših nogu","Ja žudim da kraj vaših cipela","","2"},
            {"Koji od ponuđenih stihova je tačan?","","Sa suzama i bolom slijem","Sa poljupcima i zagrljajima slijem","Sa osmehom i bolom slijem","","1"},
            {"Koji od ponuđenih stihova je tačan?","","Svu ljubav, molbe, sve što osećam;","Svu ljubav, molbe, sve što krijem;","Svu mržnju, kritike, sve što krijem;","","2"},
            {"Koji od ponuđenih stihova je tačan?","","I sve što još izreći mogu!","I sve što još osetiti mogu!","I sve sto još pokazati mogu!","","1"},
            {"Koji od ponuđenih stihova je tačan?","","A mesto tog, hladnoćom lažnom","A mesto tog, toplotom lažnom","A mesto tog, toplinom savršenom","","1"},
            {"Koji od ponuđenih stihova je tačan?","","I reč i pogled ja krijem.","","I reč i pogled ja oružam.","I pokret i osmeh ja oružam.","3"},
                    {"Koji od ponuđenih stihova je tačan?","","Govorim s vama o nesrećnom","","Govorim s vama o nevažnom","Govorim s vama o svemu važnom","3"},
                    {"Koji od ponuđenih stihova je tačan?","","I veseo vam dodir pružam!...","I veseo vam osmeh pružam!...","I veseo vam prsten pružam!...","","2"},
                    {"Koji od ponuđenih stihova je tačan?","","Da protivim vama, strasti,","Da obožavam sebe, strast,","","Da protivim sebi, strasti,","4"},
                    {"Koji od ponuđenih stihova je tačan?","","Više u moći nije vašoj.","Više u moći nije mojoj.","Više u noći nije mojoj.","","3"},
                    {"Koji od ponuđenih stihova je tačan?","","Reših: u vašoj ja sam vlasti","Reših: u mojoj vi ste vlasti","Reših: ja sam vaš vlasnik","","1"},
                    {"Koji od ponuđenih stihova je tačan?","","I predajem se sudbini božjoj.","I predajem se sudbi svojoj.","I predajem se sudbi da me uništi.","","2"}};

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

    @Override
    public void onBackPressed() {
        //Nothing
    }
}
