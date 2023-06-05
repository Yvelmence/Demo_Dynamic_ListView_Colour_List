package sg.edu.rp.c346.id22021958.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement, etIndex;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;

    ArrayAdapter<String> adapter;
    ArrayList<String> alColours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndex = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(adapter);

        //Add colour
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
                int index = Integer.parseInt(etIndex.getText().toString());

                alColours.add(index, newColor);

                adapter.notifyDataSetChanged();
                etElement.setText("");
                etIndex.setText("");
            }
        });

        //Remove colour
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(etIndex.getText().toString());

                alColours.remove(index);

                adapter.notifyDataSetChanged();
                etElement.setText("");
                etIndex.setText("");
            }
        });

        //Update colour
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
                int index = Integer.parseInt(etIndex.getText().toString());

                alColours.set(index, newColor);

                adapter.notifyDataSetChanged();
                etElement.setText("");
                etIndex.setText("");
            }
        });

        //Toast
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedColour = alColours.get(position);

                Toast.makeText(MainActivity.this, clickedColour, Toast.LENGTH_SHORT).show();
            }
        });
    }
}