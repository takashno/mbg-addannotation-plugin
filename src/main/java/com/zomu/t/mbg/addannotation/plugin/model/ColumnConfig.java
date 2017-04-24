package com.zomu.t.mbg.addannotation.plugin.model;

/**
 * 
 * @author takashimanozomu
 *
 */
public class ColumnConfig {

	private String columnName;

	private boolean regexp = false;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public boolean isRegexp() {
		return regexp;
	}

	public void setRegexp(boolean regexp) {
		this.regexp = regexp;
	}

}
