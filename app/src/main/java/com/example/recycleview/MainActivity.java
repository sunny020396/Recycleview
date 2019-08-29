package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
 ArrayList<Pokemon> pokelst;
    private View recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokelst = new ArrayList<>();
        //String link = "https://api.myjson.com/bins/8aje7";
        String link = "https://next.json-generator.com/api/json/get/E14trR2lD";
        try {


            // progs.setVisibility(View.VISIBLE);
            String data = new Asycdata(MainActivity.this).execute(link).get();
            System.out.println("This is from Main Activity :"+data);


            JSONObject mainobj = new JSONObject(data);
            JSONArray pokearray = mainobj.getJSONArray("Pokemon");

            for (int i=0;i<pokearray.length();i++)
            {
                JSONObject child = pokearray.getJSONObject(i);

                String img = ((JSONObject) child).getString("image");
                String name = child.getString("name");
                String type = child.getString("type");
                String ability = child.getString("ability");
                String height = child.getString("height");
                String weight = child.getString("weight");
                String desc = child.getString("description");

                String keyname = child.toString();


                pokelst.add(new Pokemon(name,img,type,ability,height,weight,desc));

            }


            Recyadapter adapter = new Recyadapter(pokelst, getApplicationContext());
                initView();


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void initView()
    {

    }

}
