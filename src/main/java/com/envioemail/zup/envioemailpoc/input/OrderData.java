package com.envioemail.zup.envioemailpoc.input;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderData implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotBlank(message="Preenchimento de nome é obrigatório")
    @Length(min=3, max=120, message="O tamanho deve estar entre 5 e 120 caracteres")
    private String nomeCliente;
    @Email
    private String emailCliente;
    @NotNull(message="Não pode ser nulo")
    private Integer orderNumber;
    @NotNull(message="Não pode ser nulo")
    private Double totalOrder;
    private List<ProductData> prods = new ArrayList<ProductData>();

    public Double getTotalOrder() {
        return somaTotal();
    }

    public Double somaTotal(){

        Double total = 0.;

        for (int i = 0; i < prods.size(); i++){
            total = total +prods.get(i).getSubTotal();
        }

        return total;
    }
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
