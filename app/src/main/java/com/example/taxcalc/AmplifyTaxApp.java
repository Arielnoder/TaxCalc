package com.example.taxcalc;

import android.app.Application;
import android.util.Log;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;

public class AmplifyTaxApp extends Application {
    public void onCreate() {
        super.onCreate();

        try {
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
            Log.i("TaxApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("TaxApp", "Could not initialize Amplify", error);
        }
    }
}
