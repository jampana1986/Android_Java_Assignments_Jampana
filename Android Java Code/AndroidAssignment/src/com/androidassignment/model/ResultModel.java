package com.androidassignment.model;

public class ResultModel {
	public String mtd;
	public String ytd;
	
	public ResultModel(String arryRes, String arryRes2) {
        this.mtd = arryRes;
        this.ytd = arryRes2;
    }
	private String getMtd() {
		return mtd;
	}
	private void setMtd(String mtd) {
		this.mtd = mtd;
	}
	private String getYtd() {
		return ytd;
	}
	private void setYtd(String ytd) {
		this.ytd = ytd;
	}
}
