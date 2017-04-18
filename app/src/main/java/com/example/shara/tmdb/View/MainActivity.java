package com.example.shara.tmdb.View;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shara.tmdb.Model.Adapter.MovieAdapter;
import com.example.shara.tmdb.Model.POJO.Movies;
import com.example.shara.tmdb.Model.api.MovieApi;
import com.example.shara.tmdb.Model.api.RestApiManager;
import com.example.shara.tmdb.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MovieApi {

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Movies> mMovieList = new ArrayList<>();
    private MovieAdapter mFlowersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configToolbar();
      //  mController = new Controller(MainActivity.this);
      //  configViews();
      //  mController.startFetching();
    }

    private void configToolbar() {
        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

   /* private void configViews() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipe);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        mFlowersAdapter = new FlowersAdapter(mFlowerList);
        mRecyclerView.setAdapter(mFlowersAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mController.startFetching();
            }
        });

        //addFlowers();
    }

    private void addFlowers() {
        for(int i = 0; i  < 1000; i++) {

            Flower flower = new Flower.Builder()
                    .setName("Filippo")
                    .setPrice(15.2)
                    .setPhoto("AJHAJKS")
                    .build();

            mFlowersAdapter.addFlower(flower);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

 /*   @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Flower flower) {
        mFlowersAdapter.addFlower(flower);
    }

    @Override
    public void onFetchProgress(List<Flower> flowerList) {

    }

    @Override
    public void onFetchComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFetchFailed() {

    }*/
RestApiManager rm=new RestApiManager();
    MovieApi movieApi=rm.getMovieApi();

    Call<Movies> call= (Call<Movies>) movieApi.getMovies();
    call.enqueue(new Call<Movies>() {
        public void onResponse(Response<Movies> response, Retrofit retrofit) {

            try {

                text_id_1.setText("StudentId  :  " + response.body().getStudentId());
                text_name_1.setText("StudentName  :  " + response.body().getStudentName());
                text_marks_1.setText("StudentMarks  : " + response.body().getStudentMarks());

            } catch (Exception e) {
                Log.d("onResponse", "There is an error");
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(Throwable t) {
            Log.d("onFailure", t.toString());
        }
    }

    @Override
    public MovieApi getMovies() {
        return null;
    }

    );
}