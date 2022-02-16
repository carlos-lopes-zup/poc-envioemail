package com.envioemail.zup.envioemailpoc.input;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductData implements Serializable {

    /**
     *
     *
     *
     */
    private static final long serialVersionUID = 1L;

    @NotBlank(message="Preenchimento de nome produto é obrigatório")
    @Length(min=3, max=120, message="O tamanho deve estar entre 3 e 120 caracteres")
    private String name;
    @Positive
    @NotNull(message="Não pode ser nulo")
    private Integer quantity;
    @NotNull(message="Não pode ser nulo")
    private Double unitPrice;
    private Double subTotal;

    public ProductData(String name, Integer quantity, Double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Double getSubTotal() {
        return unitPrice * quantity;
    }
}
