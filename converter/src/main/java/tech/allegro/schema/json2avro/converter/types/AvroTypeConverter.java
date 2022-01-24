package tech.allegro.schema.json2avro.converter.types;

import org.apache.avro.Schema;

import java.util.Deque;

public interface AvroTypeConverter {
    /**
     * This object should be returned by `convert` method when silently is false when the value type is not compatible with the avro type
     */
    Object INCOMPATIBLE = new Object();

    /**
     * convert the json jsonValue to the avro jsonValue
     *
     * @param field the field to convert
     * @param schema the schema of the field
     * @param jsonValue the json jsonValue
     * @param path the path of the field
     * @param silently should be false to throw an error in case of incompatible java type for the avro type
     *
     * @return the converted jsonValue
     */
    Object convert(Schema.Field field, Schema schema, Object jsonValue, Deque<String> path, boolean silently);

    /**
     * used to know if this class can convert the json value to the avro value
     *
     * @param schema the avro schema in which to convert the json
     * @param path the path of the current field. Can be used to define a specific converter for a path
     *
     * @return true if this class should be used to convert the value
     */
    boolean canManage(Schema schema, Deque<String> path);
}