package com.envioemail.zup.envioemailpoc.input;

import lombok.*;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderData implements Serializable {

    private String nomeCliente;
    private String emailCliente;
    private Integer orderNumber;
    private Double totalOrder;
    private List<ProductData> prods = new ArrayList<ProductData>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        sb.append(", Nome Cliente=").append(nomeCliente );
        sb.append(", Email Cliente=").append(emailCliente );
        sb.append(", Num pedido=").append(orderNumber);

        totalOrder =0.;

        for (int i = 0; i < prods.size(); i++){
            sb.append(", produto='").append(prods.get(i).getName()).append('\'');
            sb.append(", quantidade=").append(prods.get(i).getQuantity());
            sb.append(", precoUnitario=").append(nf.format(prods.get(i).getUnitPrice()));
            sb.append(", subTotal=").append(nf.format(prods.get(i).getSubTotal()));
            sb.append("\n");
            totalOrder = totalOrder +prods.get(i).getSubTotal();
        }
        sb.append(", Total=").append(nf.format(totalOrder));
        sb.append("\n");

        return sb.toString();
    }
}
