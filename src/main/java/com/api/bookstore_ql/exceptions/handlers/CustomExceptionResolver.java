package com.api.bookstore_ql.exceptions.handlers;

import com.api.bookstore_ql.exceptions.AuthorAlreadyExistsException;
import com.api.bookstore_ql.exceptions.AuthorNotFoundException;
import com.api.bookstore_ql.exceptions.BookAlreadyExistsException;
import com.api.bookstore_ql.exceptions.BookNotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env){
        return switch (ex){
            case AuthorAlreadyExistsException e -> GraphqlErrorBuilder.newError()
                        .errorType(ErrorType.BAD_REQUEST)
                        .message(e.getMessage())
                        .path(env.getExecutionStepInfo().getPath())
                        .location(env.getField().getSourceLocation())
                        .build();

            case AuthorNotFoundException e -> GraphqlErrorBuilder.newError()
                        .errorType(ErrorType.NOT_FOUND)
                        .message(e.getMessage())
                        .path(env.getExecutionStepInfo().getPath())
                        .location(env.getField().getSourceLocation())
                        .build();

            case BookAlreadyExistsException e -> GraphqlErrorBuilder.newError()
                        .errorType(ErrorType.BAD_REQUEST)
                        .message(e.getMessage())
                        .path(env.getExecutionStepInfo().getPath())
                        .location(env.getField().getSourceLocation())
                        .build();

            case BookNotFoundException e -> GraphqlErrorBuilder.newError()
                        .errorType(ErrorType.NOT_FOUND)
                        .message(e.getMessage())
                        .path(env.getExecutionStepInfo().getPath())
                        .location(env.getField().getSourceLocation())
                        .build();

            default -> null;
        };

    }
}
