package ru.practicum.ewm.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiError handleConstraintViolationException(ConstraintViolationException exception) {
        return new ApiError(
                BAD_REQUEST.value(),
                "BAD_REQUEST",
                exception.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return new ApiError(
                BAD_REQUEST.value(),
                "BAD_REQUEST",
                "Ошибка валидации: " + exception.getMessage()
        );
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerValidationException(ValidationException exception) {
        return new ApiError(
                BAD_REQUEST.value(),
                "BAD_REQUEST",
                exception.getMessage()
        );
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiError handleNotFoundException(NotFoundException exception) {
        return new ApiError(
                NOT_FOUND.value(),
                "NOT_FOUND",
                exception.getMessage()
        );
    }

    @ExceptionHandler(DuplicatedDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleDuplicatedDataException(DuplicatedDataException exception) {
        log.warn("DuplicatedDataException: {}", exception.getMessage());
        return new ApiError(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                exception.getMessage()
        );
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflictException(ConflictException exception) {
        log.warn("ConflictException: {}", exception.getMessage());
        return new ApiError(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                exception.getMessage()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiError handleIllegalArgumentException(IllegalArgumentException exception) {
        return new ApiError(
                BAD_REQUEST.value(),
                "BAD_REQUEST",
                exception.getMessage()
        );
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiError handleIllegalStateException(IllegalStateException exception) {
        return new ApiError(
                BAD_REQUEST.value(),
                "BAD_REQUEST",
                exception.getMessage()
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        log.warn("DataIntegrityViolationException: {}", exception.getMessage());
        return new ApiError(
                HttpStatus.CONFLICT.value(),
                "CONFLICT",
                "Нарушение уникальности данных: " + exception.getMessage()
        );
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiError handleForbiddenException(ForbiddenException exception) {
        log.info("403 {}", exception.getMessage(), exception);
        return new ApiError(
                HttpStatus.FORBIDDEN.value(),
                "For the requested operation the conditions are not met.",
                exception.getMessage()
        );
    }

    @ExceptionHandler(IncorrectRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleIncorrectRequestException(IncorrectRequestException exception) {
        log.info("400 {}", exception.getMessage(), exception);
        return new ApiError(
                BAD_REQUEST.value(),
                "Incorrectly made request.",
                exception.getMessage()
        );
    }
}