package com.example.app_banhangtructuyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Filter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.app_banhangtructuyen.R;
import com.example.app_banhangtructuyen.model.Product;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductSearchAdapter extends ArrayAdapter<Product> {

    private DecimalFormat formatPrice = new DecimalFormat("###,###,###");
    private List<Product> listSearchProduct;

    public ProductSearchAdapter(@NonNull Context context, int resource, @NonNull List<Product> objects) {
        super(context, resource, objects);
        listSearchProduct= new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_search, parent, false);

        // Lấy dữ liệu sản phẩm tại vị trí position
        Product product = getItem(position);

        // Thiết lập dữ liệu sản phẩm lên view
        TextView productName = convertView.findViewById(R.id.txttensp);
        productName.setText(product.getTenSP());

        ImageView productImage = convertView.findViewById(R.id.imgsp);
        Glide.with(getContext()).load(product.getHinhanh()).into(productImage);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        TextView productPrice = convertView.findViewById(R.id.txtgiasp);
        productPrice.setText(decimalFormat.format(product.getDongia())+" đ");

        return convertView;
    }

    @NonNull
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Product> listSuggest = new ArrayList<>();

                if (constraint == null || constraint.length() == 0){
                    listSuggest.addAll(listSearchProduct);
                }
                else {
                    String filter = constraint.toString().toLowerCase().trim();
                    for (Product p : listSearchProduct){
                        if (p.getTenSP().toLowerCase().contains(filter)){
                            listSuggest.add(p);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listSuggest;
                filterResults.count = listSuggest.size();

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                addAll( (List<Product>) results.values);
                notifyDataSetInvalidated();
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ( (Product) resultValue).getTenSP();
            }
        };
    }
}

