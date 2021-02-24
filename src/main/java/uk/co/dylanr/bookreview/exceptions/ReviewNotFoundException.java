package uk.co.dylanr.bookreview.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Review does not exist in db!")
public class ReviewNotFoundException extends EntityNotFoundException {

}