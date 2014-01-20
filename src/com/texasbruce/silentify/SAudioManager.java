package com.texasbruce.silentify;

import android.content.Context;
import android.media.AudioManager;

public class SAudioManager {
	private Context ctx;
	private AudioManager am;

	public SAudioManager(Context ctx) {
		super();
		this.ctx = ctx;
		this.am = (AudioManager)ctx.getSystemService(Context.AUDIO_SERVICE);
	}
	
	public boolean isSilent(){
		return am.getRingerMode() == AudioManager.RINGER_MODE_SILENT;
	}
	
	public void setSilent(){
		am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
	}

}
