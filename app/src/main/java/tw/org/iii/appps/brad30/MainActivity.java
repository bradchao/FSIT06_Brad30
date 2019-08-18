package tw.org.iii.appps.brad30;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private TextView birthday;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.rootView);
        birthday = findViewById(R.id.birthday);
    }

    public void selectDate(View view) {
        DatePickerDialog dialog = new DatePickerDialog(this,
                DatePickerDialog.THEME_DEVICE_DEFAULT_DARK,null,2019,7,7);
        dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                birthday.setText(year + "/" + month + "/" + day);
            }
        });

        DatePicker picker = dialog.getDatePicker();

        Calendar limit = Calendar.getInstance();
        limit.set(2019,8,15);
        long limitDate = limit.getTimeInMillis();
        picker.setMaxDate(limitDate);

        dialog.show();
    }


    public void test1(View view) {
        Toast toast = Toast.makeText(this, "Hello, World", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.FILL_HORIZONTAL+Gravity.CENTER_VERTICAL,
                0, 100);
        //toast.show();

        showMyToast("Hello, World");
    }

    private void showMyToast(String mesg){
        LayoutInflater inflater =  getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_view, null);

        TextView txtMesg = view.findViewById(R.id.toast_mesg);
        txtMesg.setText(mesg);

        Toast toast = new Toast(this);
        toast.setGravity(Gravity.FILL_HORIZONTAL+Gravity.CENTER_VERTICAL,
                0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();

        
    }

    public void test2(View view) {
        Snackbar.make(rootView,
                "Hello, World",Snackbar.LENGTH_LONG).show();
    }
}
