//package demo.gpsservice;
//
//import android.app.Activity;
//import android.content.ContentValues;
//import android.content.Context;
//import android.support.v4.app.FragmentActivity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.PopupWindow;
//import android.widget.TextView;
//import com.squareup.picasso.Callback;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
///**
// * Created by Rohit on 10/31/2016.
// */
//public class Cart_listadpter extends BaseAdapter {
//
//    public ViewHolder holder;
//    private PopupWindow popWindow = null;
//    private View inflatedView;
//
//    public ArrayList<model_recycle> model;
//    Activity activity;
//    public model_recycle item;
//
//    public Cart_listadpter(Activity activity, ArrayList<model_recycle> arr_data) {
//        super();
//        this.model = model_recycle;
//        this.activity = activity;
//    }
//
//    @Override
//    public int getCount() {
//        return model.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return model.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    private class ViewHolder {
//        TextView price;
//        ImageView image_url;
//        TextView productname;
//        ImageView delete;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//
//        final LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.card_items, null);
//            holder = new ViewHolder();
//            holder.price = (TextView) convertView.findViewById(R.id.price);
//            holder.productname = (TextView) convertView.findViewById(R.id.title);
//            holder.image_url = (ImageView) convertView.findViewById(R.id.imageView);
//            holder.delete = (ImageView) convertView.findViewById(R.id.delete);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        item = model.get(position);
//        holder.price.setText(item.getPrice());
//        holder.productname.setText(item.getProduct());
//        //-----------------------image view------------------------------
//        Picasso.with(activity)
//                .load(item.getProduct_url())
//                .fit()
//                .into(holder.image_url,new Callback() {
//                    @Override
//                    public void onError() {
//                        // TODO Auto-generated method stub
//                        //holder.thumbnail.setVisibility(View.GONE);
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        // TODO Auto-generated method stub
//                    }
//
//                });
//        //-----------------------delete button---------------------------
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //do something
//                model.remove(position);
//                datadelete(item.getProduct());
//                notifyDataSetChanged();
//
//            }
//        });
//        return convertView;
//    }
//
//    public  void datadelete(String product){
//
//
//    }
//
//}
