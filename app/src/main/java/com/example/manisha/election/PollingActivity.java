package com.example.manisha.election;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.manisha.election.models.Polling;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PollingActivity extends AppCompatActivity {


    TextInputLayout epicNumber;
    private final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private PollingAdapter pollingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        epicNumber = (TextInputLayout) findViewById(R.id.textInputLayout) ;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        ApiUtil.getServiceClass().getPollingData().enqueue(new Callback<List<Polling>>() {

            @Override
            public void onResponse(Call<List<Polling>> call, Response<List<Polling>> response) {
                if(response.isSuccessful()){
                    loadList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Polling>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
            });

        }

        private void loadList(List<Polling> pollings)
        {
            pollingAdapter = new PollingAdapter(pollings);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PollingActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(pollingAdapter);
        }
}
