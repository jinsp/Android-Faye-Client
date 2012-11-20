package com.moneydesktop.finance.tablet.activity;

import com.moneydesktop.finance.BaseActivity;
import com.moneydesktop.finance.R;
import com.moneydesktop.finance.data.SyncEngine;
import com.moneydesktop.finance.model.EventMessage.SyncEvent;
import com.moneydesktop.finance.util.DialogUtils;
import com.moneydesktop.finance.views.CircleNavView;

import de.greenrobot.event.EventBus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DashboardTabletActivity extends BaseActivity {

	Button mTempButton, mLaunchNav;
	LinearLayout mContainer;
	CircleNavView mCircleNav;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.dashboard_view);
        
        mTempButton = (Button) findViewById(R.id.view_accounts_button);
        mLaunchNav = (Button) findViewById(R.id.view_nav_button);
        mContainer = (LinearLayout) findViewById(R.id.dashboard_container);
        mCircleNav = (CircleNavView) findViewById(R.id.tablet_nav);
        
        mLaunchNav.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {  
                mCircleNav.setVisibility(View.VISIBLE);
			}
		});
        
        mTempButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(DashboardTabletActivity.this, AccountTypesTabletActivity.class);
				
				startActivity(intent);
				finish();
			}
		});
        
        
        EventBus.getDefault().register(this);
        
        if (SyncEngine.sharedInstance().isSyncing()) {
        	DialogUtils.showProgress(this, "Syncing Data...");
        }
    }
	
	public void onEvent(SyncEvent event) {
		
		if (event.isFinished()) {
			DialogUtils.hideProgress();
		}
	}
	
}