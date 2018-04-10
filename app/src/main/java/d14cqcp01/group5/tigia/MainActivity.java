package d14cqcp01.group5.tigia;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TIGIA = "TIGIA";
    private EditText edtVang, edtVang24k, edtUSD;
    private Button btnSave;

    private DatabaseReference mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = FirebaseDatabase.getInstance().getReference();
        addControls();
        addEvents();
    }


    private void addControls() {
        edtUSD = findViewById(R.id.edtUSD);
        edtVang = findViewById(R.id.edtVang);
        edtVang24k = findViewById(R.id.edtVang24K);
        btnSave = findViewById(R.id.btnSave);
    }

    private void addEvents() {

        edtVang.setText("0.0");
        edtVang24k.setText("0.0");
        edtUSD.setText("0.0");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float giaVang9999 = Float.parseFloat(edtVang.getText().toString());
                Float giaVang24k = Float.parseFloat(edtVang24k.getText().toString());
                Float giaUSD = Float.parseFloat(edtUSD.getText().toString());

                TiGia tiGia = new TiGia(giaVang9999,giaVang24k,giaUSD);

                mData.child(TIGIA).setValue(tiGia).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,"Cập nhật THÀNH CÔNG",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Cập nhật THẤT BẠI",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        mData.child(TIGIA).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TiGia tiGia = dataSnapshot.getValue(TiGia.class);
                edtVang.setText(tiGia.getGiaVang9999().toString());
                edtVang24k.setText(tiGia.getGiaVang24k().toString());
                edtUSD.setText(tiGia.getGiaUSD().toString());
                Toast.makeText(MainActivity.this,"Dữ liệu đã cập nhật",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
