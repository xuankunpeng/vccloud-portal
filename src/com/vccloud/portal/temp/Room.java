package com.vccloud.portal.temp;

import java.util.List;

public class Room {

	private int roomID;
	private List<Integer> ignoreIDs;
	private boolean muteAudio;
	private boolean muteVideo;

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public List<Integer> getIgnoreIDs() {
		return ignoreIDs;
	}

	public void setIgnoreIDs(List<Integer> ignoreIDs) {
		this.ignoreIDs = ignoreIDs;
	}

	public boolean isMuteAudio() {
		return muteAudio;
	}

	public void setMuteAudio(boolean muteAudio) {
		this.muteAudio = muteAudio;
	}

	public boolean isMuteVideo() {
		return muteVideo;
	}

	public void setMuteVideo(boolean muteVideo) {
		this.muteVideo = muteVideo;
	}

}
