package starter.templates;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * An example of a Freemarker template engine, used to generate test data for REST API testing.
 */
public class FreemarkerTemplate {

    private Configuration configuration = null;

    private Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration(Configuration.VERSION_2_3_28);
            configuration.setDefaultEncoding("UTF-8");
            configuration.setClassForTemplateLoading(FreemarkerTemplate.class, "/");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }

        return configuration;
    }

    /**
     * The template file should be in the "src/test/resources/templates" directory.
     * @param templateFile
     * @return
     */
    public Template getTemplate(String templateFile) {
        try {
            return getConfiguration().getTemplate(templateFile);
        } catch (Exception e) {
            throw new IllegalStateException("Could not find template " + templateFile, e);
        }
    }

}
