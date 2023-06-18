package com.example.areas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner sp_shapes = findViewById(R.id.spinner);
        final EditText et_rectangle_width = findViewById(R.id.et_rectangle_width);
        final EditText et_rectangle_height = findViewById(R.id.et_rectangle_height);
        final EditText et_triangle_base = findViewById(R.id.et_triangle_base);
        final EditText et_triangle_height = findViewById(R.id.et_triangle_height);
        final EditText circle_radius = findViewById(R.id.et_circle_radius);
        final Button calculate_button = findViewById(R.id.btn_areas_calculate);
        final TextView tv_result = findViewById(R.id.tv_result);
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(2));
        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              switch (i)
              {
                  case 0:
                      // Rectangle
                      et_rectangle_height.setVisibility(View.VISIBLE);
                      et_rectangle_width.setVisibility(View.VISIBLE);
                      et_triangle_base.setVisibility(View.GONE);
                      et_triangle_height.setVisibility(View.GONE);
                      circle_radius.setVisibility(View.GONE);
                      break;
                  case 1:
                      // Circle
                      et_rectangle_height.setVisibility(View.GONE);
                      et_rectangle_width.setVisibility(View.GONE);
                      et_triangle_base.setVisibility(View.GONE);
                      et_triangle_height.setVisibility(View.GONE);
                      circle_radius.setVisibility(View.VISIBLE);
                      break;
                  case 2:
                      // Triangle
                      et_rectangle_height.setVisibility(View.GONE);
                      et_rectangle_width.setVisibility(View.GONE);
                      et_triangle_base.setVisibility(View.VISIBLE);
                      et_triangle_height.setVisibility(View.VISIBLE);
                      circle_radius.setVisibility(View.GONE);
                      break;
              }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        calculate_button.setOnClickListener((View view) -> {
          int index = sp_shapes.getSelectedItemPosition();
          double area = 0;
            switch (index)
            {
                case 0:
                    double rectangle_height = Double.parseDouble(et_rectangle_height.getText().toString());
                    double rectangle_width = Double.parseDouble(et_rectangle_width.getText().toString());
                    area = rectangle_height * rectangle_width;
                    break;
                case 1:
                    // Circle
                    double radius = Double.parseDouble(circle_radius.getText().toString());
                    area = Math.PI * Math.pow(radius,2);
                    break;
                case 2:
                    // Triangle
                    double triangle_height = Double.parseDouble(et_triangle_height.getText().toString());
                    double triangle_base = Double.parseDouble(et_triangle_base.getText().toString());
                    area = 0.5 * triangle_base * triangle_height;
                    break;
            }
              String formatedNumber = decimalFormat.format(area);
              tv_result.setText(formatedNumber);

        });

    }
}