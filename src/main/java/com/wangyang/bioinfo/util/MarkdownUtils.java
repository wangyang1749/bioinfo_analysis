package com.wangyang.bioinfo.util;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author wangyang
 * @date 2021/6/14
 */
public class MarkdownUtils {
    private static final DataHolder OPTIONS = new MutableDataSet()
            .set(Parser.EXTENSIONS, Arrays.asList()).set(HtmlRenderer.SOFT_BREAK, "<br/>");


    private static final Parser PARSER = Parser.builder(OPTIONS).build();
    private static final HtmlRenderer RENDERER = HtmlRenderer.builder(OPTIONS).build();

    public static String renderHtmlOutput(String markdown) {
        if(StringUtils.isBlank(markdown)){
            return null;
        }
        Node document = PARSER.parse(markdown);
        String render = RENDERER.render(document);
        return render;
    }
}
