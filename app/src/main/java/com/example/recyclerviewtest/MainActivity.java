package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerView2, recyclerView3;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> adlistData = new ArrayList<Data>();
    private List<Data> sehirlistData = new ArrayList<Data>();
    private List<Data> sonlistData = new ArrayList<Data>();
    private TextView adlar,sehirler;
    private Button adButton, sehirButton,sonButton;
    private String[] adDizisi= new String[50];
    private String[] sehirDizisi=new String[50];
    private int number,adSayac=0, sehirSayac=0;
    private Random random=new Random();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adlar=findViewById(R.id.editText);
        sehirler = findViewById(R.id.editText2);
        adButton=findViewById(R.id.adButton);
        sehirButton= findViewById(R.id.button2);
        sonButton = findViewById(R.id.button3);

      adButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              System.out.println("tıklandı");
              String ad= adlar.getText().toString();
              if(ad.equals(" ") || ad.equals(""))
              {
                  System.out.println("Boş Bırakmayınız");
              }
              else {
                  adlistData.add(new Data(ad));
                  adDizisi[adSayac] = ad;
                  adSayac++;
              }
              recyclerView = findViewById(R.id.recycler1);
              recyclerView.setHasFixedSize(true);
              layoutManager = new LinearLayoutManager(getApplicationContext());
              ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
              recyclerView.setLayoutManager(layoutManager);
              recyclerView.setLayoutManager(layoutManager);
              adapter = new RecyclerViewAdapter(adlistData);
              recyclerView.setAdapter(adapter);
          }
      });
      sehirButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              System.out.println("tıklandı");
              String sehir= sehirler.getText().toString();
              if(sehir.equals(" ") || sehir.equals(""))
              {
                  System.out.println("boş bırakmayınız");
              }
              else {
                  sehirlistData.add(new Data(sehir));
                  sehirDizisi[sehirSayac] = sehir;
                  sehirSayac++;
              }
              recyclerView2 = findViewById(R.id.recycler2);
              recyclerView2.setHasFixedSize(true);
              layoutManager = new LinearLayoutManager(getApplicationContext());
              ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
              recyclerView2.setLayoutManager(layoutManager);
              adapter = new RecyclerViewAdapter(sehirlistData);
              recyclerView2.setAdapter(adapter);
             }
      });
       // sehirButton.setOnLongClickListener();

        sonButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int sayac=0,ilerle=0;
              for(int j=0;j<adlistData.size();j++)
              {
                  int rand=(int)(Math.random()*adlistData.size());
                  String temp=adDizisi[j];
                  adDizisi[j]=adDizisi[rand];
                  adDizisi[rand]=temp;
              }
             for(int j=0;j<sehirlistData.size();j++)
              {
                  int rand=(int)(Math.random()*sehirlistData.size());
                  String temp=sehirDizisi[j];
                  sehirDizisi[j]=sehirDizisi[rand];
                  sehirDizisi[rand]=temp;
              }
              // 10 a 5 ise-------------------------------------------------------------------------
              int kackez=adlistData.size()/sehirlistData.size();
             if(adlistData.size()>sehirlistData.size()) {
                 if (adlistData.size() % sehirlistData.size() == 0)
                 //if(adlistData.size()==10 && sehirlistData.size()==5)
                 {
                     for (int i = 0; i < sehirlistData.size(); i++) {
                         sonlistData.add(sehirlistData.get(i)); // recycler'a sehir ekleme satırı
                         while (sayac != kackez) {
                             sonlistData.add(new Data(adDizisi[ilerle]));
                             sayac++;
                             ilerle++;
                         }
                         sayac = 0;
                         System.out.println(number);
                     }
                 }
            // 11 e 5 örneği ---------------------------------------
                 else if (adlistData.size() % sehirlistData.size() == 1 || (adlistData.size() / sehirlistData.size() >= 2 && adlistData.size() % sehirlistData.size() >= 2)) {
                     kackez = adlistData.size() / sehirlistData.size();
                     sayac = 0;
                     ilerle = 0;
                     for (int i = 0; i < sehirlistData.size(); i++) {
                         sonlistData.add(sehirlistData.get(i)); // recycler'a sehir ekleme satırı
                         while (sayac != kackez) {
                             sonlistData.add(new Data(adDizisi[ilerle]));
                             sayac++;
                             ilerle++;
                         }
                         sayac = 0;
                     }
                     int fark = adlistData.size() % sehirlistData.size();
                     ilerle = 0;
                     sayac = 0;
                         while (sayac != fark) {
                             System.out.println(sayac);
                             int rand = (int) (Math.random() * sehirlistData.size());
                             sonlistData.add(sehirlistData.get(rand));
                             sonlistData.add(new Data(adDizisi[ilerle]));
                             sayac++;
                             ilerle++;
                         }
                 }
                 // 10 isim 8 sehir örneği ------------------------------------
                 else if (adlistData.size() % sehirlistData.size() >= 2) {
                     for (int i = 0; i < sehirlistData.size(); i++) {
                         sonlistData.add(sehirlistData.get(i));
                         sonlistData.add(new Data(adDizisi[i]));
                     }
                     int fark=adlistData.size()-sehirlistData.size();
                     for (int k = 0; k < fark; k++)
                     {
                         int rand = (int) (Math.random() * sehirlistData.size());
                         sonlistData.add(sehirlistData.get(rand));
                         sonlistData.add(new Data(adDizisi[k]));
                     }
                     System.out.println(fark);
                 }
                 // 5 isim 10 sehir örneği --------------------------------
                 else {
                     System.out.println("Hatalı Giriş Yaptınız");
                 }
             }
              else if(adlistData.size()<sehirlistData.size())
              {
                  for(int i=0;i<adlistData.size();i++) {
                      sonlistData.add(sehirlistData.get(i)); // recycler'a sehir ekleme satırı
                      sonlistData.add(new Data(adDizisi[i]));
                  }
              }
              else{
                      System.out.println("hatalı giriş");
                  }
           recyclerView3 = findViewById(R.id.recycler3);
              recyclerView3.setHasFixedSize(true);
              layoutManager = new LinearLayoutManager(getApplicationContext());
              ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
              recyclerView3.setLayoutManager(layoutManager);
              adapter = new RecyclerViewAdapter(sonlistData);
              recyclerView3.setAdapter(adapter);
          }
      });
    }


}
