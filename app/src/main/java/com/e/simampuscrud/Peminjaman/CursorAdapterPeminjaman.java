package com.e.simampuscrud.Peminjaman;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.e.simampuscrud.DBHelper;
import com.e.simampuscrud.R;

public class CursorAdapterPeminjaman extends CursorAdapter {

    private LayoutInflater layoutInflater;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CursorAdapterPeminjaman(Context context, Cursor c, int flags) {
        super(context, c, flags);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.row_peminjaman, viewGroup, false);
        MyHolder holder = new MyHolder();
        holder.ListID = (TextView)v.findViewById(R.id.listID);
        holder.ListNamaMember = (TextView)v.findViewById(R.id.listNamaMember);
        holder.ListTanggal = (TextView)v.findViewById(R.id.listTanggal);
        holder.ListStatus = (TextView)v.findViewById(R.id.listStatus);
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CursorAdapterPeminjaman.MyHolder holder = (CursorAdapterPeminjaman.MyHolder)view.getTag();

        holder.ListID.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COLOUMN_ID)));
        holder.ListNamaMember.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COLOUMN_NAME)));
        holder.ListTanggal.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COLOUMN_TGL)));
        holder.ListStatus.setText(cursor.getString(cursor.getColumnIndex(DBHelper.COLOUMN_STATUS)));
    }

    class MyHolder{
        TextView ListID;
        TextView ListNamaMember;
        TextView ListTanggal;
        TextView ListStatus;
    }
}
