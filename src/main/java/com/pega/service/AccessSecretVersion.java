package com.pega.service;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;

import java.io.IOException;

public class AccessSecretVersion {

    public static String accessSecretVersion() throws IOException {
        // TODO(developer): Replace these variables before running the sample.
        String projectId = "prj-dev-whitewalkers-d01a";
        String secretId = "postgres";
        String versionId = "1";
        return accessSecretVersion(projectId, secretId, versionId);
    }

    // Access the payload for the given secret version if one exists. The version
    // can be a version number as a string (e.g. "5") or an alias (e.g. "latest").
    public static String accessSecretVersion(String projectId, String secretId, String versionId)
            throws IOException {
        // Initialize client that will be used to send requests. This client only needs to be created
        // once, and can be reused for multiple requests. After completing all of your requests, call
        // the "close" method on the client to safely clean up any remaining background resources.
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId, versionId);

            // Access the secret version.
            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);

            // Print the secret payload.
            //
            // WARNING: Do not print the secret in a production environment - this
            // snippet is showing how to access the secret material.
            String payload = response.getPayload().getData().toStringUtf8();
            System.out.printf("Plaintext: %s\n", payload);
            return payload;
        }
    }
}