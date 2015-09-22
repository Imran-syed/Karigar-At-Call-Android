package in.karigaronccall.karigaroncall;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import in.karigaronccall.karigaroncall.models.WorkType;

public class WorkTypeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_type_list);

        ListView workTypeListView = (ListView) findViewById(R.id.workTypeListView);
        workTypeListView.setAdapter(new WorkListAdapter(new WorkTypeDetailsProvider().getPopulatedList()));
    }

    private class WorkTypeDetailsProvider {
        List<WorkType> list = new ArrayList<>();

        public List<WorkType> getPopulatedList() {
            list.add(new WorkType(R.drawable.ic_pause_light, getResources().getString(R.string.worktype_title_0),
                    getResources().getString(R.string.worktype_desc_0)));
            list.add(new WorkType(R.drawable.ic_pause_light, getResources().getString(R.string.worktype_title_1),
                    getResources().getString(R.string.worktype_desc_0)));
            list.add(new WorkType(R.drawable.ic_pause_light, getResources().getString(R.string.worktype_title_2),
                    getResources().getString(R.string.worktype_desc_0)));
            return list;
        }
    }

    private class WorkListAdapter extends ArrayAdapter<WorkType> {
        List<WorkType> list;

        public WorkListAdapter(List<WorkType> list) {
            super(WorkTypeListActivity.this, R.layout.worktype_list_item, list);
            this.list = list;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.worktype_list_item, parent, false);
            }
            WorkType workType = list.get(position);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_work_type_list_icon);
            imageView.setImageResource(workType.getIconID());

            TextView itemHead = (TextView) itemView.findViewById(R.id.item_work_type_list_head);
            itemHead.setText(workType.getWorkType());

            TextView itemDesc = (TextView) itemView.findViewById(R.id.item_work_type_list_desc);
            itemDesc.setText(workType.getDesc());

            return itemView;
        }
    }


}
