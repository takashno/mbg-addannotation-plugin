package com.zomu.t.mbg.addannotation.plugin.model;

import java.util.ArrayList;
import java.util.List;

public class AnnotationConfig {

	/** FQCNのアノテーション名 */
	private String fullQueryAnnotationName;

	/** テーブルカラム名マップ */
	private List<TableConfig> tableConfigs = new ArrayList<TableConfig>();

	public String getFullQueryAnnotationName() {
		return fullQueryAnnotationName;
	}

	public void setFullQueryAnnotationName(String fullQueryAnnotationName) {
		this.fullQueryAnnotationName = fullQueryAnnotationName;
	}

	public List<TableConfig> getTableConfigs() {
		return tableConfigs;
	}

	public void setTableConfigs(List<TableConfig> tableConfigs) {
		this.tableConfigs = tableConfigs;
	}

}
