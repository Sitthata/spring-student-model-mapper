package sit.example.int204springapi.exception.Impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ValidationError {
    private final String field;
    private final String message;
}
