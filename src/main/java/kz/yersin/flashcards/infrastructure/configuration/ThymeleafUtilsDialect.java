package kz.yersin.flashcards.infrastructure.configuration;

import kz.yersin.flashcards.infrastructure.util.PresentationUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Set;

public class ThymeleafUtilsDialect extends AbstractDialect implements IExpressionObjectDialect {

    private static final String PRESENTATION_UTILS_EXPRESSION_OBJECT_NAME = "utils";
    private static final Set<String> ALL_EXPRESSION_OBJECT_NAMES = Set.of(PRESENTATION_UTILS_EXPRESSION_OBJECT_NAME);

    public ThymeleafUtilsDialect() {
        super(PRESENTATION_UTILS_EXPRESSION_OBJECT_NAME);
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new IExpressionObjectFactory() {
            @Override
            public Set<String> getAllExpressionObjectNames() {
                return ALL_EXPRESSION_OBJECT_NAMES;
            }

            @Override
            public Object buildObject(IExpressionContext context, String expressionObjectName) {
                if (PRESENTATION_UTILS_EXPRESSION_OBJECT_NAME.equals(expressionObjectName)) {
                    return new PresentationUtils();
                }
                return null;
            }

            @Override
            public boolean isCacheable(String expressionObjectName) {
                return true;
            }
        };
    }

}
