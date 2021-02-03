package com.feiyu.data.ocean.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.io.StringWriter;

/**
 *
 * JSON序列化、反序列化工具类
 *
 */
public class JsonWriter {

	/**
	 * om
	 */
	private static ObjectMapper om = new ObjectMapper();

	/**
	 * jf
	 */
	private static JsonFactory jf = new JsonFactory();

	/**
	 * 序列化成JSON字符串，并且去除value为null的属性
	 *
	 * @param pojo
	 *            pojo
	 * @param prettyPrint
	 *            prettyPrint
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String toJsonExcludeNull(Object pojo) {

		try {
			ObjectMapper om = new ObjectMapper();
			StringWriter sw = new StringWriter();
			JsonGenerator jg = jf.createJsonGenerator(sw);
			om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			om.setSerializationInclusion(Include.NON_NULL);
			om.writeValue(jg, pojo);
			return sw.toString();
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}

	}

	/**
	 * 将JSON字符串反序列化成对象
	 *
	 * @param jsonAsString
	 *            jsonAsString
	 * @param pojoClass
	 *            pojoClass
	 * @param <T>
	 *            <T>
	 * @return <T>
	 */
	public static <T> Object fromJson(String jsonAsString, Class<T> pojoClass) {

		try {
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			return om.readValue(jsonAsString, pojoClass);
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}

	}

	/**
	 * 将JSON字符串反序列化成对象
	 *
	 * @param jsonAsString
	 *            jsonAsString
	 * @param javaType
	 *            javaType
	 * @param <T>
	 *            <T>
	 * @return <T>
	 */
	public static <T> Object fromJson(String jsonAsString, JavaType javaType) {

		try {
			om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			return om.readValue(jsonAsString, javaType);
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}

	}

	/**
	 * 序列化成JSON字符串
	 *
	 * @param pojo
	 *            pojo
	 * @param prettyPrint
	 *            prettyPrint
	 * @return String
	 */
	public static String toJson(Object pojo, boolean prettyPrint) {

		try {
			ObjectMapper om = new ObjectMapper();
			// null替换为""
			om.getSerializerProvider().setNullValueSerializer(
					new JsonSerializer<Object>() {
						@Override
						public void serialize(Object arg0, JsonGenerator arg1,
								SerializerProvider arg2) throws IOException,
								JsonProcessingException {
							arg1.writeString("");
						}
					});
			StringWriter sw = new StringWriter();
			JsonGenerator jg = jf.createGenerator(sw);

			if (prettyPrint) {
				jg.useDefaultPrettyPrinter();
			}
			om.writeValue(jg, pojo);
			return sw.toString();
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}

	}

	/**
	 * 序列化成JSON字符串，并去除空格减少字节数
	 *
	 * @param pojo
	 *            pojo
	 * @return String
	 */
	public static String toJson(Object pojo) {

		return toJson(pojo, false);
	}

	/**
	 * 生成一个Collection Type
	 *
	 * @param collectionClass
	 *            collectionClass
	 * @param elementClasses
	 *            elementClasses
	 * @return JavaType
	 */
	public static JavaType getCollectionType(Class<?> collectionClass,
                                             Class<?>... elementClasses) {

		return new ObjectMapper().getTypeFactory().constructParametricType(
				collectionClass, elementClasses);
	}

	// public static void main(String[] args) {
	// CorpABSInfo info = new CorpABSInfo();
	// info.setBasicAssetsType("tsdt");
	// info.setCorpName(null);
	// System.out.println(toJson(info));// TestObject必须是POJO对象
	// }
}
