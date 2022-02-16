package com.envioemail.zup.envioemailpoc.input.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRecusedDto implements Serializable {

    @NotBlank(message="Preenchimento de nome é obrigatório")
    @Length(min=3, max=120, message="O tamanho deve estar entre 5 e 120 caracteres")
    private String nomeCliente;
    @Email
    private String emailCliente;
    @NotNull(message="Não pode ser nulo")
    private Integer orderNumber;
    @NotBlank(message="Não pode ser nulo")
    private String motivo;


}
