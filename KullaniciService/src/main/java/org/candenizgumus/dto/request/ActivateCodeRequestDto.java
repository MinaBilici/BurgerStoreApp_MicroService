package org.candenizgumus.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Data
public class ActivateCodeRequestDto {
    String email;
    String activationCode;


}
