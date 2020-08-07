package com.am.mynetbaased;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    String jsonstr;
    ListView lv;

    MyListAdapter myListAdapter;
    //GridView gv;
    //Spinner sp;

    String[] maintitle ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };
  String[] maintitlew ={
            "Title 1","Title 2",
            "Title 3","Title 4",
            "Title 5",
    };

    String[] subtitlew ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5",
    };



    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);


        //gv=(GridView)findViewById(R.id.gridview); // in the ui delete the listview add add gridview
        //sp=(Spinner)findViewById(R.id.spinner);   // in the ui delete the listview add add spinner

        arrayList=new ArrayList<>();

        arrayList.add("dfsdf");

        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle, maintitlew, subtitlew);
        lv.setAdapter(adapter);

        //arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);

        //lv.setAdapter(arrayAdapter);


          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getdat(View view) {
       // url="http://api.openweathermap.org/data/2.5/weather?q="+editText.getText().toString()+"&appid=0db1eb436a0608ba0f8c89cbc66d4d9e";
        Babu b = new Babu ();
        b.execute();
        }

    private class Babu extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {

            Pa im = new Pa();

            jsonstr = im.procesurl("https://data.sfgov.org/resource/jjew-r69b.json");

           // JSONArray jarray = null;
            //try {
            //    jarray = new JSONArray(jsonstr);
            //} catch (JSONException e) {
             //   e.printStackTrace();
           // }
            JSONArray jarray = null;

            try {
                jarray = new JSONArray(jsonstr);
                for (int i = 0; i < jarray.length(); i++) {
                    JSONObject jobj = jarray.optJSONObject(i);
                    if (jobj != null) {
                        arrayList.add(jobj.getString("latitude"));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }



//            try {
//                // jsonString is a string variable that holds the JSON
//                JSONArray itemArray=new JSONArray(jsonstr);
//                for (int mi = 0; mi < 10; mi++) {
//                   itemArray.getInt(mi);
//                  ///  Log.e("json", i+"="+value);
//                    arrayList.add(itemArray.getInt(mi)+"");
//                }
//            } catch (JSONException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            try {
//
//                JSONObject jsonObject = new JSONObject(jsonstr);
//
//                JSONArray jsonArray = jsonObject.getJSONArray("");
//
//                for (int ib =0 ; ib<10;ib++){
//                    JSONObject onj8 = jsonArray.getJSONObject(ib);
//
//                    arrayList.add(onj8.getString("location"));
//
//                }
//
//                //jsonstr= onj8.getString("main") + "\n" +onj8.getString("description");
//
//            } catch (JSONException e) {
           //     e.printStackTrace();
         //   }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
      //      textView.setText(jsonstr);

            Collections.sort(arrayList, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.compareToIgnoreCase(s2);
                }
            });

            arrayAdapter=new ArrayAdapter<String>(MainActivity.this,R.layout.simple,arrayList);
           // lv.setAdapter(arrayAdapter);

        }
    }
}