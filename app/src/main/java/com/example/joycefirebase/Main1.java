package com.example.joycefirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main1 extends AppCompatActivity {
    private Button buttonSignIn;
    final String TAG = "FIRESTORE";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        EditText firstname = findViewById(R.id.FirstName);
        EditText lastname = findViewById(R.id.LastName);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);

        buttonSignIn = findViewById(R.id.buttonSignIn);
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fNameInput = firstname.getText().toString();
                String lNameInput = lastname.getText().toString();
                String emailInput = email.getText().toString();
                String passInput = password.getText().toString();

                if(!fNameInput.isEmpty() && !lNameInput.isEmpty() && !emailInput.isEmpty() && !passInput.isEmpty()){
                    addUser(fNameInput, lNameInput, emailInput, passInput);
                    Finish();
                } else{
                    Toast.makeText(Main1.this, "All fields required!"
                            , Toast.LENGTH_SHORT).show();
                }
            }
            public void addUser(String firstnameInput, String lastnameInput, String email, String password){
                // Create a new user with a first and last name
                Map<String, Object> user = new HashMap<>();
                user.put("firstname", firstnameInput);
                user.put("lastname", lastnameInput);
                user.put("email", email);
                user.put("password", password);

                // Add a new document with a generated ID
                db.collection("joyceDB").document(email)
                        .set(user)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + email);
                                Toast.makeText(Main1.this, "Successfully Added"
                                        , Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Main1.this, "Error adding document" + e
                                        , Toast.LENGTH_SHORT).show();
                                Log.w(TAG, "Error adding document", e);
                            }
                        });
            }
            public void Finish(){
                Intent intent = new Intent(getApplication(), Login.class);
                startActivity(intent);
                Toast.makeText(Main1.this, "Successfully Added"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}