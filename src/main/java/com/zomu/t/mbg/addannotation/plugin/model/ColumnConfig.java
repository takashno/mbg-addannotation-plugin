package com.zomu.t.mbg.addannotation.plugin.model;

/**
 * カラム名定義.
 * 
 * @author takashimanozomu
 *
 */
public class ColumnConfig {

	/** カラム名 */
	private String columnName;

	/** 正規表現 */
	private boolean regexp = false;

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the regexp
	 */
	public boolean isRegexp() {
		return regexp;
	}

	/**
	 * @param regexp
	 *            the regexp to set
	 */
	public void setRegexp(boolean regexp) {
		this.regexp = regexp;
	}

}
