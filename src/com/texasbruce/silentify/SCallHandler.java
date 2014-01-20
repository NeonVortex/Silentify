package com.texasbruce.silentify;

import android.content.Context;
import android.os.Vibrator;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class SCallHandler extends PhoneStateListener{
	Context ctx = null;
	Vibrator vib = null;
	
	public SCallHandler(Context ctx, Vibrator vib) {
		super();
		this.ctx = ctx;
		this.vib = vib;
	}

	@Override
	public void onCallStateChanged(int state, String num) {
		if (this.ctx != null) {
			if(this.vib == null) {
				vib = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);
			}
			
			switch(state) {
			case TelephonyManager.CALL_STATE_RINGING:
				vib.vibrate(new long[]{0,500,1000}, 0);
				break;
			default:
				vib.cancel();
				break;
			}
		}
	}
}
