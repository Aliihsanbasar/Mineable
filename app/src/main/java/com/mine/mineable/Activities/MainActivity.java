package com.mine.mineable.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mine.mineable.R;
import com.mine.mineable.data.ApiInterface;
import com.mine.mineable.data.ApiModule;
import com.mine.mineable.data.response.Coin;
import com.mine.mineable.data.response.CoinList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ApiInterface apiInterface;
    TextView firstPrice, firstCoin, firstCoinPrice;
    TextView secondPrice, secondCoin, secondCoinPrice;
    TextView thirdPrice, thirdCoin, thirdCoinPrice;
    TextView fourthPrice, fourthCoin, fourthCoinPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface= ApiModule.Client().create(ApiInterface.class);

        initComponents();

        Call<List<Coin>> call = apiInterface.getCoins("ETH,BTC,FTC,GLC");

        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {

                firstPrice.setText(String.format("%.5f", response.body().get(0).getPrice()));
                firstCoin.setText(response.body().get(0).getCoin() + " - " + response.body().get(0).getName());
                firstCoinPrice.setText(String.format("%.5f", response.body().get(0).getPrice()));

                secondPrice.setText(String.format("%.5f", response.body().get(1).getPrice()));
                secondCoin.setText(response.body().get(1).getCoin() + " - " + response.body().get(1).getName());
                secondCoinPrice.setText(String.format("%.5f", response.body().get(1).getPrice()));

                thirdPrice.setText(String.format("%.5f", response.body().get(2).getPrice()));
                thirdCoin.setText(response.body().get(2).getCoin() + " - " + response.body().get(2).getName());
                thirdCoinPrice.setText(String.format("%.5f", response.body().get(2).getPrice()));

                fourthPrice.setText(String.format("%.5f", response.body().get(3).getPrice()));
                fourthCoin.setText(response.body().get(3).getCoin() + " - " + response.body().get(3).getName());
                fourthCoinPrice.setText(String.format("%.5f", response.body().get(3).getPrice()));

            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initComponents() {
        firstPrice = findViewById(R.id.firstPrice);
        firstCoin = findViewById(R.id.firstCoin);
        firstCoinPrice = findViewById(R.id.firstCoinPrice);

        secondPrice = findViewById(R.id.secondPrice);
        secondCoin = findViewById(R.id.secondCoin);
        secondCoinPrice = findViewById(R.id.secondCoinPrice);

        thirdPrice = findViewById(R.id.thirdPrice);
        thirdCoin = findViewById(R.id.thirdCoin);
        thirdCoinPrice = findViewById(R.id.thirdCoinPrice);

        fourthPrice = findViewById(R.id.fourthPrice);
        fourthCoin = findViewById(R.id.fourthCoin);
        fourthCoinPrice = findViewById(R.id.fourthCoinPrice);
    }

    private String handlePrices(Double price){
        return String.valueOf(convert(BigDecimal.valueOf(price), 5));
    }

    private BigDecimal convert(BigDecimal number, int significant) {
        var beforeDecimal = number.precision() - number.scale();
        var movePoint = significant - beforeDecimal;
        return number
                .movePointRight(movePoint)
                .setScale(0, RoundingMode.DOWN)
                .movePointLeft(movePoint);
    }
}