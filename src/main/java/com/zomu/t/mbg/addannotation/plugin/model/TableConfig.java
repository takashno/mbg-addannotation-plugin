package com.zomu.t.mbg.addannotation.plugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author takashimanozomu
 *
 */
public class TableConfig {

	/** テーブル名 */
	private String tableName;

	/** 正規表現かどうか */
	private boolean regexp = false;

	/** カラムリスト */
	private List<ColumnConfig> columnConfigs = new ArrayList<ColumnConfig>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isRegexp() {
		return regexp;
	}

	public void setRegexp(boolean regexp) {
		this.regexp = regexp;
	}

	public List<ColumnConfig> getColumnConfigs() {
		return columnConfigs;
	}

	public void setColumnConfigs(List<ColumnConfig> columnConfigs) {
		this.columnConfigs = columnConfigs;
	}

}
