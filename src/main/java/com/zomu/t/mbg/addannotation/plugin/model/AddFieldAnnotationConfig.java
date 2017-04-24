package com.zomu.t.mbg.addannotation.plugin.model;

import java.util.List;

/**
 * アノテーション・フィールド追加定義.
 * 
 * @author takashno
 *
 */
public class AddFieldAnnotationConfig {

	/** アノテーション定義 */
	private List<AnnotationConfig> annotations;

	/**
	 * @return the annotations
	 */
	public List<AnnotationConfig> getAnnotations() {
		return annotations;
	}

	/**
	 * @param annotations
	 *            the annotations to set
	 */
	public void setAnnotations(List<AnnotationConfig> annotations) {
		this.annotations = annotations;
	}

}
