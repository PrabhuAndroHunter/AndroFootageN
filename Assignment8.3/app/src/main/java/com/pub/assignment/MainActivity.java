package com.pub.assignment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Item> gridArray = new ArrayList<Item>();
    MyGridViewAdapter customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < MyData.drawableArray.length; i++) {
            Bitmap image = BitmapFactory.decodeResource(this.getResources(), MyData.drawableArray[i]);
            gridArray.add(new Item(image, MyData.nameArray[i]));
        }

         /*  Instantiation of UI Components */
        gridView = (GridView) findViewById(R.id.gridView1);

         /*  create object of adapter class and set adapter to listview */
        customGridAdapter = new MyGridViewAdapter(this, R.layout.row_grid, gridArray);
        gridView.setAdapter(customGridAdapter);
         /*  Set click Listener to gridview and handle click event */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getBaseContext(), "Hi Bro am " + MyData.nameArray[position], Toast.LENGTH_LONG).show();
            }
        });
    }

}
