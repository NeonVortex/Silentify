package com.texasbruce.silentify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class SCallListener extends BroadcastReceiver{
	
	TelephonyManager telephony;
	Vibrator vib;
	SCallHandler callHandler;

	@Override
	public void onReceive(Context ctx, Intent arg1) {
		telephony = (TelephonyManager)ctx.getSystemService(Context.TELEPHONY_SERVICE);
		vib = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);
		callHandler = new SCallHandler(ctx, vib);
		
		if(telephony != null && vib != null) {
			telephony.listen(callHandler, PhoneStateListener.LISTEN_CALL_STATE);
		}
	}
	

}
