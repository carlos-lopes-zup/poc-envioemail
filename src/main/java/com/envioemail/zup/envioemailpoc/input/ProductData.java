package com.envioemail.zup.envioemailpoc.input;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductData {

    private String name;
    private Integer quantity;
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
