package com.zomu.t.mbg.addannotation.plugin.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zomu.t.mbg.addannotation.plugin.model.AddFieldAnnotationConfig;

/**
 * 定義ファイルを扱うユーティリティ．
 * 
 * @author takashno
 *
 */
public final class ConfigFileUtils {

	/**
	 * ファイルパスから定義ファイルを読み込み、パースします.
	 * 
	 * @param path
	 * @return
	 */
	public static AddFieldAnnotationConfig read(String path) {
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		try {
			return om.readValue(new File(path), AddFieldAnnotationConfig.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 文字列から定義を読み込み、パースします.
	 * 
	 * @param content
	 * @return
	 */
	public static AddFieldAnnotationConfig readFromString(String content) {
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		try {
			return om.readValue(content, AddFieldAnnotationConfig.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
