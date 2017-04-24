package com.zomu.t.mbg.addannotation.plugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * テーブル定義.
 * 
 * @author takashno
 *
 */
public class TableConfig {

	/** テーブル名 */
	private String tableName;

	/** 正規表現かどうか */
	private boolean regexp = false;

	/** カラムリスト */
	private List<ColumnConfig> columnConfigs = new ArrayList<ColumnConfig>();

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName
	 *            the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
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

	/**
	 * @return the columnConfigs
	 */
	public List<ColumnConfig> getColumnConfigs() {
		return columnConfigs;
	}

	/**
	 * @param columnConfigs
	 *            the columnConfigs to set
	 */
	public void setColumnConfigs(List<ColumnConfig> columnConfigs) {
		this.columnConfigs = columnConfigs;
	}

}
