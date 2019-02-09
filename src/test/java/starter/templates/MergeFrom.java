package starter.templates;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * An example of a class used to create test data from JSON templates using Freemarker.
 */
public class MergeFrom {
    private String templateFile;
    private Map<String, String> defaultValues;

    private static FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate();

    public MergeFrom(String templateFile) {
        this.templateFile = templateFile;
    }

    public static MergeFrom template(String template) {
        return new MergeFrom(template);
    }

    public MergeFrom withDefaultValuesFrom(Map<String, String> defaultValues) {
        this.defaultValues = defaultValues;
        return this;
    }

    public String withFieldsFrom(Map<String, String> fieldValues) {
        Map<String, String> fieldDictionary = new HashMap<>(defaultValues);
        fieldDictionary.putAll(fieldValues);

        Template template = freemarkerTemplate.getTemplate(templateFile);

        Writer writer = new StringWriter();

        try {
            template.process(fieldDictionary, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Failed to merge test data template", e);
        }

        return writer.toString();
    }
}
