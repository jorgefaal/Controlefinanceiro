package senac.controlefinanceiro;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentLabelListListener {

    private RapidFloatingActionLayout rfaLayout;
    private RapidFloatingActionButton rfaBtn;
    private RapidFloatingActionHelper rfabHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            rfaLayout = findViewById(R.id.activity_main_rfal);
            rfaBtn = findViewById(R.id.activity_main_rfab);

            RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(getApplicationContext());
            rfaContent.setOnRapidFloatingActionContentLabelListListener(this);
            List<RFACLabelItem> items = new ArrayList<>();
            items.add(new RFACLabelItem<Integer>()
                    .setLabel("Adicionar Despesa")
                    .setResId(R.drawable.ic_despesa)
                    .setIconNormalColor(Color.RED)
                    .setIconPressedColor(Color.GRAY)
                    .setWrapper(0)
            );
            items.add(new RFACLabelItem<Integer>()
                    .setLabel("Adicionar Receita")
                    .setResId(R.mipmap.ic_launcher)
                    .setIconNormalColor(Color.WHITE)
                    .setIconPressedColor(Color.GRAY)
                    .setWrapper(1)
            );
          /* items.add(new RFACLabelItem<Integer>()
                    .setLabel("WangJie")
                    .setResId(R.mipmap.ic_launcher)
                    .setIconNormalColor(0xff056f00)
                    .setIconPressedColor(0xff0d5302)
                    .setLabelColor(0xff056f00)
                    .setWrapper(2)
            );
            items.add(new RFACLabelItem<Integer>()
                    .setLabel("Compose")
                    .setResId(R.mipmap.ic_launcher)
                    .setIconNormalColor(0xff283593)
                    .setIconPressedColor(0xff1a237e)
                    .setLabelColor(0xff283593)
                    .setWrapper(3)
            );*/
            rfaContent
                    .setItems(items)
                    .setIconShadowColor(0xff888888)
            ;

            rfabHelper = new RapidFloatingActionHelper(
                    getApplicationContext(),
                    rfaLayout,
                    rfaBtn,
                    rfaContent
            ).build();

        } catch (Exception e) {
            Log.e("main", "onCreate: " + e.getMessage());
        }
    }


    private void chamarAtividade(int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, DespesasActivity.class));
                break;
            case 1:
                // startActivity(new Intent(this, ReceitaActivity));

                break;
        }
        rfabHelper.toggleContent();
    }

    @Override
    public void onRFACItemLabelClick(int position, RFACLabelItem item) {
        // Toast.makeText(getApplicationContext(), "clicked label: " + position, Toast.LENGTH_SHORT).show();
        chamarAtividade(position);

    }

    @Override
    public void onRFACItemIconClick(int position, RFACLabelItem item) {
        //Toast.makeText(getApplicationContext(), "clicked icon: " + position, Toast.LENGTH_SHORT).show();

        chamarAtividade(position);

    }
}
