package com.example.taxcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.AmplifyModelProvider;
import com.amplifyframework.datastore.generated.model.Tax;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tax item = Tax.builder()
                .federal(2.5)
                .state(2.5)
                .total(2.5)
                .build();
        Amplify.DataStore.save(item,
                success -> Log.i("TaxApp", "TotalIncome: " + success.item().getTotal()),
                error -> Log.e("TaxApp", "Could not save item to DataStore", error)
        );

        Amplify.DataStore.query(Tax.class,
                Taxes -> {
                    while (Taxes.hasNext()) {
                        Tax Tax = Taxes.next();

                        Log.i("TaxApp", "==== Tax ====");
                        if(Tax.getFederal() != null) {
                            Log.i("TaxApp", "Federal: " + Tax.getFederal());
                        }
                        if (Tax.getState() != null) {
                            Log.i("TaxApp", "State: " + Tax.getState());
                        }

                        if (Tax.getTotal() != null) {
                            Log.i("TaxApp", "Total: " + Tax.getTotal());
                        }
                    }
                },
                failure -> Log.e("TaxApp", "Could not query DataStore", failure)
        );


    }



}