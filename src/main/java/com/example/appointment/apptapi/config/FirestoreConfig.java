package com.example.appointment.apptapi.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

@Configuration
public class FirestoreConfig {

    private static final Log logger = LogFactory.getLog(FirestoreConfig.class);

    private Firestore db;

    /**
     * Get connection to Firestore managed instance database
     */
    @Bean
    public Firestore getConnection() {
        logger.info("getFirestoreConnection() - start.");

        GoogleCredentials credentials = null;
        try {
            credentials = GoogleCredentials.getApplicationDefault();
        } catch (IOException e) {
            logger.error("getFirestoreConnection()", e);
        }

        String project_id = System.getenv("PROJECT_ID");

        if (null == project_id || "" == project_id) {
            project_id = "gcp-scvlab-s-l-mgsand-tsai";
        }

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .setProjectId(project_id)
                .build();
        initializeApp(options);
        db = FirestoreClient.getFirestore();
        logger.info("getFirestoreConnection() - end.");

        return this.db;
    }

    /**
     * Returns the default app for Firebase and will initialize it if it hasn't
     * already been established.
     * 
     * @param options options for initializing the app
     * @return the Firebase default app
     */
    private FirebaseApp initializeApp(FirebaseOptions options) {
        try {
            return FirebaseApp.getInstance(FirebaseApp.DEFAULT_APP_NAME);
        } catch (IllegalStateException e) {
            logger.info("Initializing the Firebase App");
            FirebaseApp.initializeApp(options);
            return FirebaseApp.getInstance(FirebaseApp.DEFAULT_APP_NAME);
        }

    }

    /**
     * Get the Project Id from GCP metadata server
     *
     * @return GCP Project Id or null
     */
    public String getProjectId() {
        String methodName = "getProjectId() - ";
        logger.debug(methodName + " start");
        OkHttpClient ok = new OkHttpClient.Builder()
                .readTimeout(500, TimeUnit.MILLISECONDS)
                .writeTimeout(500, TimeUnit.MILLISECONDS)
                .build();

        String metadataUrl = "http://metadata.google.internal/computeMetadata/v1/project/project-id";
        Request request = new Request.Builder().url(metadataUrl).addHeader("Metadata-Flavor", "Google").get().build();

        String project = null;
        try {
            Response response = ok.newCall(request).execute();
            logger.debug(methodName + response.body());
            project = response.body().string();
        } catch (IOException e) {
            logger.error("Error retrieving Project Id" + e.getMessage());
        }
        logger.debug(methodName + "project id " + project);
        logger.debug(methodName + " end");
        return project;
    }
}
