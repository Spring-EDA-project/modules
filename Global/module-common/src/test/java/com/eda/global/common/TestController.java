package com.eda.global.common;

import com.eda.global.common.error.exception.BadRequestException;
import com.eda.global.common.error.exception.ConflictException;
import com.eda.global.common.error.exception.EntityNotFoundException;
import com.eda.global.common.error.exception.ForbiddenException;
import com.eda.global.common.error.exception.InternalServerErrorException;
import com.eda.global.common.error.exception.InvalidInputValueException;
import com.eda.global.common.error.exception.MethodNotAllowedException;
import com.eda.global.common.error.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/bad-request")
    public void throwBadRequestException() {
        throw new BadRequestException();
    }

    @GetMapping("/conflict")
    public void throwConflictException() {
        throw new ConflictException();
    }

    @GetMapping("/entity-not-found")
    public void throwEntityNotFoundException() {
        throw new EntityNotFoundException();
    }

    @GetMapping("/forbidden")
    public void throwForbiddenException() {
        throw new ForbiddenException();
    }

    @GetMapping("/internal-server-error")
    public void throwInternalServerErrorException() {
        throw new InternalServerErrorException();
    }

    @GetMapping("/invalid-input-value")
    public void throwInvalidInputValueException() {
        throw new InvalidInputValueException();
    }

    @GetMapping("method-not-allowed")
    public void throwMethodNotAllowedException() {
        throw new MethodNotAllowedException();
    }

    @GetMapping("/unauthorized")
    public void throwUnauthorizedException() {
        throw new UnauthorizedException();
    }
}
