package edu.homework.commands;

import edu.homework.Catalog;

import edu.homework.exceptions.InvalidFileException;
import edu.homework.exceptions.InvalidTemplateException;
import freemarker.core.ParseException;
import freemarker.template.*;

import java.io.*;

public class ReportCommand implements Command{
    @Override
    public void run(Catalog catalog){
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
            configuration.setDirectoryForTemplateLoading(new File("freemarker/"));
            Template template = configuration.getTemplate("template.ftlh");

            Writer out =  new OutputStreamWriter(new FileOutputStream("freemarker/" + catalog.getName() + ".html"));
            template.process(catalog, out);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

    }
}
