package com.example.android.sunshine.utilities;

import android.content.Context;
import android.icu.text.BreakIterator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String mWeatherData[];

    public ForecastAdapter() {

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        int layoutIdForListWeather = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListWeather, parent, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        String weatherToday = mWeatherData[position];
        holder.mWeatherTextView.setText(weatherToday);
    }
    @Override
    public int getItemCount() {
        if (null == mWeatherData) return 0;
        return mWeatherData.length;
    }
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
    public static class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        public static TextView mWeatherTextView;
        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }


    }
}
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
//  Add a class file called ForecastAdapter
//  (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
//  (23) Create a private string array called mWeatherData
//  (47) Create the default constructor (we will pass in parameters in a later lesson)
//  (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
//  Extend RecyclerView.ViewHolder
// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
//  (18) Create a public final TextView variable called mWeatherTextView
//  (19) Create a constructor for this class that accepts a View as a parameter
//  (20) Call super(view) within the constructor for ForecastAdapterViewHolder
//  (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
// (24) Override onCreateViewHolder
//  (25) Within onCreateViewHolder, inflate the list item xml into a view
//  (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
// (27) Override onBindViewHolder
//  (28) Set the text of the TextView to the weather for this list item's position
//  (29) Override getItemCount
//  (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
//  (31) Create a setWeatherData method that saves the weatherData to mWeatherData
//  (32) After you save mWeatherData, call notifyDataSetChanged
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////