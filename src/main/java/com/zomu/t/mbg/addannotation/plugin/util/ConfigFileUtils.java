package com.zomu.t.mbg.addannotation.plugin.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.zomu.t.mbg.addannotation.plugin.model.AddFieldAnnotationConfig;
import com.zomu.t.mbg.addannotation.plugin.model.AnnotationConfig;
import com.zomu.t.mbg.addannotation.plugin.model.ColumnConfig;
import com.zomu.t.mbg.addannotation.plugin.model.TableConfig;

public class ConfigFileUtils {

	public static void main(String[] args) {
		getConfig();
	}

	public static AddFieldAnnotationConfig read(String path) {
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		try {
			System.out.println("★：" + path);
			return om.readValue(new File(path), AddFieldAnnotationConfig.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static AddFieldAnnotationConfig readFromString(String content) {
		ObjectMapper om = new ObjectMapper(new YAMLFactory());
		try {
			return om.readValue(content, AddFieldAnnotationConfig.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static List<AddFieldAnnotationConfig> getConfig() {

		AddFieldAnnotationConfig config = new AddFieldAnnotationConfig();

		List<AnnotationConfig> annotations = new ArrayList<AnnotationConfig>();
		config.setAnnotations(annotations);

		AnnotationConfig annotation = new AnnotationConfig();
		annotation.setFullQueryAnnotationName("com.zomu.t.test.Annoataion");

		TableConfig tc = new TableConfig();
		tc.setTableName("table1");
		tc.setRegexp(false);
		annotation.getTableConfigs().add(tc);

		ColumnConfig cc1 = new ColumnConfig();
		cc1.setColumnName("column1");
		tc.getColumnConfigs().add(cc1);

		ColumnConfig cc2 = new ColumnConfig();
		cc2.setColumnName("column2");
		tc.getColumnConfigs().add(cc2);

		annotations.add(annotation);

		ObjectMapper om = new ObjectMapper(new YAMLFactory());

		StringWriter sw = new StringWriter();

		try {
			om.writeValue(sw, config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sw.toString());

		AddFieldAnnotationConfig readResult = readFromString(sw.toString());

		return null;

	}
}
