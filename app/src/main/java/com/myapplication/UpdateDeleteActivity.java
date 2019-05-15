package com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Response;
import retrofit2.Retrofit;



import API.EmployeeApi;
import model.EmpolyeeCUD;
import model.Empolyees;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateDeleteActivity extends AppCompatActivity {
private  Button btnSearch,btnUpadate,btnDelete;
private EditText etEmpName,etEmpSalary,etEmpAge;
private EditText etEmpID;
    private final static String BASE_URL="http://dummy.restapiexample.com/api/v1/";
EmployeeApi employeeApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        btnSearch=findViewById(R.id.btnSearch);
        btnUpadate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        etEmpID=findViewById(R.id.etEmpID);
        etEmpName=findViewById(R.id.etEmpName);
        etEmpSalary=findViewById(R.id.etEmpSalary);
        etEmpAge=findViewById(R.id.etEmpAge);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadData();
            }
        });
        btnUpadate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmployee();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteEmployee();
            }
        });
    }
private void CreateInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        employeeApi = retrofit.create(EmployeeApi.class);
}

   private void loadData(){


        CreateInstance();
        Call<Empolyees>ListCall= employeeApi.getEmployeeById(Integer.parseInt(etEmpID.getText().toString()));
ListCall.enqueue(new Callback<Empolyees>() {
    @Override
    public void onResponse(Call<Empolyees> call, Response<Empolyees> response) {
        etEmpName.setText(response.body().getEmployee_name());
        etEmpSalary.setText(Float.toString(response.body().getEmployes_salary()));
        etEmpAge.setText(Integer.toString(response.body().getEmployee_age()));
    }

    @Override
    public void onFailure(Call<Empolyees> call, Throwable t) {
        Toast.makeText(UpdateDeleteActivity.this, "error", Toast.LENGTH_SHORT).show();
    }
});

   }

    private void updateEmployee(){
        CreateInstance();
        EmpolyeeCUD empolyee=new EmpolyeeCUD(
                etEmpName.getText().toString(),
                Float.parseFloat(etEmpSalary.getText().toString()),
                Integer.parseInt(etEmpAge.getText().toString())
        );
        Call<Void>voidCall=employeeApi.updateEmployee(Integer.parseInt(etEmpID.getText().toString()));
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateDeleteActivity.this, "Update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(UpdateDeleteActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void deleteEmployee(){
        CreateInstance();
        Call<Void>voidCall=employeeApi.deleteEmployee(Integer.parseInt(etEmpID.getText().toString()));

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(UpdateDeleteActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(UpdateDeleteActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
