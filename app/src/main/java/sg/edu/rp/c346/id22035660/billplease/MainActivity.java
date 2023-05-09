package sg.edu.rp.c346.id22035660.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvAmount;
    EditText etAmount;
    TextView tvPax;
    EditText etPax;
    Button buttonSVS;
    Button buttonGST;
    TextView tvDisc;
    EditText etDisc;
    Button buttonSPLIT;
    Button buttonRESET;
    RadioGroup rgPayment;
    RadioButton radioButton1;
    RadioButton radioButton2;
    TextView tvBill;
    TextView tvPay;
    private int radioGrp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAmount = findViewById(R.id.textViewAmount);
        rgPayment = findViewById(radioGrp);
        etAmount = findViewById(R.id.editTextAmount);
        tvPax = findViewById(R.id.textViewPax);
        etPax = findViewById(R.id.editTextPax);
        buttonSVS = findViewById(R.id.btn1);
        buttonGST = findViewById(R.id.btn2);
        tvDisc = findViewById(R.id.textViewDisc);
        etDisc = findViewById(R.id.editTextDisc);
        buttonSPLIT = findViewById(R.id.btn3);
        buttonRESET = findViewById(R.id.btn4);
        radioButton1 =findViewById(R.id.radioButton1);
        radioButton2 =findViewById(R.id.radioButton2);
        tvBill =findViewById(R.id.textView);
        tvPay =findViewById(R.id.textView2);

        buttonSPLIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonSPLIT.getText().toString().trim().length()!=0 &&
                        tvPax.getText().toString().trim().length()!=0) {
                    double newAmount = 0.0;
                    if (!buttonSPLIT.isSelected() && !buttonGST.isSelected()) {
                        newAmount = Double.parseDouble(tvAmount.getText().toString());
                    } else if (buttonSVS.isSelected() && !buttonGST.isSelected()) {
                    }else if (!buttonSVS.isSelected() && buttonGST.isSelected()){
                            newAmount = Double.parseDouble(tvAmount.getText().toString()) * 1.07;
                            } else {
                                newAmount = Double.parseDouble(tvAmount.getText().toString()) * 1.17;
                            }

                            if (tvDisc.getText().toString().trim().length()!= 0) {
                                newAmount*= 1-Double.parseDouble(tvDisc.getText().toString())/100;
                            }
                            tvBill.setText("Total bill: $" + String.format("%.2f", newAmount));
                            int numberPerson = Integer.parseInt(tvPax.getText().toString());

                            //if (numberPerson!= 1)
                            tvPay.setText("Each Pays: $" + String.format("%.2f",newAmount/numberPerson));

                        }
                    }
                });
                buttonRESET.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvAmount.setText("");
                        tvPax.setText("");
                        buttonSVS.setClickable(false);
                        buttonGST.setClickable(false);
                        tvDisc.setText("");
                    }
                });
            }

}