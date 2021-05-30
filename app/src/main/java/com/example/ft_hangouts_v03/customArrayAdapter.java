package com.example.ft_hangouts_v03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class customArrayAdapter extends ArrayAdapter<Contact> implements View.OnClickListener {

   private ArrayList<Contact> contactList;
   Context ctxt;

    @Override
    public void onClick(View v) {
    }

    class ViewHolder {
        TextView txtFirstName;
    }

    public customArrayAdapter(ArrayList<Contact> data, Context context) {
        super(context, R.layout.item_user, data);
        this.contactList = data;
        this.ctxt = context;

    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        Contact contact = getItem(pos);
        ViewHolder viewHolder;
        final View res;
        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder.txtFirstName = (TextView) convertView.findViewById(R.id.textFirstName);
            res = convertView;
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
            res = convertView;
        }
        viewHolder.txtFirstName.setText(contact.getFirstName());
        return convertView;
    }
}
