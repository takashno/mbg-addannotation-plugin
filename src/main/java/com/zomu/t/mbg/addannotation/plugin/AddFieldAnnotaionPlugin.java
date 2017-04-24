package com.zomu.t.mbg.addannotation.plugin;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import com.zomu.t.mbg.addannotation.plugin.model.AddFieldAnnotationConfig;
import com.zomu.t.mbg.addannotation.plugin.model.AnnotationConfig;
import com.zomu.t.mbg.addannotation.plugin.model.ColumnConfig;
import com.zomu.t.mbg.addannotation.plugin.model.TableConfig;
import com.zomu.t.mbg.addannotation.plugin.util.ConfigFileUtils;

/**
 * フィールドにアノテーションを付与するためのプラグイン.
 * 
 * @author takashimanozomu
 *
 */
public class AddFieldAnnotaionPlugin extends PluginAdapter {

	/** 設定ファイルパス */
	private String configFilePath;

	/** フィールドアノテーション追加設定 */
	private AddFieldAnnotationConfig config;

	/**
	 * コンストラクタ
	 */
	public AddFieldAnnotaionPlugin() {
		super();
	}

	/**
	 * チェック処理
	 */
	public boolean validate(List<String> warnings) {
		configFilePath = properties.getProperty("configFilePath");
		if (StringUtils.isEmpty(configFilePath)) {
			return false;
		}
		config = ConfigFileUtils.read(configFilePath);
		if (config == null) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * <hr/>
	 * フィールドにアノテーションを付与します.
	 */
	@Override
	public boolean modelFieldGenerated(Field field,
			TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable,
			Plugin.ModelClassType modelClassType) {

		for (AnnotationConfig ac : config.getAnnotations()) {

			for (TableConfig tc : ac.getTableConfigs()) {

				boolean targetTable = false;

				// 正規表現フラグが設定されていたら、正規表現で判定する
				if (tc.isRegexp()) {
					Pattern p = Pattern.compile(tc.getTableName());
					Matcher m = p.matcher(introspectedTable
							.getTableConfiguration().getTableName());
					targetTable = m.find();
				} else {
					targetTable = StringUtils.equals(introspectedTable
							.getTableConfiguration().getTableName(), tc
							.getTableName());
				}

				// 対象のテーブルでなければ次のテーブルへ処理を進める
				if (!targetTable) {
					continue;
				}

				// カラムを処理する
				for (ColumnConfig cc : tc.getColumnConfigs()) {

					boolean targetColumn = false;

					// 正規表現フラグが設定されていたら、正規表現で判定する
					if (cc.isRegexp()) {
						Pattern p = Pattern.compile(cc.getColumnName());
						Matcher m = p.matcher(introspectedColumn
								.getActualColumnName());
						targetColumn = m.find();
					} else {
						targetColumn = StringUtils.equals(
								introspectedColumn.getActualColumnName(),
								cc.getColumnName());
					}

					// 対象カラムでなければ次のカラムへ処理を進める
					if (!targetColumn) {
						continue;
					}

					// アノテーション追加
					field.addAnnotation("@"
							+ ClassUtils.getShortCanonicalName(ac
									.getFullQueryAnnotationName()));
					topLevelClass.addImportedType(new FullyQualifiedJavaType(ac
							.getFullQueryAnnotationName()));

				}

			}
		}
		return true;
	}
}
