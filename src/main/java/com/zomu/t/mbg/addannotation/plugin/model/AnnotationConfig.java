package com.zomu.t.mbg.addannotation.plugin.model;

import java.util.ArrayList;
import java.util.List;

/**
 * アノテーション定義.
 * 
 * @author takashno
 *
 */
public class AnnotationConfig {

	/** FQCNのアノテーション名 */
	private String fullQueryAnnotationName;

	/** テーブルカラム名マップ */
	private List<TableConfig> tableConfigs = new ArrayList<TableConfig>();

	/**
	 * @return the fullQueryAnnotationName
	 */
	public String getFullQueryAnnotationName() {
		return fullQueryAnnotationName;
	}

	/**
	 * @param fullQueryAnnotationName
	 *            the fullQueryAnnotationName to set
	 */
	public void setFullQueryAnnotationName(String fullQueryAnnotationName) {
		this.fullQueryAnnotationName = fullQueryAnnotationName;
	}

	/**
	 * @return the tableConfigs
	 */
	public List<TableConfig> getTableConfigs() {
		return tableConfigs;
	}

	/**
	 * @param tableConfigs
	 *            the tableConfigs to set
	 */
	public void setTableConfigs(List<TableConfig> tableConfigs) {
		this.tableConfigs = tableConfigs;
	}

}
