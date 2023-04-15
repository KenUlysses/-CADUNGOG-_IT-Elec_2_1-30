package com.example.myapplication2.ui.notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication2.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private TextView textview;
    private IntentFilter intentfilter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textview = binding.textNotifications;

        final Button checkStatus = binding.buttonCheck;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textview::setText);

        intentfilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        checkStatus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                getActivity().registerReceiver(broadcastReceiver, intentfilter);

            }
        });
        return root;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           int deviceHealth = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_COLD){
                textview.setText("currentBatteryHealth" +" = Cold");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_DEAD)
            {
                textview.setText("currentBatteryHealth" +" = Dead");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_GOOD)
            {
                textview.setText("currentBatteryHealth" +" = Good");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_OVERHEAT)
            {
                textview.setText("currentBatteryHealth" +" = Overheat");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE)
            {
                textview.setText("currentBatteryHealth" +" = Over voltage");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_UNKNOWN)
            {
                textview.setText("currentBatteryHealth" +" = Unknown");
            }

            if(deviceHealth == BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE)
            {
                textview.setText("currentBatteryHealth" +" = Unspecified Failure");
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}